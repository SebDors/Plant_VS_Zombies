package com.epf.Persistance.ImplementationDAO;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epf.Core.models.GameMap;
import com.epf.Core.models.Zombie;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DAOZombieImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private DAOZombieImpl daoZombie;

    @BeforeEach
    void setUp() {
        daoZombie = new DAOZombieImpl(jdbcTemplate);
    }

    @Test
    void testGetAllZombies() {
        // Arrange
        Zombie zombie1 = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);
        Zombie zombie2 = new Zombie(2, "Zombie Cone", 200, 1, 10, 1, "zombie2.png", 1);
        List<Zombie> expectedZombies = Arrays.asList(zombie1, zombie2);

        doReturn(expectedZombies)
                .when(jdbcTemplate)
                .query(anyString(), any(RowMapper.class));

        // Act
        List<Zombie> actualZombies = daoZombie.getAllZombies();

        // Assert
        assertEquals(expectedZombies, actualZombies);
    }

    @Test
    void testGetZombiesFromGameMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");
        Zombie zombie1 = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);
        List<Zombie> expectedZombies = Arrays.asList(zombie1);

        doReturn(expectedZombies)
                .when(jdbcTemplate)
                .query(anyString(), any(RowMapper.class), any());

        // Act
        List<Zombie> actualZombies = daoZombie.getZombiesFromGameMap(gameMap);

        // Assert
        assertEquals(expectedZombies, actualZombies);
    }

    @Test
    void testAddZombie() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);

        doReturn(1)
                .when(jdbcTemplate)
                .update(anyString(), any(Object[].class));

        // Act
        daoZombie.addZombie(zombie);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }

    @Test
    void testUpdateZombie() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);

        doReturn(1)
                .when(jdbcTemplate)
                .update(anyString(), any(Object[].class));

        // Act
        daoZombie.updateZombie(zombie);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }

    @Test
    void testDeleteZombie() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);

        doReturn(1)
                .when(jdbcTemplate)
                .update(anyString(), any(Object[].class));

        // Act
        daoZombie.deleteZombie(zombie);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }

    @Test
    void testDeleteZombiesFromMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");

        doReturn(1)
                .when(jdbcTemplate)
                .update(anyString(), any(Object[].class));

        // Act
        daoZombie.deleteZombiesFromMap(gameMap);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }
}
