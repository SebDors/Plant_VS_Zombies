package com.epf.Core.ImplementationService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.Core.InterfaceService.ServiceGameMapInterface;
import com.epf.Core.models.GameMap;
import com.epf.Persistance.ImplementationDAO.DAOGameMapImpl;

@Service
public class ServiceGameMapImpl implements ServiceGameMapInterface {

    private DAOGameMapImpl DAOImpl;

    public ServiceGameMapImpl(DAOGameMapImpl DAOGameMapImpl){
        this.DAOImpl = DAOGameMapImpl;
    }

    public void addGameMap(GameMap gameMap){
        DAOImpl.addGameMap(gameMap);
    }

    public List<GameMap> getGameMaps(){
        return DAOImpl.getAllGameMaps();
    }

    public void updateGameMap(GameMap gameMap){
        DAOImpl.updateGameMap(gameMap);
    }
    
    public void deleteGameMap(GameMap gameMap){
        DAOImpl.deleteGameMap(gameMap);
    }
}
