package com.epf.Persistance.ImplementationDAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.Core.models.Plant;
import com.epf.Persistance.InterfaceDAO.DAOPlantInterface;

@Repository
public class DAOPlantImpl implements DAOPlantInterface{
    private JdbcTemplate jdbcTemplate;

    public DAOPlantImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD for Plant
    // Create
    public void addPlant(Plant plant) {
        String sql = "INSERT INTO plante (nom,point_de_vie,cout,degat_attaque,attaque_par_seconde,soleil_par_seconde,effet,chemin_image) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, plant.getNom(),
                plant.getPointDeVie(), plant.getCout(), plant.getDegatAttaque(),
                plant.getAttaqueParSeconde(), plant.getSoleilParSeconde(),
                plant.getEffet(), plant.getCheminImage());
    }

    // READ
    public List<Plant> getAllPlants() {
        String sql = "SELECT * FROM plante"; // Requête SQL
        RowMapper<Plant> rowMapper = (rs, rowNum) -> new Plant( // Permet de transformer une ligne de la table en objet
                                                                // Plant
                rs.getInt("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getInt("cout"),
                rs.getInt("degat_attaque"),
                rs.getInt("attaque_par_seconde"),
                rs.getInt("soleil_par_seconde"),
                rs.getString("effet"),
                rs.getString("chemin_image"));
        return jdbcTemplate.query(sql, rowMapper); // Execute la requête et retourne une liste de plantes
    }

    // UPDATE
    public void updatePlant(Plant plant) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, cout = ?, degat_attaque = ?, " +
                "attaque_par_seconde = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? " +
                "WHERE id_plante = ?";
        jdbcTemplate.update(sql,
                plant.getNom(),
                plant.getPointDeVie(),
                plant.getCout(),
                plant.getDegatAttaque(),
                plant.getAttaqueParSeconde(),
                plant.getSoleilParSeconde(),
                plant.getEffet(),
                plant.getCheminImage(),
                plant.getId_plante());
    }

    // DELETE
    public void deletePlante(Plant plant) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, plant.getId_plante());
    }

}
