package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Match;
import com.esport.tournamentapp.model.Team;
import com.esport.tournamentapp.repository.MatchRepository;
import com.esport.tournamentapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserTournamentController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/tournament/details")
    public String showTournamentDetailsPage(Model model) {
        List<Match> matches = matchRepository.findAllByOrderByMatchDateAsc(); // sorted by date
        List<Team> teams = teamRepository.findAll();
        model.addAttribute("matches", matches);
        model.addAttribute("teams", teams);
        return "user/tournament-details";
    }





}

