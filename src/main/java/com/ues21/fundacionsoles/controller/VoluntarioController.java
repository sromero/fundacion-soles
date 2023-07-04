package com.ues21.fundacionsoles.controller;

import com.ues21.fundacionsoles.model.Voluntario;
import com.ues21.fundacionsoles.service.VoluntarioService;
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
@PreAuthorize("hasAnyRole('ROLE_VOLUNTARIO', 'ROLE_COORDINADOR')")
public class VoluntarioController {

    @Autowired
    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    // Save operation
    @PostMapping("/voluntarios")
    public Voluntario saveVoluntario(
            @Valid @RequestBody Voluntario voluntario) {
        return voluntarioService.saveVoluntario(voluntario);
    }

    // Read operation
    @GetMapping("/voluntarios")
    public List<Voluntario> fetchVoluntarioList() {
        return voluntarioService.fetchVoluntarioList();
    }

    @GetMapping("/voluntarios/{id}")
    public Voluntario fetchVoluntarioById(@PathVariable("id") Long id) {
        return voluntarioService.fetchVoluntarioById(id);
    }

    // Update operation
    @PutMapping("/voluntarios/{id}")
    public Voluntario
    updateVoluntariot(@RequestBody Voluntario voluntario,
                      @PathVariable("id") Long id) {
        return voluntarioService.updateVoluntario(
                voluntario, id);
    }

    // Delete operation
    @DeleteMapping("/voluntarios/{id}")
    public String de(@PathVariable("id")
                     Long id) {
        voluntarioService.deleteVoluntarioById(
                id);
        return "Eliminado Correctamente";
    }
}
