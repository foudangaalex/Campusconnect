/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.model;

/**
 *
 * @author pc
 */
public class Inscription {
   
    private Integer id;
    private Integer id_etu;
    private Integer id_niv;
    private Integer id_fil;
    private String annee_sco;

    public Inscription() {
    }

    public Inscription(Integer id, Integer id_etu, Integer id_niv, Integer id_fil) {
        this.id = id;
        this.id_etu = id_etu;
        this.id_niv = id_niv;
        this.id_fil = id_fil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_etu() {
        return id_etu;
    }

    public void setId_etu(Integer id_etu) {
        this.id_etu = id_etu;
    }

    public Integer getId_niv() {
        return id_niv;
    }

    public void setId_niv(Integer id_niv) {
        this.id_niv = id_niv;
    }

    public Integer getId_fil() {
        return id_fil;
    }

    public void setId_fil(Integer id_fil) {
        this.id_fil = id_fil;
    }

    public String getAnnee_sco() {
        return annee_sco;
    }

    public void setAnnee_sco(String annee_sco) {
        this.annee_sco = annee_sco;
    }
    
}
