package com.epf.Core.InterfaceService;

import java.util.List;

import com.epf.Core.models.GameMap;

public interface ServiceGameMapInterface {
    void addGameMap(GameMap gameMap);
    List<GameMap> getGameMaps();
    void updateGameMap(GameMap gameMap);
    void deleteGameMap(GameMap gameMap);
}
