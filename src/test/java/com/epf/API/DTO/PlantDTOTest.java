package com.epf.API.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlantDTOTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String nom = "Tournesol";
        int pointDeVie = 50;
        int cout = 50;
        int degatAttaque = 0;
        double attaqueParSeconde = 0.0;
        double soleilParSeconde = 1.0;
        String effet = "normal";
        String cheminImage = "sunflower.png";

        // Act
        PlantDTO plantDTO = new PlantDTO(id, nom, pointDeVie, cout, degatAttaque,
                attaqueParSeconde, soleilParSeconde, effet, cheminImage);

        // Assert
        assertEquals(id, plantDTO.getId());
        assertEquals(nom, plantDTO.getNom());
        assertEquals(pointDeVie, plantDTO.getPointDeVie());
        assertEquals(cout, plantDTO.getCout());
        assertEquals(degatAttaque, plantDTO.getDegatAttaque());
        assertEquals(attaqueParSeconde, plantDTO.getAttaqueParSeconde());
        assertEquals(soleilParSeconde, plantDTO.getSoleilParSeconde());
        assertEquals(effet, plantDTO.getEffet());
        assertEquals(cheminImage, plantDTO.getCheminImage());
    }

    @Test
    void testSetters() {
        // Arrange
        PlantDTO plantDTO = new PlantDTO();

        // Act
        plantDTO.setId(1);
        plantDTO.setNom("Tournesol");
        plantDTO.setPointDeVie(50);
        plantDTO.setCout(50);
        plantDTO.setDegatAttaque(0);
        plantDTO.setAttaqueParSeconde(0.0);
        plantDTO.setSoleilParSeconde(1.0);
        plantDTO.setEffet("normal");
        plantDTO.setCheminImage("sunflower.png");

        // Assert
        assertEquals(1, plantDTO.getId());
        assertEquals("Tournesol", plantDTO.getNom());
        assertEquals(50, plantDTO.getPointDeVie());
        assertEquals(50, plantDTO.getCout());
        assertEquals(0, plantDTO.getDegatAttaque());
        assertEquals(0.0, plantDTO.getAttaqueParSeconde());
        assertEquals(1.0, plantDTO.getSoleilParSeconde());
        assertEquals("normal", plantDTO.getEffet());
        assertEquals("sunflower.png", plantDTO.getCheminImage());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        PlantDTO plantDTO = new PlantDTO();

        // Assert
        assertEquals(0, plantDTO.getId());
        assertEquals(null, plantDTO.getNom());
        assertEquals(0, plantDTO.getPointDeVie());
        assertEquals(0, plantDTO.getCout());
        assertEquals(0, plantDTO.getDegatAttaque());
        assertEquals(0.0, plantDTO.getAttaqueParSeconde());
        assertEquals(0.0, plantDTO.getSoleilParSeconde());
        assertEquals(null, plantDTO.getEffet());
        assertEquals(null, plantDTO.getCheminImage());
    }
}
