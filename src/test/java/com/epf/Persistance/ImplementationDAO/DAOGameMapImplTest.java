package com.epf.Persistance.ImplementationDAO;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epf.Core.models.GameMap;

@ExtendWith(MockitoExtension.class)
public class DAOGameMapImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private DAOGameMapImpl daoGameMap;

    @BeforeEach
    void setUp() {
        daoGameMap = new DAOGameMapImpl(jdbcTemplate);
    }

    @Test
    void testGetAllGameMaps() {
        // Arrange
        GameMap map1 = new GameMap(1, 5, 9, "map1.png");
        GameMap map2 = new GameMap(2, 6, 9, "map2.png");
        List<GameMap> expectedMaps = Arrays.asList(map1, map2);
        
        when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
            .thenReturn(expectedMaps);

        // Act
        List<GameMap> actualMaps = daoGameMap.getAllGameMaps();

        // Assert
        assertEquals(expectedMaps, actualMaps);
        verify(jdbcTemplate).query(anyString(), any(RowMapper.class));
    }

    @Test
    void testAddGameMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");
        
        when(jdbcTemplate.update(anyString(), any(Object[].class)))
            .thenReturn(1);

        // Act
        daoGameMap.addGameMap(gameMap);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }

    @Test
    void testUpdateGameMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");
        
        when(jdbcTemplate.update(anyString(), any(Object[].class)))
            .thenReturn(1);

        // Act
        daoGameMap.updateGameMap(gameMap);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }

    @Test
    void testDeleteGameMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");
        
        when(jdbcTemplate.update(anyString(), any(Object[].class)))
            .thenReturn(1);

        // Act
        daoGameMap.deleteGameMap(gameMap);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }
}
