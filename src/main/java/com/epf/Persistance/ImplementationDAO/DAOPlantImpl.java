package com.epf.Persistance.ImplementationDAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.Core.models.Plant;
import com.epf.Persistance.InterfaceDAO.DAOPlantInterface;
import com.epf.Persistance.Exception.PlantValidationException;
import java.util.Arrays;
import java.util.List;

@Repository
public class DAOPlantImpl implements DAOPlantInterface {
    private JdbcTemplate jdbcTemplate;
    private static final List<String> VALID_EFFECTS = Arrays.asList("normal", "slow low", "slow medium", "slow stop");

    public DAOPlantImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }    private void validatePlant(Plant plant) {
        // Validation du nom
        if (plant.getNom() == null || plant.getNom().trim().isEmpty()) {
            throw new PlantValidationException("Le nom de la plante ne peut pas être vide");
        }

        // Validation des points de vie
        if (plant.getPointDeVie() <= 0) {
            throw new PlantValidationException("Les points de vie doivent être supérieurs à 0");
        }

        // Validation du coût
        if (plant.getCout() <= 0) {
            throw new PlantValidationException("Le coût doit être supérieur à 0");
        }

        // Validation des dégâts d'attaque
        if (plant.getDegatAttaque() < 0) {
            throw new PlantValidationException("Les dégâts d'attaque ne peuvent pas être négatifs");
        }

        // Validation de l'attaque par seconde
        if (plant.getAttaqueParSeconde() < 0) {
            throw new PlantValidationException("L'attaque par seconde ne peut pas être négative");
        }

        // Validation de la production de soleil
        if (plant.getSoleilParSeconde() < 0) {
            throw new PlantValidationException("La production de soleil par seconde ne peut pas être négative");
        }

        // Validation de l'effet
        if (plant.getEffet() != null && !VALID_EFFECTS.contains(plant.getEffet())) {
            throw new PlantValidationException(
                    "L'effet doit être l'une des valeurs suivantes : normal, slow low, slow medium, slow stop");
        }

        // Validation du chemin d'image (si fourni)
        if (plant.getCheminImage() != null && plant.getCheminImage().trim().isEmpty()) {
            throw new PlantValidationException("Le chemin d'image ne peut pas être une chaîne vide");
        }
    }

    // CRUD for Plant
    // Create
    public void addPlant(Plant plant) {
        validatePlant(plant);
        String sql = "INSERT INTO plante (nom,point_de_vie,cout,degat_attaque,attaque_par_seconde,soleil_par_seconde,effet,chemin_image) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, plant.getNom(),
                plant.getPointDeVie(), plant.getCout(), plant.getDegatAttaque(),
                plant.getAttaqueParSeconde(), plant.getSoleilParSeconde(),
                plant.getEffet(), plant.getCheminImage());
    }

    // READ
    public List<Plant> getAllPlants() {
        String sql = "SELECT * FROM plante";
        RowMapper<Plant> rowMapper = (rs, rowNum) -> new Plant(
                rs.getInt("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getInt("cout"),
                rs.getInt("degat_attaque"),
                rs.getDouble("attaque_par_seconde"),
                rs.getDouble("soleil_par_seconde"),
                rs.getString("effet"),
                rs.getString("chemin_image"));
        return jdbcTemplate.query(sql, rowMapper);
    }

    // UPDATE
    public void updatePlant(Plant plant) {
        validatePlant(plant);
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
