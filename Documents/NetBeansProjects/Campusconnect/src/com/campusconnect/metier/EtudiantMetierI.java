/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.model.Etudiant;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface EtudiantMetierI {
    Etudiant create(Etudiant e);
    Etudiant modify(Integer id,Etudiant e);
    String delete(Integer id);
    List<Etudiant> show();
    Optional<Etudiant> findById(Integer id);
}
