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

import com.epf.Core.models.Plant;
import com.epf.Persistance.ImplementationDAO.DAOPlantImpl;

@ExtendWith(MockitoExtension.class)
public class ServicePlantImplTest {

    @Mock
    private DAOPlantImpl daoPlant;

    private ServicePlantImpl servicePlant;

    @BeforeEach
    void setUp() {
        servicePlant = new ServicePlantImpl(daoPlant);
    }

    @Test
    void testGetAllPlants() {
        // Arrange
        Plant plant1 = new Plant(1, "Tournesol", 100, 50, 0, 0.0, 25.0, "normal", "image1.png");
        Plant plant2 = new Plant(2, "Pois Tireur", 150, 100, 20, 1.5, 0.0, "normal", "image2.png");
        List<Plant> expectedPlants = Arrays.asList(plant1, plant2);
        
        when(daoPlant.getAllPlants()).thenReturn(expectedPlants);

        // Act
        List<Plant> actualPlants = servicePlant.getAllPlants();

        // Assert
        assertEquals(expectedPlants, actualPlants);
        verify(daoPlant).getAllPlants();
    }

    @Test
    void testAddPlant() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 100, 50, 0, 0.0, 25.0, "normal", "image1.png");

        // Act
        servicePlant.addPlant(plant);

        // Assert
        verify(daoPlant).addPlant(plant);
    }

    @Test
    void testUpdatePlant() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 100, 50, 0, 0.0, 25.0, "normal", "image1.png");

        // Act
        servicePlant.updatePlant(plant);

        // Assert
        verify(daoPlant).updatePlant(plant);
    }

    @Test
    void testDeletePlant() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 100, 50, 0, 0.0, 25.0, "normal", "image1.png");

        // Act
        servicePlant.deletePlant(plant);

        // Assert
        verify(daoPlant).deletePlante(plant);
    }
}
