package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Match;
import com.esport.tournamentapp.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByTournamentId(Long tournamentId);

    @Query("SELECT DISTINCT m.tournament FROM Match m")
    List<Tournament> findDistinctTournaments();
    List<Match> findAllByOrderByMatchDateAsc();


}
