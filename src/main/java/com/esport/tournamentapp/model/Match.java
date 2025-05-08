package com.esport.tournamentapp.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tournament tournament;

    @ManyToOne
    private Team teamA;

    @ManyToOne
    private Team teamB;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = true ) // allows null in DB
    private Date matchDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_result_id", referencedColumnName = "id" , nullable = true )
    private MatchResult result;


    public Match() {}

    public Match(Tournament tournament, Team teamA, Team teamB, MatchResult result) {
        this.tournament = tournament;
        this.teamA = teamA;
        this.teamB = teamB;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public MatchResult getResult() {
        return result;
    }

    public Date getMatchDate() {
        return matchDate;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

}
