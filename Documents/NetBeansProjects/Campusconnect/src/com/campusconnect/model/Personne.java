
package com.campusconnect.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public abstract class Personne {
    protected Integer id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected Date datnaiss;

    public Personne() {
    }
    
    public Personne(Integer id,String nom,String prenom,String email,Date datnaiss){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.datnaiss=datnaiss;
        this.email=email;
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
     
}
