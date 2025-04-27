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
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epf.Core.models.Plant;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DAOPlantImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private DAOPlantImpl daoPlant;

    @BeforeEach
    void setUp() {
        daoPlant = new DAOPlantImpl(jdbcTemplate);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetAllPlants() {
        // Arrange
        Plant plant1 = new Plant(1, "Tournesol", 50, 50, 0, 0.0, 1.0, "normal", "sunflower.png");
        Plant plant2 = new Plant(2, "Petit Pois", 100, 100, 20, 1.0, 0.0, "normal", "peashooter.png");
        List<Plant> expectedPlants = Arrays.asList(plant1, plant2);

        doReturn(expectedPlants)
                .when(jdbcTemplate)
                .query(anyString(), any(RowMapper.class));

        // Act
        List<Plant> actualPlants = daoPlant.getAllPlants();

        // Assert
        assertEquals(expectedPlants, actualPlants);
    }

    @Test
    void testAddPlant() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 50, 50, 0, 0.0, 1.0, "normal", "sunflower.png");

        doReturn(1)
                .when(jdbcTemplate)
                .update(anyString(), any(Object[].class));

        // Act
        daoPlant.addPlant(plant);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }

    @Test
    void testUpdatePlant() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 50, 50, 0, 0.0, 1.0, "normal", "sunflower.png");

        doReturn(1)
                .when(jdbcTemplate)
                .update(anyString(), any(Object[].class));

        // Act
        daoPlant.updatePlant(plant);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }

    @Test
    void testDeletePlant() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 50, 50, 0, 0.0, 1.0, "normal", "sunflower.png");

        doReturn(1)
                .when(jdbcTemplate)
                .update(anyString(), any(Object[].class));

        // Act
        daoPlant.deletePlante(plant);

        // Assert
        verify(jdbcTemplate).update(anyString(), any(Object[].class));
    }
}
