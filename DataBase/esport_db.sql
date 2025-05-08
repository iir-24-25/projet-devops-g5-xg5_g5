-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: May 08, 2025 at 08:58 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `esport_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `password`, `username`) VALUES
(1, 'oussama123', 'Oussama');

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`id`, `name`, `platform`, `image_url`) VALUES
(3, 'CounterStrike GO', 'Steam', '/images/csgo.jpg'),
(4, 'League Of Legends (LoL)', 'Riot Games', '/images/lol.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `id` bigint(20) NOT NULL,
  `result_id` bigint(20) DEFAULT NULL,
  `teama_id` bigint(20) DEFAULT NULL,
  `teamb_id` bigint(20) DEFAULT NULL,
  `tournament_id` bigint(20) DEFAULT NULL,
  `match_date` datetime(6) DEFAULT NULL,
  `match_result_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`id`, `result_id`, `teama_id`, `teamb_id`, `tournament_id`, `match_date`, `match_result_id`) VALUES
(10, NULL, 2, 3, 3, NULL, 13),
(11, NULL, 4, 5, 3, NULL, 14),
(12, NULL, 6, 7, 3, NULL, 15),
(13, NULL, 8, 9, 3, NULL, 16),
(14, NULL, 3, 4, 3, NULL, 17),
(15, NULL, 6, 9, 3, NULL, 18),
(16, NULL, 4, 9, 3, NULL, 19);

-- --------------------------------------------------------

--
-- Table structure for table `match_results`
--

CREATE TABLE `match_results` (
  `id` bigint(20) NOT NULL,
  `teamascore` int(11) NOT NULL,
  `teambscore` int(11) NOT NULL,
  `winner` varchar(255) DEFAULT NULL,
  `winner_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `match_results`
--

INSERT INTO `match_results` (`id`, `teamascore`, `teambscore`, `winner`, `winner_id`) VALUES
(2, 2, 13, 'Navi', NULL),
(3, 3, 13, 'Navi', NULL),
(4, 3, 13, 'Navi', NULL),
(13, 2, 13, NULL, 3),
(14, 13, 11, NULL, 4),
(15, 13, 7, NULL, 6),
(16, 7, 13, NULL, 9),
(17, 5, 13, NULL, 4),
(18, 11, 13, NULL, 9),
(19, 13, 10, NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

CREATE TABLE `players` (
  `id` bigint(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `players`
--

INSERT INTO `players` (`id`, `age`, `nationality`, `username`, `image_url`) VALUES
(1, 24, 'Marocain', 'Blood', NULL),
(2, 23, 'Marocain', 'DarkSide', NULL),
(3, 22, 'Marocain', 'Belg', NULL),
(4, 23, 'Marocain', 'Sam', NULL),
(5, 22, 'Marocain', 'Mims', NULL),
(6, 29, 'Ukraine', 'S1mple', '/images/S1mple.jpg'),
(7, 31, 'Ukraine', 'b1t', NULL),
(8, 33, 'Ukraine', 'm0NESY', NULL),
(9, 33, 'Ukraine', 'Starix', NULL),
(10, 34, 'Ukraine', 'flamie', NULL),
(11, 25, 'Russian', 'Ax1Le', NULL),
(12, 24, 'USA', 'Xeppaa', '/images/Xeppaa.png'),
(13, 23, 'USA', 'nafany', '/images/nafany.png'),
(14, 30, 'Canadian', 'Shroud', '/images/Shroud.png'),
(15, 27, 'USA', 'Stewie2k', '/images/Stewie2k.png'),
(16, 28, 'Denmark', 'Karrigan', '/images/Karrigan.png'),
(17, 30, 'Norwegian', 'Rain', '/images/Rain.png'),
(18, 27, 'USA', 'Elige', '/images/Elige.png'),
(19, 22, 'Slovakien', 'Frozen', '/images/Frozen.png'),
(20, 24, 'Latvian', 'Broky', '/images/Broky.png'),
(21, 25, 'Denmak', 'Caps', '/images/Caps.png'),
(22, 29, 'Denmark', 'HooXI', '/images/Hooxi.png'),
(23, 29, 'French', 'KennyS', '/images/KennyS.png'),
(24, 29, 'Australien', 'jks', '/images/jks.png'),
(25, 28, 'Russian', 'Nikola ', '/images/Nikola.png'),
(26, 24, 'Canadian', 'TenZ', '/images/TenZ.png'),
(27, 22, 'USA', 'Curry', '/images/Curry.png'),
(28, 27, 'Brazil', 'Sacy', '/images/Sacy.png'),
(29, 25, 'Brazil', 'pANcada', '/images/pANcada.png'),
(30, 27, 'USA', 'Zellsis', '/images/Zellsis.png'),
(31, 25, 'USA', 'oSee', '/images/oSee.png'),
(32, 25, 'Latvian', 'YEKINDAR', '/images/Latvian.png'),
(33, 29, 'Canadian', 'nitr0', '/images/nitr0.png'),
(34, 35, 'Eric', 'Eric Hoag', '/images/Eric.png'),
(35, 27, 'Canadian', 'NAF', '/images/NAF.png'),
(36, 26, 'Swedish', 'Rekkles', '/images/Rekkles.png'),
(37, 19, 'USA', 'Oscarinin', '/images/oscarinin.png'),
(38, 21, 'Swedish', 'Leo', '/images/Leo.png'),
(39, 20, 'Finnish', 'Cyanide', '/images/Cyanide.jpg'),
(40, 33, 'French', 'YellOwStaR', '/images/YellOwStaR.png');

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `id` bigint(20) NOT NULL,
  `captain` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`id`, `captain`, `name`, `country`, `image_url`) VALUES
(2, 'Blood', 'Nexus', 'Morocco', '/images/nexuus.jpg'),
(3, 'S1mple', 'Navi', 'Ukraine', '/images/Navi.png'),
(4, 'Shroud', 'Cloud9', 'USA', '/images/cloud9.png'),
(5, 'Karrigan', 'Faze Clan', 'USA', '/images/faze.png'),
(6, 'Caps', 'G2esports', 'Germany', '/images/G2esports.png'),
(7, 'TenZ', 'Sentinels', 'USA', '/images/Sentinels.png'),
(8, 'NAF', 'TeamLiquid', 'Netherlands', '/images/TeamLiquid.png'),
(9, 'Rekkles', 'Fnatic', 'UK', '/images/Fnatic.png');

-- --------------------------------------------------------

--
-- Table structure for table `team_players`
--

CREATE TABLE `team_players` (
  `team_id` bigint(20) NOT NULL,
  `player_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `team_players`
--

INSERT INTO `team_players` (`team_id`, `player_id`) VALUES
(3, 6),
(3, 7),
(3, 8),
(3, 9),
(3, 10),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(4, 14),
(4, 11),
(4, 12),
(4, 13),
(4, 15),
(5, 20),
(5, 19),
(5, 18),
(5, 17),
(5, 16),
(6, 25),
(6, 24),
(6, 23),
(6, 22),
(6, 21),
(7, 30),
(7, 29),
(7, 28),
(7, 27),
(7, 26),
(8, 35),
(8, 34),
(8, 33),
(8, 32),
(8, 31),
(9, 40),
(9, 39),
(9, 38),
(9, 37),
(9, 36);

-- --------------------------------------------------------

--
-- Table structure for table `tournaments`
--

CREATE TABLE `tournaments` (
  `id` bigint(20) NOT NULL,
  `end_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prize_pool` double DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `winner_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tournaments`
--

INSERT INTO `tournaments` (`id`, `end_date`, `name`, `prize_pool`, `start_date`, `game_id`, `image_url`, `winner_id`) VALUES
(3, '2025-07-01', 'CLS', 10000, '2025-05-08', 3, '/images/CLS.png', 4);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `password`, `role`, `username`, `full_name`, `email`) VALUES
(1, 'oussama123', NULL, 'Sekiro', 'OUSSAMA BENHIDA', 'Oussama.Benhida@emsi-edu.ma'),
(3, 'oussama123', NULL, 'DarkSIde', 'Yassir Benjima', 'Yassir.Benjima@emsi-edu.ma');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKffkgtn1h8xie1lgpeabmx23sb` (`result_id`),
  ADD UNIQUE KEY `UKtli7dbkqh9twspt1tkjaajtg6` (`match_result_id`),
  ADD KEY `FKad201e1i54u4uu7ktkxo9jvq7` (`teama_id`),
  ADD KEY `FK9qbj89kw20wkdbu4d1k9ay2s1` (`teamb_id`),
  ADD KEY `FKeeniokyjgo5k6rmhjujatn27i` (`tournament_id`);

--
-- Indexes for table `match_results`
--
ALTER TABLE `match_results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK223cjxlv36ulpjhqwtffxsoq2` (`winner_id`);

--
-- Indexes for table `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `team_players`
--
ALTER TABLE `team_players`
  ADD KEY `FKddxneji5ow8j3171oe6mc2gu0` (`player_id`),
  ADD KEY `FK3bhsykltbdhsmmb61l2ml12h` (`team_id`);

--
-- Indexes for table `tournaments`
--
ALTER TABLE `tournaments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk8huhgsk5r59hdsg8y9ek3df8` (`game_id`),
  ADD KEY `FK69mm7ax8uuhefov9a25qdvhh1` (`winner_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `games`
--
ALTER TABLE `games`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `matches`
--
ALTER TABLE `matches`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `match_results`
--
ALTER TABLE `match_results`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `players`
--
ALTER TABLE `players`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `teams`
--
ALTER TABLE `teams`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tournaments`
--
ALTER TABLE `tournaments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `matches`
--
ALTER TABLE `matches`
  ADD CONSTRAINT `FK9qbj89kw20wkdbu4d1k9ay2s1` FOREIGN KEY (`teamb_id`) REFERENCES `teams` (`id`),
  ADD CONSTRAINT `FKad201e1i54u4uu7ktkxo9jvq7` FOREIGN KEY (`teama_id`) REFERENCES `teams` (`id`),
  ADD CONSTRAINT `FKeeniokyjgo5k6rmhjujatn27i` FOREIGN KEY (`tournament_id`) REFERENCES `tournaments` (`id`),
  ADD CONSTRAINT `FKgxcwjaacx854cfv0paelsp53t` FOREIGN KEY (`result_id`) REFERENCES `match_results` (`id`),
  ADD CONSTRAINT `FKskxwt7murw1ur8mxmxkchvbjb` FOREIGN KEY (`match_result_id`) REFERENCES `match_results` (`id`);

--
-- Constraints for table `match_results`
--
ALTER TABLE `match_results`
  ADD CONSTRAINT `FK223cjxlv36ulpjhqwtffxsoq2` FOREIGN KEY (`winner_id`) REFERENCES `teams` (`id`);

--
-- Constraints for table `team_players`
--
ALTER TABLE `team_players`
  ADD CONSTRAINT `FK3bhsykltbdhsmmb61l2ml12h` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`),
  ADD CONSTRAINT `FKddxneji5ow8j3171oe6mc2gu0` FOREIGN KEY (`player_id`) REFERENCES `players` (`id`);

--
-- Constraints for table `tournaments`
--
ALTER TABLE `tournaments`
  ADD CONSTRAINT `FK69mm7ax8uuhefov9a25qdvhh1` FOREIGN KEY (`winner_id`) REFERENCES `teams` (`id`),
  ADD CONSTRAINT `FKk8huhgsk5r59hdsg8y9ek3df8` FOREIGN KEY (`game_id`) REFERENCES `games` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
