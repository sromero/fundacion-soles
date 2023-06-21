package com.ues21.fundacionsoles.controller;

import com.ues21.fundacionsoles.model.Tarea;
import com.ues21.fundacionsoles.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TareaController {

    @Autowired
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // Save operation
    @PostMapping("/tareas")

    public Tarea saveTarea(
            @Valid @RequestBody Tarea tarea) {
        return tareaService.saveTarea(tarea);
    }

    // Read operation
    @GetMapping("/tareas")
    public List<Tarea> fetchTareaList() {
        return tareaService.fetchTareaList();
    }

    @GetMapping("/tareas/{idTarea}")
    public Tarea fetchTareaById(@PathVariable("idTarea") Long idTarea) {
        return tareaService.fetchTareaById(idTarea);
    }

    // Update operation
    @PutMapping("/tareas/{idTarea}")

    public Tarea
    updateTarea(@RequestBody Tarea tarea,
                @PathVariable("idTarea") Long idTarea) {
        return tareaService.updateTarea(
                tarea, idTarea);
    }

    // Delete operation
    @DeleteMapping("/tareas/{idTarea}")

    public String de(@PathVariable("idTarea")
                     Long idTarea) {
        tareaService.deleteTareaById(
                idTarea);
        return "Eliminado Correctamente";
    }
}
