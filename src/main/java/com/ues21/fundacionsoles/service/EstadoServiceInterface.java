package com.ues21.fundacionsoles.service;


import com.ues21.fundacionsoles.model.Estado;

import java.util.List;

public interface EstadoServiceInterface {

    // Save operation
    Estado saveEstado(Estado estado);

    // Read operation
    List<Estado> fetchEstadoList();

    Estado fetchEstadoById(Long idEstado);

    // Update operation
    Estado updateEstado(Estado estado,
                                             Long idEstado);

    // Delete operation
    void deleteAEstadoById(Long idEstado);
}
