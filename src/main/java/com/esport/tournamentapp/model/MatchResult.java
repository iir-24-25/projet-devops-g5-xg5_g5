package com.esport.tournamentapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_results")
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int teamAScore;
    private int teamBScore;

    private String winner; // Could be team name

    public MatchResult() {}

    public MatchResult(int teamAScore, int teamBScore, String winner) {
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public String getWinner() {
        return winner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
