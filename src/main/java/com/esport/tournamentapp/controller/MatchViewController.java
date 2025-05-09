package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Match;
import com.esport.tournamentapp.model.Team;
import com.esport.tournamentapp.model.Tournament;
import com.esport.tournamentapp.repository.MatchRepository;
import com.esport.tournamentapp.repository.TeamRepository;
import com.esport.tournamentapp.repository.TournamentRepository;
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
    private TournamentRepository tournamentRepository;

    @GetMapping
    public String listMatches(@RequestParam(required = false) Long tournamentId,
                              Model model) {

            List<Match> matches;

        if (tournamentId != null) {
            matches = matchRepository.findByTournamentId(tournamentId);
        } else {
            matches = matchRepository.findAll();
        }

        List<Tournament> tournaments = matchRepository.findDistinctTournaments();

        model.addAttribute("matches", matches);
        model.addAttribute("tournaments", tournaments);
        return "admin/matches";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("match", new Match());
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("tournaments", tournamentRepository.findAll());
        return "admin/match-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Match match = matchRepository.findById(id).orElse(null);
        model.addAttribute("match", match);
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("tournaments", tournamentRepository.findAll());
        return "admin/match-form";
    }

    @PostMapping("/save")
    public String saveMatch(@ModelAttribute Match match,
                            @RequestParam("teamA.id") Long teamAId,
                            @RequestParam("teamB.id") Long teamBId,
                            @RequestParam("tournament.id") Long tournamentId) {

        Team teamA = teamRepository.findById(teamAId).orElse(null);
        Team teamB = teamRepository.findById(teamBId).orElse(null);
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);

        match.setTeamA(teamA);
        match.setTeamB(teamB);
        match.setTournament(tournament);

        matchRepository.save(match);
        return "redirect:/admin/matches";
    }

    @GetMapping("/delete/{id}")
    public String deleteMatch(@PathVariable Long id) {
        matchRepository.deleteById(id);
        return "redirect:/admin/matches";
    }
}
