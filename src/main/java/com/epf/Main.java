package com.epf;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.epf.Core.models.GameMap;
import com.epf.Core.models.Plant;
import com.epf.Core.models.Zombies;
import com.epf.Persistance.ConfigBDD;
import com.epf.Persistance.DAOGameMap;
import com.epf.Persistance.DAOZombies;
import com.epf.Persistance.DAOPlant;

@ComponentScan(basePackages = "com.epf")
public class Main {
    private static void displayPlants(List<Plant> plants) {
        System.out.println("\n=== PLANTES ===");
        for (Plant plant : plants) {
            System.out.println("ID: " + plant.getId());
            System.out.println("Nom: " + plant.getNom());
            System.out.println("PV: " + plant.getPointDeVie());
            System.out.println("Coût: " + plant.getCout());
            System.out.println("Dégâts: " + plant.getDegatAttaque());
            System.out.println("Attaque/s: " + plant.getAttaqueParSeconde());
            System.out.println("Soleil/s: " + plant.getSoleilParSeconde());
            System.out.println("Effet: " + plant.getEffet());
            System.out.println("--------------------");
        }
    }

    private static void displayZombies(List<Zombies> zombies) {
        System.out.println("\n=== ZOMBIES ===");
        for (Zombies zombie : zombies) {
            System.out.println("ID: " + zombie.getId_zombie());
            System.out.println("Nom: " + zombie.getNom());
            System.out.println("PV: " + zombie.getPoint_de_vie());
            System.out.println("Attaque/s: " + zombie.getAttaque_par_seconde());
            System.out.println("Dégâts: " + zombie.getDegat_attaque());
            System.out.println("Vitesse: " + zombie.getVitesse_de_deplacement());
            System.out.println("id_map: " + zombie.getId_map());
            System.out.println("--------------------");
        }
    }

    private static void displayMaps(List<GameMap> maps) {
        System.out.println("\n=== MAPS ===");
        for (GameMap map : maps) {
            System.out.println("ID: " + map.getIdMap());
            System.out.println("Lignes: " + map.getLigne());
            System.out.println("Colonnes: " + map.getColonne());
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBDD.class)) {
            DAOPlant daoPlant = context.getBean(DAOPlant.class);
            DAOZombies daoZombie = context.getBean(DAOZombies.class);
            DAOGameMap daoGameMap = context.getBean(DAOGameMap.class);
                        
            // Récupération et affichage des données
            List<Plant> plants = daoPlant.getAllPlants();
            List<GameMap> maps = daoGameMap.getAllGameMaps();
            List<Zombies> zombies = daoZombie.getAllZombies();
            List<Zombies> zombiesFromMap = daoZombie.getZombiesFromMap(maps.get(0));
            
            System.out.println("\033c"); // Clear console

            displayPlants(plants);
            displayZombies(zombies);
            displayZombies(zombiesFromMap);
            displayMaps(maps);
        }
    }
}