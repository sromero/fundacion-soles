package com.ues21.fundacionsoles.controller;

import com.ues21.fundacionsoles.model.AdministradorSistema;
import com.ues21.fundacionsoles.model.Area;
import com.ues21.fundacionsoles.model.Estado;
import com.ues21.fundacionsoles.service.AreaService;
import com.ues21.fundacionsoles.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstadoController {


    @Autowired
    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    // Save operation
    @PostMapping("/estados")
    public Estado saveEstado(
            @Valid @RequestBody Estado estado)
    {
        return estadoService.saveEstado(estado);
    }


    @GetMapping("/estados")
    public List<Estado> fetchEstadoList()
    {
        return estadoService.fetchEstadoList();
    }


    @GetMapping("/estados/{idEstado}")
    public Estado fetchEstadoById(@PathVariable("idEstado") Long idEstado){
        return estadoService.fetchEstadoById(idEstado);
    }

    // Update operation
    @PutMapping("/estados/{idEstado}")
    public Estado
    updateEstado(@RequestBody Estado estado,
                        @PathVariable("idEstado") Long idEstado)
    {
        return estadoService.updateEstado(
                estado, idEstado);
    }

    // Delete operation
    @DeleteMapping("/estados/{idEstado}")
    public String de(@PathVariable("idEstado")
                     Long idEstado)
    {
        estadoService.deleteAEstadoById(
                idEstado);
        return "Eliminado Correctamente";
    }
}
