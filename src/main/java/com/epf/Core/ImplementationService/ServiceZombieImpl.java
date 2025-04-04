package com.epf.Core.ImplementationService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.Core.InterfaceService.ServiceZombieInterface;
import com.epf.Core.models.Zombie;
import com.epf.Persistance.ImplementationDAO.DAOZombieImpl;
import com.epf.Core.models.GameMap;

@Service
public class ServiceZombieImpl implements ServiceZombieInterface {
    private DAOZombieImpl DAOImpl;

    public ServiceZombieImpl(DAOZombieImpl DAOZombieImpl) {
        this.DAOImpl = DAOZombieImpl;
    }

    public void addZombie(Zombie zombie) {
        DAOImpl.addZombie(zombie);
    }

    public List<Zombie> getAllZombies() {
        return DAOImpl.getAllZombies();
    }

    public List<Zombie> getZombiesFromMap(GameMap gameMap) {
        return DAOImpl.getZombiesFromGameMap(gameMap);
    }

    public void updateZombie(Zombie zombie) {
        DAOImpl.updateZombie(zombie);
    }

    public void deleteZombie(Zombie zombie) {
        DAOImpl.deleteZombie(zombie);
    }
    public void deleteZombiesFromMap(GameMap gameMap) {
        DAOImpl.deleteZombiesFromMap(gameMap);
    }
}
