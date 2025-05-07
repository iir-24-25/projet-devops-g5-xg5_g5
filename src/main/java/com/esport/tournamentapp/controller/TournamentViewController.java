package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Game;
import com.esport.tournamentapp.model.Tournament;
import com.esport.tournamentapp.repository.GameRepository;
import com.esport.tournamentapp.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/tournaments")
public class TournamentViewController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private GameRepository gameRepository;


    @GetMapping
    public String listTournaments(@RequestParam(required = false) Long gameId,
                                  @RequestParam(required = false) String name,
                                  Model model) {

        List<Tournament> tournaments = tournamentRepository.searchByGameAndName(gameId, name);
        List<Game> games = tournamentRepository.findDistinctGames();

        model.addAttribute("tournaments", tournaments);
        model.addAttribute("games", games);
        model.addAttribute("name", name);
        model.addAttribute("gameId", gameId);
        return "admin/tournaments";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tournament", new Tournament());
        model.addAttribute("allGames", gameRepository.findAll());
        return "admin/tournament-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);
        model.addAttribute("tournament", tournament);
        model.addAttribute("allGames", gameRepository.findAll());
        return "admin/tournament-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable Long id) {
        tournamentRepository.deleteById(id);
        return "redirect:/admin/tournaments";
    }

    @PostMapping("/save")
    public String saveTournament(@ModelAttribute Tournament tournament,
                                 @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/uploads/images";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = imageFile.getOriginalFilename();
            File saveFile = new File(dir, fileName);
            imageFile.transferTo(saveFile);

            tournament.setImageUrl("/images/" + fileName);
        }

        tournamentRepository.save(tournament);
        return "redirect:/admin/tournaments";
    }

}
