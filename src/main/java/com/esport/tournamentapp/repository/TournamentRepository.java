package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Game;
import com.esport.tournamentapp.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    @Query("SELECT t FROM Tournament t WHERE " +
            "(:gameId IS NULL OR t.game.id = :gameId) AND " +
            "(:name IS NULL OR LOWER(t.name) LIKE LOWER(CONCAT('%', :name, '%')))")
    List<Tournament> searchByGameAndName(@Param("gameId") Long gameId, @Param("name") String name);
    @Query("SELECT DISTINCT t.game FROM Tournament t")
    List<Game> findDistinctGames();
    Tournament findTopByOrderByEndDateDesc();



}
