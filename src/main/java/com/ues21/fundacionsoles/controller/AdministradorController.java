package com.ues21.fundacionsoles.controller;

import com.ues21.fundacionsoles.model.AdministradorSistema;
import com.ues21.fundacionsoles.service.AdministradorService;
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
@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
public class AdministradorController {

    @Autowired
    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    // Save operation
    @PostMapping("/administradores")
    public AdministradorSistema saveAdministrador(
            @Valid @RequestBody AdministradorSistema administradorSistema)
    {
        return administradorService.saveAdministrador(administradorSistema);
    }

    // Read operation
    @GetMapping("/administradores")
    public List<AdministradorSistema> fetchAdministradorList()
    {
        return administradorService.fetchAdministradorList();
    }


    @GetMapping("/administradores/{idAdministrador}")
    public AdministradorSistema fetchAdministradorById(@PathVariable("idAdministrador") Long idAdministrador){
        return administradorService.fetchAdministradorById(idAdministrador);
    }

    // Update operation
    @PutMapping("/administradores/{idAdministrador}")
    public AdministradorSistema
    updateAdministrador(@RequestBody AdministradorSistema administradorSistema,
               @PathVariable("idAdministrador") Long idAdministrador)
    {
        return administradorService.updateAdministrador(
                administradorSistema, idAdministrador);
    }

    // Delete operation
    @DeleteMapping("/administradores/{idAdministrador}")
    public String de(@PathVariable("idAdministrador")
                     Long idAdministrador)
    {
        administradorService.deleteAdministradorById(
                idAdministrador);
        return "Eliminado Correctamente";
    }
}
