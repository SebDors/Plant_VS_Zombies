package com.epf.API.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameMapDTOTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        int idMap = 1;
        int ligne = 5;
        int colonne = 9;
        String cheminImage = "map1.png";

        // Act
        GameMapDTO gameMapDTO = new GameMapDTO(idMap, ligne, colonne, cheminImage);

        // Assert
        assertEquals(idMap, gameMapDTO.getId_map());
        assertEquals(ligne, gameMapDTO.getLigne());
        assertEquals(colonne, gameMapDTO.getColonne());
        assertEquals(cheminImage, gameMapDTO.getChemin_image());
    }

    @Test
    void testSetters() {
        // Arrange
        GameMapDTO gameMapDTO = new GameMapDTO();

        // Act
        gameMapDTO.setId_map(1);
        gameMapDTO.setLigne(5);
        gameMapDTO.setColonne(9);
        gameMapDTO.setChemin_image("map1.png");

        // Assert
        assertEquals(1, gameMapDTO.getId_map());
        assertEquals(5, gameMapDTO.getLigne());
        assertEquals(9, gameMapDTO.getColonne());
        assertEquals("map1.png", gameMapDTO.getChemin_image());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        GameMapDTO gameMapDTO = new GameMapDTO();

        // Assert
        assertEquals(0, gameMapDTO.getId_map());
        assertEquals(0, gameMapDTO.getLigne());
        assertEquals(0, gameMapDTO.getColonne());
        assertEquals(null, gameMapDTO.getChemin_image());
    }
}
