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
import com.epf.Core.models.Zombie;
import com.epf.Persistance.ImplementationDAO.DAOZombieImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceZombieImplTest {

    @Mock
    private DAOZombieImpl daoZombie;

    private ServiceZombieImpl serviceZombie;

    @BeforeEach
    void setUp() {
        serviceZombie = new ServiceZombieImpl(daoZombie);
    }

    @Test
    void testGetAllZombies() {
        // Arrange
        Zombie zombie1 = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);
        Zombie zombie2 = new Zombie(2, "Zombie Cone", 200, 1, 10, 1, "zombie2.png", 1);
        List<Zombie> expectedZombies = Arrays.asList(zombie1, zombie2);
        
        when(daoZombie.getAllZombies()).thenReturn(expectedZombies);

        // Act
        List<Zombie> actualZombies = serviceZombie.getAllZombies();

        // Assert
        assertEquals(expectedZombies, actualZombies);
        verify(daoZombie).getAllZombies();
    }

    @Test
    void testGetZombiesFromMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");
        Zombie zombie1 = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);
        List<Zombie> expectedZombies = Arrays.asList(zombie1);
        
        when(daoZombie.getZombiesFromGameMap(gameMap)).thenReturn(expectedZombies);

        // Act
        List<Zombie> actualZombies = serviceZombie.getZombiesFromMap(gameMap);

        // Assert
        assertEquals(expectedZombies, actualZombies);
        verify(daoZombie).getZombiesFromGameMap(gameMap);
    }

    @Test
    void testAddZombie() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);

        // Act
        serviceZombie.addZombie(zombie);

        // Assert
        verify(daoZombie).addZombie(zombie);
    }

    @Test
    void testUpdateZombie() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);

        // Act
        serviceZombie.updateZombie(zombie);

        // Assert
        verify(daoZombie).updateZombie(zombie);
    }

    @Test
    void testDeleteZombie() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie de base", 100, 1, 10, 1, "zombie1.png", 1);

        // Act
        serviceZombie.deleteZombie(zombie);

        // Assert
        verify(daoZombie).deleteZombie(zombie);
    }

    @Test
    void testDeleteZombiesFromMap() {
        // Arrange
        GameMap gameMap = new GameMap(1, 5, 9, "map1.png");

        // Act
        serviceZombie.deleteZombiesFromMap(gameMap);

        // Assert
        verify(daoZombie).deleteZombiesFromMap(gameMap);
    }
}
