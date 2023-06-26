package com.ues21.fundacionsoles.controller;

import com.ues21.fundacionsoles.model.CoordinadorGeneral;
import com.ues21.fundacionsoles.service.CoordinadorGeneralService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasAnyRole('ROLE_COORDINADOR', 'ROLE_ADMINISTRADOR')")
public class CoordinadorGeneralController {

    @Autowired
    private final CoordinadorGeneralService coordinadorGeneralService;

    public CoordinadorGeneralController(CoordinadorGeneralService coordinadorGeneralService) {
        this.coordinadorGeneralService = coordinadorGeneralService;
    }

    // Save operation
    @PostMapping("/coordinadoresG")

    public CoordinadorGeneral saveCoordinadorGeneral(
            @Valid @RequestBody CoordinadorGeneral coordinadorGeneral)
    {
        return coordinadorGeneralService.saveCoordinadorG(coordinadorGeneral);
    }

    // Read operation
    @GetMapping("/coordinadoresG")
    public List<CoordinadorGeneral> fetchCoordinadorGeneralList()
    {
        return coordinadorGeneralService.fetchCoordinadorGeneralList();
    }

    @GetMapping("/coordinadoresG/{idCoordinador}")
    public CoordinadorGeneral fetchCoordinadorGeneralById(@PathVariable("idCoordinador") Long idCoordinador){
        return coordinadorGeneralService.fetchCoordinadorGeneralById(idCoordinador);
    }

    // Update operation
    @PutMapping("/coordinadoresG/{idCoordinador}")

    public CoordinadorGeneral
    updateCoordinadorGeneral(@RequestBody CoordinadorGeneral coordinadorGeneral,
                     @PathVariable("idCoordinador") Long idCoordinador)
    {
        return coordinadorGeneralService.updateCoordinadorGeneral(
                coordinadorGeneral, idCoordinador);
    }

    // Delete operation
    @DeleteMapping("/coordinadoresG/{idCoordinador}")

    public String de(@PathVariable("idCoordinador")
                     Long idCoordinador)
    {
        coordinadorGeneralService.deleteCoordinadorGeneralById(
                idCoordinador);
        return "Eliminado Correctamente";
    }


}
