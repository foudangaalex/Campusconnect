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
public class ProfesseurDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Date datnaiss;
    private String nom_dept;
    private String statut;
    
     public ProfesseurDTO(){}
    public ProfesseurDTO(Integer id, String nom, String prenom, String email, Date datnaiss, String nom_fil, String matricule) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datnaiss = datnaiss;
        this.nom_dept = nom_fil;
        this.statut = matricule;
    }

    public String getMatricule() {
        return statut;
    }

    public void setMatricule(String matricule) {
        this.statut = matricule;
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

    public String getNom_dept() {
        return nom_dept;
    }

    public void setNom_dept(String nom_dept) {
        this.nom_dept = nom_dept;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return  nom +""+ prenom+""+ statut ;
    }

    

   
}
