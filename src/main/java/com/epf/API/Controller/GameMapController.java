package com.epf.API.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.API.DTO.GameMapDTO;
import com.epf.Core.InterfaceService.ServiceGameMapInterface;
import com.epf.Core.models.GameMap;

@RestController
@RequestMapping("/maps")
@CrossOrigin(origins = "http://localhost:5173")
public class GameMapController {
    private final ServiceGameMapInterface serviceGameMap;

    public GameMapController(ServiceGameMapInterface serviceGameMap) {
        this.serviceGameMap = serviceGameMap;
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
    public ResponseEntity<GameMapDTO> updateMap(@PathVariable int id, @RequestBody GameMapDTO mapDTO) {
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
    public ResponseEntity<Void> deleteMap(@PathVariable int id) {
        GameMap map = serviceGameMap.getGameMaps().stream()
            .filter(m -> m.getIdMap() == id)
            .findFirst()
            .orElse(null);
            
        if (map == null) {
            return ResponseEntity.notFound().build();
        }
        
        serviceGameMap.deleteGameMap(map);
        return ResponseEntity.ok().build();
    }
}
