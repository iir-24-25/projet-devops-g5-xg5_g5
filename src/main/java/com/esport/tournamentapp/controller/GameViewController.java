package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Game;
import com.esport.tournamentapp.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin/games")
public class GameViewController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public String listGames(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "admin/games";
    }

    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
        return "redirect:/admin/games";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("game", new Game());
        return "admin/game-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Game game = gameRepository.findById(id).orElse(null);
        model.addAttribute("game", game);
        return "admin/game-form";
    }

    @PostMapping("/save")
    public String saveGame(@ModelAttribute Game game,
                           @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            // Define external upload directory
            String uploadDir = System.getProperty("user.dir") + "/uploads/images";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            // Save the file
            String fileName = imageFile.getOriginalFilename();
            File saveFile = new File(dir, fileName);
            imageFile.transferTo(saveFile);

            // Store relative URL
            game.setImageUrl("/images/" + fileName);
        }

        gameRepository.save(game);
        return "redirect:/admin/games";
    }


}
