package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByNameContainingIgnoreCase(String name);
    List<Game> findByPlatform(String platform);

    @Query("SELECT DISTINCT g.platform FROM Game g")
    List<String> findDistinctPlatforms();

}
