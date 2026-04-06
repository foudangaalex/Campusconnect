/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.model.Departement;
import com.campusconnect.model.Matiere;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface MatiereMetierI {
    Matiere create(Matiere m);
    Matiere modify(Integer id,Matiere m);
    String delete(Integer id);
    List<Matiere> show();
    Optional<Matiere> findById(Integer id);
}
