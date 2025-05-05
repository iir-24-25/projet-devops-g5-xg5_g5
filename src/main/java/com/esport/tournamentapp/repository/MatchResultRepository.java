package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchResultRepository extends JpaRepository<MatchResult, Long> {
}
