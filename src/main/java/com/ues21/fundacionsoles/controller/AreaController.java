package com.ues21.fundacionsoles.controller;

import com.ues21.fundacionsoles.model.Area;
import com.ues21.fundacionsoles.service.AreaService;
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
public class AreaController {

    @Autowired
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    // Save operation
    @PostMapping("/areas")
    public Area saveArea(
            @Valid @RequestBody Area area)
    {
        return areaService.saveArea(area);
    }




    // Read operation
    @GetMapping("/areas")
    public List<Area> fetchAreaList()
    {
        List<Area> areaList = areaService.fetchAreaList();

        for (Area area : areaList) {
            int cantidadVoluntarios = area.getCantidadVoluntariosAsignados();
            area.setCantidadVoluntarios(cantidadVoluntarios);

            int cantidadTareas = area.getCantidadTareasAsignadas();
            area.setCantidadTareas(cantidadTareas);

            areaService.saveArea(area);

        }

        return areaService.fetchAreaList();
    }

    @GetMapping("/areas/{idArea}")
    public Area fetchAreaById(@PathVariable("idArea") Long idArea){
        Area area = areaService.fetchAreaById(idArea);
        int cantidadVoluntarios = area.getCantidadVoluntariosAsignados();
        int cantidadTareas = area.getCantidadTareasAsignadas();
        areaService.saveArea(area);

        return areaService.fetchAreaById(idArea);
    }

    // Update operation
    @PutMapping("/areas/{idArea}")

    public Area
    updateArea(@RequestBody Area area,
                     @PathVariable("idArea") Long idArea)
    {
        return areaService.updateArea(
                area, idArea);
    }

    // Delete operation
    @DeleteMapping("/areas/{idArea}")

    public String de(@PathVariable("idArea")
                     Long idArea)
    {
        areaService.deleteAreaById(
                idArea);
        return "Eliminado Correctamente";
    }
}
