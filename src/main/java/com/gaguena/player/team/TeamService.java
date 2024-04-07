package com.gaguena.player.team;

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
}
