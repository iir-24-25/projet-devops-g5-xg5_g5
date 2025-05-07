package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Team;
import com.esport.tournamentapp.repository.PlayerRepository;
import com.esport.tournamentapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/teams")
public class TeamViewController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public String listTeams(@RequestParam(required = false) String keyword,
                            @RequestParam(required = false) String country,
                            Model model) {

        List<Team> teams;

        if (keyword != null && !keyword.isEmpty()) {
            teams = teamRepository.findByNameContainingIgnoreCase(keyword);
        } else if (country != null && !country.isEmpty()) {
            teams = teamRepository.findByCountry(country);
        } else {
            teams = teamRepository.findAll();
        }

        List<String> countries = teamRepository.findDistinctCountries();
        model.addAttribute("teams", teams);
        model.addAttribute("countries", countries);
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
    public String saveTeam(@ModelAttribute Team team,
                           @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/uploads/images";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = imageFile.getOriginalFilename();
            File saveFile = new File(dir, fileName);
            imageFile.transferTo(saveFile);

            team.setImageUrl("/images/" + fileName);
        }

        teamRepository.save(team);
        return "redirect:/admin/teams";
    }



    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
        return "redirect:/admin/teams";
    }
}
