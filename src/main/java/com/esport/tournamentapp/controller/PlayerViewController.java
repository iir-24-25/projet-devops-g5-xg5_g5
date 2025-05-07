package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Player;
import com.esport.tournamentapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/players")
public class PlayerViewController {

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping
    public String listPlayers(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String nationality,
                              Model model) {

        List<Player> players = playerRepository.findAll().stream()
                .filter(p -> (name == null || p.getUsername().toLowerCase().contains(name.toLowerCase())))
                .filter(p -> (nationality == null || nationality.isEmpty() || p.getNationality().equals(nationality)))
                .toList();

        List<String> nationalities = playerRepository.findAll().stream()
                .map(Player::getNationality)
                .filter(n -> n != null && !n.isBlank())
                .distinct()
                .toList();

        model.addAttribute("players", players);
        model.addAttribute("name", name);
        model.addAttribute("nationality", nationality);
        model.addAttribute("nationalities", nationalities);
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
    public String savePlayer(@ModelAttribute Player player,
                             @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/uploads/images";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = imageFile.getOriginalFilename();
            File saveFile = new File(dir, fileName);
            imageFile.transferTo(saveFile);

            player.setImageUrl("/images/" + fileName);
        }

        playerRepository.save(player);
        return "redirect:/admin/players";
    }


    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
        return "redirect:/admin/players";
    }
}
