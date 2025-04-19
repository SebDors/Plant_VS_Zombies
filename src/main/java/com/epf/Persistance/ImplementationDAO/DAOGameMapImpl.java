package com.epf.Persistance.ImplementationDAO;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.Core.models.GameMap;
import com.epf.Persistance.InterfaceDAO.DAOGameMapInterface;
import com.epf.Persistance.Exception.GameMapValidationException;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DAOGameMapImpl implements DAOGameMapInterface {
    private JdbcTemplate jdbcTemplate;

    public DAOGameMapImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void validateGameMap(GameMap gameMap) {
        // Validation du nombre de lignes
        if (gameMap.getLigne() <= 0) {
            throw new GameMapValidationException("Le nombre de lignes doit être supérieur à 0");
        }

        // Validation du nombre de colonnes
        if (gameMap.getColonne() <= 0) {
            throw new GameMapValidationException("Le nombre de colonnes doit être supérieur à 0");
        }

        // Validation du chemin d'image (si fourni)
        if (gameMap.getCheminImage() != null && gameMap.getCheminImage().trim().isEmpty()) {
            throw new GameMapValidationException("Le chemin d'image ne peut pas être une chaîne vide");
        }
    }
    
    // CRUD for GameMap
    // Create
    public void addGameMap(GameMap gameMap) {
        validateGameMap(gameMap);
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
        validateGameMap(gameMap);
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
