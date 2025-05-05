package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Tournament;
import com.esport.tournamentapp.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/tournaments")
public class TournamentViewController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping
    public String listTournaments(Model model) {
        model.addAttribute("tournaments", tournamentRepository.findAll());
        return "admin/tournaments";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tournament", new Tournament());
        return "admin/tournament-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);
        model.addAttribute("tournament", tournament);
        return "admin/tournament-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable Long id) {
        tournamentRepository.deleteById(id);
        return "redirect:/admin/tournaments";
    }

    @PostMapping("/save")
    public String saveTournament(@ModelAttribute Tournament tournament) {
        tournamentRepository.save(tournament);
        return "redirect:/admin/tournaments";
    }
}
