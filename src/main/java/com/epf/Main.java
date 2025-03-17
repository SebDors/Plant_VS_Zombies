package com.epf;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.epf.Core.models.Plant;
import com.epf.Persistance.ConfigBDD;
import com.epf.Persistance.DAO;

@ComponentScan(basePackages = "com.epf")
public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBDD.class)) {
            DAO dao = context.getBean(DAO.class);
            
            System.out.println("\033c"); // Clear console
            System.out.println("Liste des plantes disponibles :");
            List<Plant> plants = dao.getAllPlants();
            for (Plant plant : plants) {
                System.out.println("----------------------------------------");
                System.out.println("Nom: " + plant.getNom());
                System.out.println("Points de vie: " + plant.getPointDeVie());
                System.out.println("Coût: " + plant.getCout());
                System.out.println("Dégâts: " + plant.getDegatAttaque());
                System.out.println("Attaques par seconde: " + plant.getAttaqueParSeconde());
                System.out.println("Soleils par seconde: " + plant.getSoleilParSeconde());
                System.out.println("Effet: " + plant.getEffet());
            }
        }
    }
}