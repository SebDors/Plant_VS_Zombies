package com.epf.Persistance;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.Core.models.GameMap;
import com.epf.Persistance.InterfaceDAO.DAOGameMapInterface;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DAOGameMapImpl implements DAOGameMapInterface {
    private JdbcTemplate jdbcTemplate;

    public DAOGameMapImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // CRUD for GameMap
    // Create
    public void addGameMap(GameMap gameMap) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 
            gameMap.getLigne(),
            gameMap.getColonne(),
            gameMap.getCheminImage());
    }

    // READ
    public List<GameMap> getAllGameMaps() {
        String sql = "SELECT * FROM map";
        RowMapper<GameMap> rowMapper = (rs, rowNum) -> new GameMap(
            rs.getInt("id_map"),
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image"));
        return jdbcTemplate.query(sql, rowMapper);
    }

    // UPDATE
    public void updateGameMap(GameMap gameMap) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql,
            gameMap.getLigne(),
            gameMap.getColonne(),
            gameMap.getCheminImage(),
            gameMap.getIdMap());
    }

    // DELETE
    public void deleteGameMap(GameMap gameMap) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        jdbcTemplate.update(sql, gameMap.getIdMap());
    }
}
