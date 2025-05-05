package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
