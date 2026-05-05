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
    private String matricule;
    
     public EtudiantDTO(){}
    public EtudiantDTO(Integer id, String nom, String prenom, String email, Date datnaiss, String matricule) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datnaiss = datnaiss;
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

    @Override
    public String toString() {
        return nom + " " + prenom ;
    }

  
    
    
}
