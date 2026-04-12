/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.model.Niveau;
import dtos.NiveauDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface NiveauMetierI {
    Niveau create(Niveau niv);
    Niveau modify(Integer id,Niveau niv);
    String delete(Integer id);
    List<NiveauDTO> show();
    Optional<NiveauDTO> findById(Integer id);
}
