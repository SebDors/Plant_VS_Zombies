package com.epf.Persistance.ImplementationDAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.Core.models.GameMap;
import com.epf.Core.models.Zombie;
import com.epf.Persistance.InterfaceDAO.DAOZombieInterface;

@Repository
public class DAOZombieImpl implements DAOZombieInterface {

    private JdbcTemplate jdbcTemplate;

    public DAOZombieImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // CRUD for Zombies
    // Create
    public void addZombie(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, zombie.getNom(),
                zombie.getPoint_de_vie(), 
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image());
    }

    // READ
    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM zombie";
        RowMapper<Zombie> rowMapper = (rs, rowNum) -> new Zombie(
                rs.getString("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getInt("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map"));
        return jdbcTemplate.query(sql, rowMapper);
    }
    // READ from id_map
    public List<Zombie> getZombiesFromGameMap(GameMap map) {
        String sql = "SELECT * FROM zombie WHERE id_map = ?";
        RowMapper<Zombie> rowMapper = (rs, rowNum) -> new Zombie(
                rs.getString("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getInt("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map"));
        return jdbcTemplate.query(sql, rowMapper, map.getIdMap());
    }

    // UPDATE
    public void updateZombie(Zombie zombie) {
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
    public void deleteZombie(Zombie zombie) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getId_zombie());
    }
}
