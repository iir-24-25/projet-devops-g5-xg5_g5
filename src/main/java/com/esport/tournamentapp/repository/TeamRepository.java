package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByNameContainingIgnoreCase(String name);
    List<Team> findByCountry(String country);

    @Query("SELECT DISTINCT t.country FROM Team t")
    List<String> findDistinctCountries();

}
