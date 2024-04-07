package com.gaguena.player.team;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int save(TeamData data) {
        return jdbcTemplate.update(
                "INSERT INTO TB_TEAM (TCODE, TNAME) VALUES(?,?)",
                data.code(), data.name());
    }

    public int remove(TeamData data) {
        return jdbcTemplate.update(
                "DELETE TB_TEAM WHERE ID = ?",
                data.code());
    }

    public Optional<TeamData> findBy(String code) {
        try {
            var data = jdbcTemplate.queryForObject("select * from TB_TEAM where id = ?",
                    (rs, rowNum) -> new TeamData(rs.getString("TCODE"), rs.getString("TNAME")),
                    new Object[] { code });
            return Optional.of(data);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
