/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.model;

/**
 *
 * @author pc
 */
public class Niveau {
    private Integer id;
    private String nom;
    private Integer id_dept;
    public Niveau(){}

    public Niveau(Integer id, String nom,Integer id_dept) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId_dept() {
        return id_dept;
    }

    public void setId_dept(Integer id_dept) {
        this.id_dept = id_dept;
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

    @Override
    public String toString() {
        return  nom ;
    }
    
}
