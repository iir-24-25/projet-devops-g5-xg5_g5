package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
