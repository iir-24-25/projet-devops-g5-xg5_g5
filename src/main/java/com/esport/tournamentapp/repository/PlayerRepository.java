package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByUsernameContainingIgnoreCaseAndNationalityContainingIgnoreCase(String username, String nationality);

}
