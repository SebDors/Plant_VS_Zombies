package com.epf.API.DTO;

public class PlantDTO {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde; 
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private String effet;
    private String chemin_image;

    public PlantDTO() {}

    public PlantDTO(int id_plante, String nom, int pointDeVie, int cout, int degatAttaque, 
                   double attaqueParSeconde, double soleilParSeconde, String effet, String cheminImage) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = pointDeVie;
        this.cout = cout;
        this.degat_attaque = degatAttaque;
        this.attaque_par_seconde = attaqueParSeconde;
        this.soleil_par_seconde = soleilParSeconde;
        this.effet = effet;
        this.chemin_image = cheminImage;
    }

    // Getters
    public int getId() { return id_plante; }
    public String getNom() { return nom; }
    public int getPointDeVie() { return point_de_vie; }
    public double getAttaqueParSeconde() { return attaque_par_seconde; }
    public int getDegatAttaque() { return degat_attaque; }
    public int getCout() { return cout; }
    public double getSoleilParSeconde() { return soleil_par_seconde; }
    public String getEffet() { return effet; }
    public String getCheminImage() { return chemin_image; }

    // Setters
    public void setId(int id) { this.id_plante = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPointDeVie(int point_de_vie) { this.point_de_vie = point_de_vie; }
    public void setAttaqueParSeconde(double attaque_par_seconde) { this.attaque_par_seconde = attaque_par_seconde; }
    public void setDegatAttaque(int degat_attaque) { this.degat_attaque = degat_attaque; }
    public void setCout(int cout) { this.cout = cout; }
    public void setSoleilParSeconde(double soleil_par_seconde) { this.soleil_par_seconde = soleil_par_seconde; }
    public void setEffet(String effet) { this.effet = effet; }
    public void setCheminImage(String chemin_image) { this.chemin_image = chemin_image; }
}
