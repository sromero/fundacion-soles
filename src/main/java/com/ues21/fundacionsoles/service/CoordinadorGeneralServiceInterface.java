package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.CoordinadorGeneral;

import java.util.List;

public interface CoordinadorGeneralServiceInterface {

    // Save operation
    CoordinadorGeneral saveCoordinadorG(CoordinadorGeneral coordinadorGeneral);

    // Read operation
    List<CoordinadorGeneral> fetchCoordinadorGeneralList();

    CoordinadorGeneral fetchCoordinadorGeneralById(Long idCoordinador);

    // Update operation
    CoordinadorGeneral updateCoordinadorGeneral(CoordinadorGeneral coordinadorGeneral,
                                             Long idCoordinador);

    // Delete operation
    void deleteCoordinadorGeneralById(Long idCoordinador);
}
