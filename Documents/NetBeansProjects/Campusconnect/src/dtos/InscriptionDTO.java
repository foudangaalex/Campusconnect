/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author pc
 */
public  class InscriptionDTO{
     private Integer id;
    private String nom_etu;
    private String nom_niv;
    private String nom_fil;
    private String annee_sco;

    public InscriptionDTO() {
    }

    public InscriptionDTO(Integer id, String nom_etu, String nom_niv, String nom_fil) {
        this.id = id;
        this.nom_etu = nom_etu;
        this.nom_niv = nom_niv;
        this.nom_fil= nom_fil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom_etu() {
        return nom_etu;
    }

    public void setNom_etu(String nom_etu) {
        this.nom_etu = nom_etu;
    }

    public String getNom_niv() {
        return nom_niv;
    }

    public void setNom_niv(String nom_niv) {
        this.nom_niv = nom_niv;
    }

    public String getNom_fil() {
        return nom_fil;
    }

    public void setNom_fil(String nom_fil) {
        this.nom_fil = nom_fil;
    }

    public String getAnnee_sco() {
        return annee_sco;
    }

    public void setAnnee_sco(String annee_sco) {
        this.annee_sco = annee_sco;
    }

    @Override
    public String toString() {
        return nom_etu ;
    }

   

  
}
