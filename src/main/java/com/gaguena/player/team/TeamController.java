package com.gaguena.player.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaguena.player.infra.exceptions.BadRequestException;
import com.gaguena.player.infra.exceptions.NotFoundException;


@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{code}")
    public ResponseEntity<TeamData> get(@PathVariable String code) {
        return teamService.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping("/")
    public ResponseEntity<TeamData> save(@RequestBody TeamData data) {
        return teamService.save(data)
                .map(v -> {
                    return ResponseEntity.status(HttpStatus.CREATED).body(v);
                })
                .orElseThrow(BadRequestException::new);
    }
}
