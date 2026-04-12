
package com.campusconnect.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Etudiant extends Personne{
    private String matricule;
    private Integer niveau;
    private Integer filiere;

    public Etudiant() {
        super();
    }
    
    public Etudiant(Integer id,String nom,String prenom,String email,Date datnaiss,String matricule, Integer niveau, Integer filiere) {
        super(id,nom,prenom,email,datnaiss);
        this.matricule = matricule;
        this.niveau = niveau;
        this.filiere = filiere;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Integer getFiliere() {
        return filiere;
    }

    public void setFiliere(Integer filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Etudiant{" +"nom"+super.nom+ ",matricule=" + matricule + ", niveau=" + niveau + ", filiere=" + filiere + '}';
    }

   
    
    
}
