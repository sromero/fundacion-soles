package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.Tarea;

import java.util.List;

public interface TareaServiceInterface {

    // Save operation
    Tarea saveTarea(Tarea tarea);

    // Read operation
    List<Tarea> fetchTareaList();

    Tarea fetchTareaById(Long idTarea);

    // Update operation
    Tarea updateTarea(Tarea tarea,
                                Long idTarea);

    // Delete operation
    void deleteTareaById(Long idTarea);
}
