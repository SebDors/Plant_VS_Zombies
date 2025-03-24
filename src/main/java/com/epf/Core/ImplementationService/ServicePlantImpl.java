package com.epf.Core.ImplementationService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.Core.InterfaceService.ServicePlantInterface;
import com.epf.Core.models.Plant;
import com.epf.Persistance.ImplementationDAO.DAOPlantImpl;

@Service
public class ServicePlantImpl implements ServicePlantInterface {
    private DAOPlantImpl DAOImpl;

    public ServicePlantImpl(DAOPlantImpl DAOPlantImpl) {
        this.DAOImpl = DAOPlantImpl;
    }

    public void addPlant(Plant plant) {
        DAOImpl.addPlant(plant);
    }

    public List<Plant> getAllPlants() {
        return DAOImpl.getAllPlants();
    }

    public void updatePlant(Plant plant) {
        DAOImpl.updatePlant(plant);
    }

    public void deletePlant(Plant plant) {
        DAOImpl.deletePlante(plant);
    }
}
