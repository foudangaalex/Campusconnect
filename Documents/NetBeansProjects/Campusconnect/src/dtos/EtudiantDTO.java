/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 *
 * @author pc
 */
public class EtudiantDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Date datnaiss;
    private String nom_niv;
    private String nom_fil;
    private String matricule;
    
     public EtudiantDTO(){}
    public EtudiantDTO(Integer id, String nom, String prenom, String email, Date datnaiss, String nom_niv, String nom_fil, String matricule) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datnaiss = datnaiss;
        this.nom_niv = nom_niv;
        this.nom_fil = nom_fil;
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatnaiss() {
        return datnaiss;
    }

    public void setDatnaiss(Date datnaiss) {
        this.datnaiss = datnaiss;
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
    
    
}
