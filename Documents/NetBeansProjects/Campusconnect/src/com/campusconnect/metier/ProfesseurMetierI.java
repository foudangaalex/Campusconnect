
package com.campusconnect.metier;

import com.campusconnect.model.Professeur;
import dtos.ProfesseurDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pc
 */
public interface ProfesseurMetierI {
    Professeur create(Professeur prof);
    Professeur modify(Integer id,Professeur prof);
    String delete(Integer id);
    List<ProfesseurDTO> show();
    Optional<ProfesseurDTO> findById(Integer id);

}
