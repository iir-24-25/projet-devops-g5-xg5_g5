package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Tournament;
import com.esport.tournamentapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    @Autowired private PlayerRepository playerRepo;
    @Autowired private TeamRepository teamRepo;
    @Autowired private TournamentRepository tournamentRepo;
    @Autowired private MatchRepository matchRepo;
    @Autowired private UserRepository userRepository;


    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("userCount", userRepository.count());
        model.addAttribute("playerCount", playerRepo.count());
        model.addAttribute("teamCount", teamRepo.count());
        model.addAttribute("tournamentCount", tournamentRepo.count());
        model.addAttribute("matchCount", matchRepo.count());

        Tournament lastTournament = tournamentRepo.findTopByOrderByEndDateDesc();
        model.addAttribute("lastWinner", lastTournament != null && lastTournament.getWinner() != null
                ? lastTournament.getWinner().getName()
                : "No winner yet");

        return "admin/admin-dashboard";
    }

}
