package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
