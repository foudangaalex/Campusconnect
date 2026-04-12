/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author pc
 */
public class NiveauDTO {
   private Integer id;
   private String nom_niv;
   private String nom_dept;
   
   public NiveauDTO(){}

    public NiveauDTO(Integer id, String nom_niv, String nom_dept) {
        this.id = id;
        this.nom_niv = nom_niv;
        this.nom_dept = nom_dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom_niv() {
        return nom_niv;
    }

    public void setNom_niv(String nom_niv) {
        this.nom_niv = nom_niv;
    }

    public String getNom_dept() {
        return nom_dept;
    }

    public void setNom_dept(String nom_dept) {
        this.nom_dept = nom_dept;
    }

    @Override
    public String toString() {
        return nom_niv ;
    }
   
}
