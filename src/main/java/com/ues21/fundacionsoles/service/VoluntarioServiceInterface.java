package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.Voluntario;

import java.util.List;


public interface VoluntarioServiceInterface {

    // Save operation
    Voluntario saveVoluntario(Voluntario voluntario);

    // Read operation
    List<Voluntario> fetchVoluntarioList();

    Voluntario fetchVoluntarioById(Long id);

    // Update operation
    Voluntario updateVoluntario(Voluntario voluntario,
                                Long id);

    // Delete operation
    void deleteVoluntarioById(Long id);
}
