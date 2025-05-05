package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
