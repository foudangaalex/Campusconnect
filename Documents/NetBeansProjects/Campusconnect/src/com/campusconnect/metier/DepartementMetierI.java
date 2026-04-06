/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.model.Departement;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface DepartementMetierI {
    Departement create(Departement d);
    Departement modify(Integer id,Departement d);
    String delete(Integer id);
    List<Departement> show();
    Optional<Departement> findById(Integer id);
}
