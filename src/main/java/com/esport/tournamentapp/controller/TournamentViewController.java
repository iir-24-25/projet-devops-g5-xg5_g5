package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Game;
import com.esport.tournamentapp.model.Match;
import com.esport.tournamentapp.model.MatchResult;
import com.esport.tournamentapp.model.Tournament;
import com.esport.tournamentapp.repository.GameRepository;
import com.esport.tournamentapp.repository.TeamRepository;
import com.esport.tournamentapp.repository.TournamentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private TeamRepository teamRepository;

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
        Tournament tournament = new Tournament();

        // Ajout de 7 matchs vides avec résultat
        for (int i = 0; i < 7; i++) {
            Match match = new Match();
            match.setResult(new MatchResult());
            tournament.getMatches().add(match);
        }

        model.addAttribute("tournament", tournament);
        model.addAttribute("allGames", gameRepository.findAll());
        model.addAttribute("allTeams", teamRepository.findAll());
        return "admin/tournament-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);

        if (tournament != null) {
            // S'assurer que chaque match a un résultat initialisé
            for (Match match : tournament.getMatches()) {
                if (match.getResult() == null) {
                    match.setResult(new MatchResult());
                }
            }
        }

        model.addAttribute("tournament", tournament);
        model.addAttribute("allGames", gameRepository.findAll());
        model.addAttribute("allTeams", teamRepository.findAll());
        return "admin/tournament-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable Long id) {
        tournamentRepository.deleteById(id);
        return "redirect:/admin/tournaments";
    }

    @PostMapping("/save")
    public String saveTournament(@Valid @ModelAttribute Tournament tournament,
                                 BindingResult result,
                                 @RequestParam("imageFile") MultipartFile imageFile,
                                 Model model) throws IOException {

        // ✅ Log des erreurs de validation (si elles existent)
        if (result.hasErrors()) {
            System.out.println("⛔ Erreurs de validation du formulaire :");
            result.getAllErrors().forEach(error -> System.out.println("🔸 " + error));
            model.addAttribute("allGames", gameRepository.findAll());
            model.addAttribute("allTeams", teamRepository.findAll());
            return "admin/tournament-form";
        }

        // ✅ Upload de l’image
        if (!imageFile.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/uploads/images";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = imageFile.getOriginalFilename();
            File saveFile = new File(dir, fileName);
            imageFile.transferTo(saveFile);

            tournament.setImageUrl("/images/" + fileName);
        }

        // ✅ Liaison des matchs et log des dates
        if (tournament.getMatches() != null) {
            for (int i = 0; i < tournament.getMatches().size(); i++) {
                Match m = tournament.getMatches().get(i);
                m.setTournament(tournament);

                if (m.getResult() == null) {
                    m.setResult(new MatchResult());
                }

                // 📅 Log de la date du match
                System.out.println("📅 Match " + (i + 1) + " - Date: " + m.getMatchDate());
            }
        }

        tournamentRepository.save(tournament);
        System.out.println("✅ Tournoi enregistré avec succès.");
        return "redirect:/admin/tournaments";
    }


    @GetMapping("/details/{id}")
    public String showTournamentDetails(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);
        model.addAttribute("tournament", tournament);
        return "admin/tournament-details";
    }
}
