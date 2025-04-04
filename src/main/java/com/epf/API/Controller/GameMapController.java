package com.epf.API.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.API.DTO.GameMapDTO;
import com.epf.Core.InterfaceService.ServiceGameMapInterface;
import com.epf.Core.InterfaceService.ServiceZombieInterface;
import com.epf.Core.models.GameMap;

@RestController
@RequestMapping("/maps")
@CrossOrigin(origins = "http://localhost:5173")
public class GameMapController {
    private final ServiceGameMapInterface serviceGameMap;
    private final ServiceZombieInterface serviceZombie;

    public GameMapController(ServiceGameMapInterface serviceGameMap, ServiceZombieInterface serviceZombie) {
        this.serviceGameMap = serviceGameMap;
        this.serviceZombie = serviceZombie;
    }

    @GetMapping
    public ResponseEntity<List<GameMapDTO>> getAllMaps() {
        List<GameMap> maps = serviceGameMap.getGameMaps();
        List<GameMapDTO> mapDTOs = maps.stream()
            .map(m -> new GameMapDTO(
                m.getIdMap(),
                m.getLigne(),
                m.getColonne(),
                m.getCheminImage()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(mapDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameMapDTO> getMapById(@PathVariable("id") int id) {
        GameMap map = serviceGameMap.getGameMaps().stream()
            .filter(m -> m.getIdMap() == id)
            .findFirst()
            .orElse(null);
        
        if (map == null) {
            return ResponseEntity.notFound().build();
        }

        GameMapDTO mapDTO = new GameMapDTO(
            map.getIdMap(),
            map.getLigne(),
            map.getColonne(),
            map.getCheminImage()
        );
        
        return ResponseEntity.ok(mapDTO);
    }

    @PostMapping
    public ResponseEntity<GameMapDTO> createMap(@RequestBody GameMapDTO mapDTO) {
        GameMap map = new GameMap(
            mapDTO.getId_map(),
            mapDTO.getLigne(),
            mapDTO.getColonne(),
            mapDTO.getChemin_image()
        );
        serviceGameMap.addGameMap(map);
        return ResponseEntity.ok(mapDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameMapDTO> updateMap(@PathVariable("id") int id, @RequestBody GameMapDTO mapDTO) {
        GameMap map = new GameMap(
            id,
            mapDTO.getLigne(),
            mapDTO.getColonne(),
            mapDTO.getChemin_image()
        );
        serviceGameMap.updateGameMap(map);
        return ResponseEntity.ok(mapDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable("id") int id) {
        GameMap map = serviceGameMap.getGameMaps().stream()
            .filter(m -> m.getIdMap() == id)
            .findFirst()
            .orElse(null);
            
        if (map == null) {
            return ResponseEntity.notFound().build();
        }
        
        serviceZombie.deleteZombiesFromMap(map);
        serviceGameMap.deleteGameMap(map);
        return ResponseEntity.ok().build();
    }
}
