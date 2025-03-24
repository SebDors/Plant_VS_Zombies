package com.epf.Core.models;

public class Plant {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private String effet;
    private String chemin_image;

    public Plant(int id_plante, String nom, int point_de_vie, int cout, int degat_attaque, double attaque_par_seconde, double soleil_par_seconde, String effet, String chemin_image) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.cout = cout;
        this.degat_attaque = degat_attaque;
        this.attaque_par_seconde = attaque_par_seconde;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }
    
    public Plant(String nom, int point_de_vie, int cout, int degat_attaque, double attaque_par_seconde, double soleil_par_seconde, String effet, String chemin_image) {
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.cout = cout;
        this.degat_attaque = degat_attaque;
        this.attaque_par_seconde = attaque_par_seconde;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

    // Getters
    public int getId_plante() { return id_plante; }
    public String getNom() { return nom; }
    public int getPointDeVie() { return point_de_vie; }
    public double getAttaqueParSeconde() { return attaque_par_seconde; }
    public int getDegatAttaque() { return degat_attaque; }
    public int getCout() { return cout; }
    public double getSoleilParSeconde() { return soleil_par_seconde; }
    public String getEffet() { return effet; }
    public String getCheminImage() { return chemin_image; }

    // Setters
    public void setId_plante(int id_plante) { this.id_plante = id_plante; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPointDeVie(int point_de_vie) { this.point_de_vie = point_de_vie; }
    public void setAttaqueParSeconde(int attaque_par_seconde) { this.attaque_par_seconde = attaque_par_seconde; }
    public void setDegatAttaque(int degat_attaque) { this.degat_attaque = degat_attaque; }
    public void setCout(int cout) { this.cout = cout; }
    public void setSoleilParSeconde(int soleil_par_seconde) { this.soleil_par_seconde = soleil_par_seconde; }
    public void setEffet(String effet) { this.effet = effet; }
    public void setCheminImage(String chemin_image) { this.chemin_image = chemin_image; }
}
