package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Team;
import com.esport.tournamentapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserTeamDetailsController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    public String showAllTeams(Model model) {
        List<Team> teams = teamRepository.findAll();

        model.addAttribute("teams", teams);
        return "user/team"; // this maps to templates/user/team.html
    }

}
