package com.epf.API.Controller;

import com.epf.API.DTO.PlantDTO;
import com.epf.Core.InterfaceService.ServicePlantInterface;
import com.epf.Core.models.Plant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
@CrossOrigin(origins = "http://localhost:5173")
public class PlantController {
    private static final Logger logger = LoggerFactory.getLogger(PlantController.class);
    
    private final ServicePlantInterface servicePlant;

    public PlantController(ServicePlantInterface servicePlant) {
        this.servicePlant = servicePlant;
    }

    @GetMapping
    public ResponseEntity<List<PlantDTO>> getAllPlants() {
        logger.info("Accessing getAllPlants endpoint");
        List<Plant> plants = servicePlant.getAllPlants(); // Correction de gatAllPlants en getAllPlants
        List<PlantDTO> plantDTOs = plants.stream()
            .map(p -> new PlantDTO(
                p.getId_plante(),
                p.getNom(),
                p.getPointDeVie(),
                p.getCout(),
                p.getDegatAttaque(),
                p.getAttaqueParSeconde(),
                p.getSoleilParSeconde(),
                p.getEffet(),
                p.getCheminImage()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(plantDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> getPlantById(@PathVariable int id) {
        Plant plant = servicePlant.getAllPlants().stream()
            .filter(p -> p.getId_plante() == id)
            .findFirst()
            .orElse(null);
        
        if (plant == null) {
            return ResponseEntity.notFound().build();
        }

        PlantDTO plantDTO = new PlantDTO(
            plant.getId_plante(),
            plant.getNom(),
            plant.getPointDeVie(),
            plant.getCout(),
            plant.getDegatAttaque(),
            plant.getAttaqueParSeconde(),
            plant.getSoleilParSeconde(),
            plant.getEffet(),
            plant.getCheminImage()
        );
        
        return ResponseEntity.ok(plantDTO);
    }

    @PostMapping
    public ResponseEntity<PlantDTO> createPlant(@RequestBody PlantDTO plantDTO) {
        Plant plant = new Plant(
            plantDTO.getNom(),
            plantDTO.getPointDeVie(),
            plantDTO.getCout(),
            plantDTO.getDegatAttaque(),
            plantDTO.getAttaqueParSeconde(),
            plantDTO.getSoleilParSeconde(),
            plantDTO.getEffet(),
            plantDTO.getCheminImage()
        );
        
        servicePlant.addPlant(plant);
        return ResponseEntity.ok(plantDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantDTO> updatePlant(@PathVariable int id, @RequestBody PlantDTO plantDTO) {
        Plant plant = new Plant(
            plantDTO.getNom(),
            plantDTO.getPointDeVie(),
            plantDTO.getCout(),
            plantDTO.getDegatAttaque(),
            plantDTO.getAttaqueParSeconde(),
            plantDTO.getSoleilParSeconde(),
            plantDTO.getEffet(),
            plantDTO.getCheminImage()
        );
        plant.setId_plante(id);
        
        servicePlant.updatePlant(plant);
        return ResponseEntity.ok(plantDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable int id) {
        Plant plant = servicePlant.getAllPlants().stream()
            .filter(p -> p.getId_plante() == id)
            .findFirst()
            .orElse(null);
            
        if (plant == null) {
            return ResponseEntity.notFound().build();
        }
        
        servicePlant.deletePlant(plant);
        return ResponseEntity.ok().build();
    }
}
