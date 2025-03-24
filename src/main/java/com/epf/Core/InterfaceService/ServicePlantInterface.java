package com.epf.Core.InterfaceService;

import java.util.List;

import com.epf.Core.models.Plant;

public interface ServicePlantInterface {
    void addPlant(Plant plante);
    List<Plant> getAllPlants();
    void updatePlant(Plant plante);
    void deletePlant(Plant plante);
}
