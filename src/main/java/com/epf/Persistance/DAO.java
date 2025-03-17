package com.epf.Persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import com.epf.Core.models.Plant;
import com.epf.Core.models.Zombies;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

    private JdbcTemplate jdbcTemplate;

    public DAO(JdbcTemplate jdbcTemplate) {
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
                plant.getId());
    }

    // DELETE
    public void deletePlante(Plant plant) {
        String sql = "DELETE FROM plante WHERE 'id_plante' = ?";
        jdbcTemplate.update(sql, plant.getId());
    }

    // CRUD for Zombies
    // Create
    public void addZombie(Zombies zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, zombie.getNom(),
                zombie.getPoint_de_vie(), 
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image());
    }

    // READ
    public List<Zombies> getAllZombies() {
        String sql = "SELECT * FROM zombie";
        RowMapper<Zombies> rowMapper = (rs, rowNum) -> new Zombies(
                rs.getString("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getInt("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("vitesse_de_deplacement"),
                rs.getString("chemin_image"));
        return jdbcTemplate.query(sql, rowMapper);
    }

    // UPDATE
    public void updateZombie(Zombies zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, " +
                "vitesse_de_deplacement = ?, chemin_image = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_zombie());
    }

    // DELETE
    public void deleteZombie(Zombies zombie) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getId_zombie());
    }
}
