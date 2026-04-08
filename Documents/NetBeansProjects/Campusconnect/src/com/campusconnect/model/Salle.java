/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.model;

/**
 *
 * @author pc
 */
public class Salle {
   private Integer id;
   private String nom;
   private Integer cap_max;
   
   public Salle(){}

    public Salle(Integer id, String name, Integer cap_max) {
        this.id = id;
        this.nom = name;
        this.cap_max = cap_max;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCap_max() {
        return cap_max;
    }

    public void setCap_max(Integer cap_max) {
        this.cap_max = cap_max;
    }
   
}
