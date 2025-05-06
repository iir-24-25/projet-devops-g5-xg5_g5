package com.esport.tournamentapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private LocalDate startDate;
    private LocalDate endDate;
    private Double prizePool;
    private String imageUrl;


    // Constructors
    public Tournament() {}

    public Tournament(String name, LocalDate startDate, LocalDate endDate, Double prizePool) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.prizePool = prizePool;

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Double getPrizePool() {
        return prizePool;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPrizePool(Double prizePool) {
        this.prizePool = prizePool;
    }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
