package com.epf.Persistance.InterfaceDAO;

import java.util.List;

import com.epf.Core.models.Plant;

public interface DAOPlantInterface {
    void addPlant(Plant plant);
    List<Plant> getAllPlants();
    void updatePlant(Plant plant);
    void deletePlante(Plant plant);
}
