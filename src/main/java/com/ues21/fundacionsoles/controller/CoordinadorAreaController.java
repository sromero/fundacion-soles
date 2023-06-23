package com.ues21.fundacionsoles.controller;


import com.ues21.fundacionsoles.model.CoordinadorArea;
import com.ues21.fundacionsoles.service.CoordinadorAreaService;
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
public class CoordinadorAreaController {

    @Autowired
    private final CoordinadorAreaService coordinadorAreaService;

    public CoordinadorAreaController(CoordinadorAreaService coordinadorAreaService) {
        this.coordinadorAreaService = coordinadorAreaService;
    }

    // Save operation
    @PostMapping("/coordinadoresA")

    public CoordinadorArea saveCoordinadorA(
            @Valid @RequestBody CoordinadorArea coordinadorArea)
    {
        return coordinadorAreaService.saveCoordinadorA(coordinadorArea);
    }

    // Read operation
    @GetMapping("/coordinadoresA")
    public List<CoordinadorArea> fetchCoordinadorAreaList()
    {
        return coordinadorAreaService.fetchCoordinadorAreaList();
    }

    @GetMapping("/coordinadoresA/{idCoordinador}")
    public CoordinadorArea fetchCoordinadorAreaById(@PathVariable("idCoordinador") Long idCoordinador){
        return coordinadorAreaService.fetchCoordinadorAreaById(idCoordinador);
    }

    // Update operation
    @PutMapping("/coordinadoresA/{idCoordinador}")

    public CoordinadorArea
    updateCoordinadorArea(@RequestBody CoordinadorArea coordinadorArea,
               @PathVariable("idCoordinador") Long idCoordinador)
    {
        return coordinadorAreaService.updateCoordinadorArea(
                coordinadorArea, idCoordinador);
    }

    // Delete operation
    @DeleteMapping("/coordinadoresA/{idCoordinador}")

    public String de(@PathVariable("idCoordinador")
                     Long idCoordinador)
    {
        coordinadorAreaService.deleteCoordinadorAreaById(
                idCoordinador);
        return "Eliminado Correctamente";
    }

}
