/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author pc
 */
public class CourDTO {
    private Integer id;
    private String code;
    private String nom;
    private Integer coef;
    ;

    public CourDTO() {
    }
    
    public CourDTO(Integer id, String code, String nom, Integer coef) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        
        this.coef = coef;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCoef() {
        return coef;
    }

    public void setCoef(Integer coef) {
        this.coef = coef;
    }

   

    @Override
    public String toString() {
        return  nom ;
    }
    
    
}
