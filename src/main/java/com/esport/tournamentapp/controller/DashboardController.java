package com.esport.tournamentapp.controller;

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

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("playerCount", playerRepo.count());
        model.addAttribute("teamCount", teamRepo.count());
        model.addAttribute("tournamentCount", tournamentRepo.count());
        model.addAttribute("matchCount", matchRepo.count());
        return "admin/index"; // if you move it under templates/admin/
    }
}
