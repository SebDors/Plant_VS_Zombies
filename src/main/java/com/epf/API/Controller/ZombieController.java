package com.epf.API.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.API.DTO.ZombieDTO;
import com.epf.Core.InterfaceService.ServiceZombieInterface;
import com.epf.Core.models.GameMap;
import com.epf.Core.models.Zombie;

@RestController
@RequestMapping("/zombies")
@CrossOrigin(origins = "http://localhost:5173")
public class ZombieController {
    private final ServiceZombieInterface serviceZombie;

    public ZombieController(ServiceZombieInterface serviceZombie) {
        this.serviceZombie = serviceZombie;
    }

    @GetMapping
    public ResponseEntity<List<ZombieDTO>> getAllZombies(){
        List<Zombie> zombies = serviceZombie.getAllZombies();
        List<ZombieDTO> zombieDTOs = zombies.stream()
            .map(z -> new ZombieDTO(
                z.getId_zombie(),
                z.getNom(),
                z.getPoint_de_vie(),
                z.getAttaque_par_seconde(),
                z.getDegat_attaque(),
                z.getVitesse_de_deplacement(),
                z.getChemin_image(),
                z.getId_map()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(zombieDTOs);
    }

    @PostMapping
    public ResponseEntity<ZombieDTO> createZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(
            zombieDTO.getId_zombie(),
            zombieDTO.getNom(),
            zombieDTO.getPoint_de_vie(),
            zombieDTO.getAttaque_par_seconde(),
            zombieDTO.getDegat_attaque(),
            zombieDTO.getVitesse_de_deplacement(),
            zombieDTO.getChemin_image(),
            zombieDTO.getId_map()
        );
        serviceZombie.addZombie(zombie);
        return ResponseEntity.ok(zombieDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZombieDTO> updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) {
        zombieDTO.setId_zombie(id);
        Zombie zombie = new Zombie(
            zombieDTO.getId_zombie(),
            zombieDTO.getNom(),
            zombieDTO.getPoint_de_vie(),
            zombieDTO.getAttaque_par_seconde(),
            zombieDTO.getDegat_attaque(),
            zombieDTO.getVitesse_de_deplacement(),
            zombieDTO.getChemin_image(),
            zombieDTO.getId_map()
        );
        serviceZombie.updateZombie(zombie);
        return ResponseEntity.ok(zombieDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZombie(@PathVariable("id") int id) {
        Zombie zombie = serviceZombie.getAllZombies().stream()
            .filter(z -> z.getId_zombie() == id)
            .findFirst()
            .orElse(null);
            
        if (zombie == null) {
            return ResponseEntity.notFound().build();
        }
        
        serviceZombie.deleteZombie(zombie);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/map/{mapId}")
    public ResponseEntity<List<ZombieDTO>> getZombiesFromMap(@PathVariable("mapId") int mapId) {
        GameMap map = new GameMap();
        map.setIdMap(mapId);
        List<Zombie> zombies = serviceZombie.getZombiesFromMap(map);
        List<ZombieDTO> zombieDTOs = zombies.stream()
            .map(z -> new ZombieDTO(
                z.getId_zombie(),
                z.getNom(),
                z.getPoint_de_vie(),
                z.getAttaque_par_seconde(),
                z.getDegat_attaque(),
                z.getVitesse_de_deplacement(),
                z.getChemin_image(),
                z.getId_map()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(zombieDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getZombieById(@PathVariable("id") int id) {
        Zombie zombie = serviceZombie.getAllZombies().stream()
            .filter(z -> z.getId_zombie() == id)
            .findFirst()
            .orElse(null);
        
        if (zombie == null) {
            return ResponseEntity.notFound().build();
        }

        ZombieDTO zombieDTO = new ZombieDTO(
            zombie.getId_zombie(),
            zombie.getNom(),
            zombie.getPoint_de_vie(),
            zombie.getAttaque_par_seconde(),
            zombie.getDegat_attaque(),
            zombie.getVitesse_de_deplacement(),
            zombie.getChemin_image(),
            zombie.getId_map()
        );
        
        return ResponseEntity.ok(zombieDTO);
    }
}
