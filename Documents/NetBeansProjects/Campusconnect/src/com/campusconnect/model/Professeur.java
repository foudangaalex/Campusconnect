
package com.campusconnect.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Professeur extends Personne {
    private String statut;
    private String departement;

    public Professeur(Integer id, String nom, String prenom, String email, Date datnaiss,String statut,String departement) {
        super(id, nom, prenom, email, datnaiss);
        this.statut=statut;
        this.departement=departement;
    }

    public Professeur() {
        super();
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
    
}
