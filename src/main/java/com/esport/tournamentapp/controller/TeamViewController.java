package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Team;
import com.esport.tournamentapp.repository.PlayerRepository;
import com.esport.tournamentapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/teams")
public class TeamViewController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public String listTeams(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        return "admin/teams";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("team", new Team());
        model.addAttribute("allPlayers", playerRepository.findAll());
        return "admin/team-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Team team = teamRepository.findById(id).orElse(null);
        model.addAttribute("team", team);
        model.addAttribute("allPlayers", playerRepository.findAll());
        return "admin/team-form";
    }

    @PostMapping("/save")
    public String saveTeam(@ModelAttribute Team team) {
        teamRepository.save(team);
        return "redirect:/admin/teams";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
        return "redirect:/admin/teams";
    }
}
