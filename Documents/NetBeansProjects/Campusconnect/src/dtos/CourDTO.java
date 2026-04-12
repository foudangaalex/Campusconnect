/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author pc
 */
public class CourDTO {
    private Integer id;
    private String code;
    private String nom;
    private String nom_prof;
    private String nom_niv;
    private String nbre_heure;
    private Integer coef;
    private String nom_sal;

    public CourDTO() {
    }
    
    public CourDTO(Integer id, String code, String nom, String nom_prof, String nom_niv, String nbre_heure, Integer coef, String nom_sal) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.nom_prof = nom_prof;
        this.nom_niv = nom_niv;
        this.nbre_heure = nbre_heure;
        this.coef = coef;
        this.nom_sal = nom_sal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_prof() {
        return nom_prof;
    }

    public void setNom_prof(String nom_prof) {
        this.nom_prof = nom_prof;
    }

    public String getNom_niv() {
        return nom_niv;
    }

    public void setNom_niv(String nom_niv) {
        this.nom_niv = nom_niv;
    }

    public String getNbre_heure() {
        return nbre_heure;
    }

    public void setNbre_heure(String nbre_heure) {
        this.nbre_heure = nbre_heure;
    }

    public Integer getCoef() {
        return coef;
    }

    public void setCoef(Integer coef) {
        this.coef = coef;
    }

    public String getNom_sal() {
        return nom_sal;
    }

    public void setNom_sal(String nom_sal) {
        this.nom_sal = nom_sal;
    }
    
    
}
