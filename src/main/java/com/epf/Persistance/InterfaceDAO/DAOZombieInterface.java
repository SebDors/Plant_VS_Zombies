package com.epf.Persistance.InterfaceDAO;

import java.util.List;

import com.epf.Core.models.GameMap;
import com.epf.Core.models.Zombie;

public interface DAOZombieInterface {
    void addZombie(Zombie zombie);
    List<Zombie> getAllZombies();
    List<Zombie> getZombiesFromGameMap(GameMap gameMap);
    void updateZombie(Zombie zombie);
    void deleteZombie(Zombie zombie);
    void deleteZombiesFromMap(GameMap gameMap);
}
