package com.epf.Persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import com.epf.Core.models.Plant;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

//Est-ce que je dois ajouter des annotations pour que Spring puisse gérer cette classe ?
// Est-ce que le rowMapper est correct ? Car Spring
public class DAO {
    private JdbcTemplate jdbcTemplate;

    public List<Plant> getAllPlants() {
        String sql = "SELECT * FROM plants"; //Requête SQL
        RowMapper<Plant> rowMapper = (rs, rowNum) -> new Plant( //Permet de transformer une ligne de la table en objet Plant
            rs.getInt("id"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getInt("cout"),
            rs.getInt("degat_attaque"),
            rs.getInt("attaque_par_seconde"),
            rs.getInt("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
        ); 
        return jdbcTemplate.query(sql, rowMapper); //Execute la requête et retourne une liste de plantes
    }
}
