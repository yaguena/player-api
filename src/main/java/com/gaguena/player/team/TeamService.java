package com.gaguena.player.team;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;
    
    public Optional<TeamData> findByCode(String code) {
       return  repository.findBy(code);
    }

    public Optional<TeamData> save(TeamData data) {
       return Optional.of(this.repository.save(data))
       .filter(v -> BigDecimal.valueOf(v).equals(BigDecimal.ONE))
       .map(v -> data);
    }
}
