package com.epf.Core.ImplementationService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epf.Core.models.GameMap;
import com.epf.Persistance.ImplementationDAO.DAOGameMapImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceGameMapImplTest {

    @Mock
    private DAOGameMapImpl daoGameMap;

    private ServiceGameMapImpl serviceGameMap;

    @BeforeEach
    void setUp() {
        serviceGameMap = new ServiceGameMapImpl(daoGameMap);
    }

    @Test
    void testGetAllGameMaps() {
        // Arrange
        GameMap map1 = new GameMap(1, 5, 9, "map1.png");
        GameMap map2 = new GameMap(2, 6, 9, "map2.png");        List<GameMap> expectedMaps = Arrays.asList(map1, map2);
        
        when(daoGameMap.getAllGameMaps()).thenReturn(expectedMaps);

        // Act
        List<GameMap> actualMaps = serviceGameMap.getGameMaps();

        // Assert
        assertEquals(expectedMaps, actualMaps);
        verify(daoGameMap).getAllGameMaps();
    }

    @Test
    void testAddGameMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");

        // Act
        serviceGameMap.addGameMap(gameMap);

        // Assert
        verify(daoGameMap).addGameMap(gameMap);
    }

    @Test
    void testUpdateGameMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");

        // Act
        serviceGameMap.updateGameMap(gameMap);

        // Assert
        verify(daoGameMap).updateGameMap(gameMap);
    }

    @Test
    void testDeleteGameMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");

        // Act
        serviceGameMap.deleteGameMap(gameMap);

        // Assert
        verify(daoGameMap).deleteGameMap(gameMap);
    }
}
