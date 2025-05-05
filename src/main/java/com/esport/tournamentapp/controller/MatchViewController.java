package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Match;
import com.esport.tournamentapp.model.MatchResult;
import com.esport.tournamentapp.model.Team;
import com.esport.tournamentapp.repository.MatchRepository;
import com.esport.tournamentapp.repository.MatchResultRepository;
import com.esport.tournamentapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/matches")
public class MatchViewController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchResultRepository matchResultRepository;

    @GetMapping
    public String listMatches(Model model) {
        model.addAttribute("matches", matchRepository.findAll());
        return "admin/matches";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("match", new Match());
        model.addAttribute("teams", teamRepository.findAll());
        return "admin/match-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Match match = matchRepository.findById(id).orElse(null);
        model.addAttribute("match", match);
        model.addAttribute("teams", teamRepository.findAll());
        return "admin/match-form";
    }

    @PostMapping("/save")
    public String saveMatch(@ModelAttribute Match match) {
        matchRepository.save(match);
        return "redirect:/admin/matches";
    }

    @GetMapping("/delete/{id}")
    public String deleteMatch(@PathVariable Long id) {
        matchRepository.deleteById(id);
        return "redirect:/admin/matches";
    }
}
