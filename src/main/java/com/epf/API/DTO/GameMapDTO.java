package com.epf.API.DTO;

public class GameMapDTO {
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    // Constructeur par défaut
    public GameMapDTO(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    // Getters
    public int getIdMap() { return id_map; }
    public int getLigne() { return ligne; }
    public int getColonne() { return colonne; }
    public String getCheminImage() { return chemin_image; }

    // Setters
    public void setIdMap(int id_map) { this.id_map = id_map; }
    public void setLigne(int ligne) { this.ligne = ligne; }
    public void setColonne(int colonne) { this.colonne = colonne; }
    public void setCheminImage(String chemin_image) { this.chemin_image = chemin_image; }
}
