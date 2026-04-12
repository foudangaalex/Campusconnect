/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.model.Departement;
import com.campusconnect.model.Cours;
import dtos.CourDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface CourMetierI {
    Cours create(Cours m);
    Cours modify(Integer id,Cours m);
    String delete(Integer id);
    List<CourDTO> show();
    Optional<CourDTO> findById(Integer id);
}
