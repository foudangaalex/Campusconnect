/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.model.Departement;
import com.campusconnect.model.Salle;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface SalletMetierI {
    Salle create(Salle s);
    Salle modify(Integer id,Salle s);
    String delete(Integer id);
    List<Salle> show();
    Optional<Salle> findById(Integer id);
}
