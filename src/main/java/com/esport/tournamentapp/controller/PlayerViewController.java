package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Player;
import com.esport.tournamentapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/players")
public class PlayerViewController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public String listPlayers(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "admin/players";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("player", new Player());
        return "admin/player-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Player player = playerRepository.findById(id).orElse(null);
        model.addAttribute("player", player);
        return "admin/player-form";
    }

    @PostMapping("/save")
    public String savePlayer(@ModelAttribute Player player) {
        playerRepository.save(player);
        return "redirect:/admin/players";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
        return "redirect:/admin/players";
    }
}
