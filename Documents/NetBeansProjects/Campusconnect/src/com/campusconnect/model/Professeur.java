
package com.campusconnect.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Professeur extends Personne {
    private String statut;
    private Integer id_dept;

    public Professeur(Integer id, String nom, String prenom, String email, Date datnaiss,String statut,Integer id_dept) {
        super(id, nom, prenom, email, datnaiss);
        this.statut=statut;
        this.id_dept=id_dept;
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

    public Integer getId_dept() {
        return id_dept;
    }

    public void setId_dept(Integer id_dept) {
        this.id_dept = id_dept;
    }


    @Override
    public String toString() {
        return statut ;
    }
    
}
