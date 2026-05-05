
package com.campusconnect.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Etudiant extends Personne{
    private String matricule;
    

    public Etudiant() {
        super();
    }
    
    public Etudiant(Integer id,String nom,String prenom,String email,Date datnaiss,String matricule) {
        super(id,nom,prenom,email,datnaiss);
        this.matricule = matricule;
        
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

  

    @Override
    public String toString() {
        return nom;
    }

   
    
    
}
