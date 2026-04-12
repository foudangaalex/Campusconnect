/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.model.Filiere;
import com.campusconnect.model.Niveau;
import dtos.FiliereDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface FiliereMetierI {
    Filiere create(Filiere fil);
    Filiere modify(Integer id,Filiere fil);
    String delete(Integer id);
    List<FiliereDTO> show();
    Optional<FiliereDTO> findById(Integer id);
}
