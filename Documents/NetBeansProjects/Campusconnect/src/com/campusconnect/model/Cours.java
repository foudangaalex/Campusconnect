/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.model;

/**
 *
 * @author pc
 */
public class Cours {
    private Integer id;
    private String code;
    private String nom;
    private Integer id_ens;
    private Integer id_niv;
    private String nbre_heure;
    private Integer coef;
    private Integer id_sal;
    
    public Cours(){}

    public Cours(Integer id, String code, String nom, Integer id_ens, Integer id_niv, String nbre_heure, Integer coef, Integer id_sal) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.id_ens = id_ens;
        this.id_niv = id_niv;
        this.nbre_heure = nbre_heure;
        this.coef = coef;
        this.id_sal = id_sal;
    }

    public Integer getId_ens() {
        return id_ens;
    }

    public void setId_ens(Integer id_ens) {
        this.id_ens = id_ens;
    }

    public Integer getId_niv() {
        return id_niv;
    }

    public void setId_niv(Integer id_niv) {
        this.id_niv = id_niv;
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

    public Integer getId_sal() {
        return id_sal;
    }

    public void setId_sal(Integer id_sal) {
        this.id_sal = id_sal;
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
    
}
