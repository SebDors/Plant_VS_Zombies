package com.epf.Persistance.InterfaceDAO;

import java.util.List;

import com.epf.Core.models.GameMap;

public interface DAOGameMapInterface {
    //Interface CRUD de GameMap
    void addGameMap(GameMap gameMap);
    List<GameMap> getAllGameMaps();
    void updateGameMap(GameMap gameMap);
    void deleteGameMap(GameMap gameMap);
}
