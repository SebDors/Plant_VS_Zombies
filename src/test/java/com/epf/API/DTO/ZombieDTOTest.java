package com.epf.API.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ZombieDTOTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String nom = "Zombie de base";
        int pointDeVie = 100;
        int attaqueParSeconde = 1;
        int degatAttaque = 10;
        int vitesseDeplacement = 1;
        String cheminImage = "zombie1.png";
        int idMap = 1;

        // Act
        ZombieDTO zombieDTO = new ZombieDTO(id, nom, pointDeVie, attaqueParSeconde,
                degatAttaque, vitesseDeplacement, cheminImage, idMap);

        // Assert
        assertEquals(id, zombieDTO.getId_zombie());
        assertEquals(nom, zombieDTO.getNom());
        assertEquals(pointDeVie, zombieDTO.getPoint_de_vie());
        assertEquals(attaqueParSeconde, zombieDTO.getAttaque_par_seconde());
        assertEquals(degatAttaque, zombieDTO.getDegat_attaque());
        assertEquals(vitesseDeplacement, zombieDTO.getVitesse_de_deplacement());
        assertEquals(cheminImage, zombieDTO.getChemin_image());
        assertEquals(idMap, zombieDTO.getId_map());
    }

    @Test
    void testSetters() {
        // Arrange
        ZombieDTO zombieDTO = new ZombieDTO();

        // Act
        zombieDTO.setId_zombie(1);
        zombieDTO.setNom("Zombie de base");
        zombieDTO.setPoint_de_vie(100);
        zombieDTO.setAttaque_par_seconde(1);
        zombieDTO.setDegat_attaque(10);
        zombieDTO.setVitesse_de_deplacement(1);
        zombieDTO.setChemin_image("zombie1.png");
        zombieDTO.setId_map(1);

        // Assert
        assertEquals(1, zombieDTO.getId_zombie());
        assertEquals("Zombie de base", zombieDTO.getNom());
        assertEquals(100, zombieDTO.getPoint_de_vie());
        assertEquals(1, zombieDTO.getAttaque_par_seconde());
        assertEquals(10, zombieDTO.getDegat_attaque());
        assertEquals(1, zombieDTO.getVitesse_de_deplacement());
        assertEquals("zombie1.png", zombieDTO.getChemin_image());
        assertEquals(1, zombieDTO.getId_map());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        ZombieDTO zombieDTO = new ZombieDTO();

        // Assert
        assertEquals(0, zombieDTO.getId_zombie());
        assertEquals(null, zombieDTO.getNom());
        assertEquals(0, zombieDTO.getPoint_de_vie());
        assertEquals(0, zombieDTO.getAttaque_par_seconde());
        assertEquals(0, zombieDTO.getDegat_attaque());
        assertEquals(0, zombieDTO.getVitesse_de_deplacement());
        assertEquals(null, zombieDTO.getChemin_image());
        assertEquals(0, zombieDTO.getId_map());
    }
}
