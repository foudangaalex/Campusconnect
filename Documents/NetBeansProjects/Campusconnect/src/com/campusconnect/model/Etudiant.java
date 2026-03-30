/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Etudiant extends Personne{
    private String matricule;
    private String anneeEtude;
    private String filiere;

    public Etudiant() {
        super();
    }
    
    public Etudiant(Integer id,String nom,String prenom,String email,Date datnaiss,String matricule, String anneeEtude, String filiere) {
        super(id,nom,prenom,email,datnaiss);
        this.matricule = matricule;
        this.anneeEtude = anneeEtude;
        this.filiere = filiere;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getAnneeEtude() {
        return anneeEtude;
    }

    public void setAnneeEtude(String anneeEtude) {
        this.anneeEtude = anneeEtude;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    
    
}
