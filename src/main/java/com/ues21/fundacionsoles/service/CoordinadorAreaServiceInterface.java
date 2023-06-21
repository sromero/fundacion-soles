package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.CoordinadorArea;

import java.util.List;

public interface CoordinadorAreaServiceInterface {

    // Save operation
    CoordinadorArea saveCoordinadorA(CoordinadorArea coordinadorArea);

    // Read operation
    List<CoordinadorArea> fetchCoordinadorAreaList();

    CoordinadorArea fetchCoordinadorAreaById(Long idCoordinador);

    // Update operation
    CoordinadorArea updateCoordinadorArea(CoordinadorArea coordinadorArea,
                                                Long idCoordinador);

    // Delete operation
    void deleteCoordinadorAreaById(Long idCoordinador);
}
