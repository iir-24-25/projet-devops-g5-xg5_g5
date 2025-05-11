package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Match;
import com.esport.tournamentapp.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserMatchController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/match")
    public String showUserMatchesPage(Model model) {
        List<Match> matches = matchRepository.findAllByOrderByMatchDateAsc();
        model.addAttribute("matches", matches);
        return "user/match"; // templates/user/match.html
    }
}
