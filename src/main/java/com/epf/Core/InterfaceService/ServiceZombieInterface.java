package com.epf.Core.InterfaceService;

import java.util.List;

import com.epf.Core.models.GameMap;
import com.epf.Core.models.Zombie;

public interface ServiceZombieInterface {
    void addZombie(Zombie zombie);
    List<Zombie> getAllZombies();
    List<Zombie> getZombiesFromMap(GameMap gameMap);
    void updateZombie(Zombie zombie);
    void deleteZombie(Zombie zombie);
}
