package com.ues21.fundacionsoles.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "area")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
    private String nombre;

    @JsonIgnore
    @Transient
    private int cantidadVoluntarios;

    @JsonIgnore
    @Transient
    private int cantidadTareas;

    @JsonIgnoreProperties("area")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "area")
    private List<Voluntario> voluntarios;

    @OneToOne(mappedBy = "area")
    private CoordinadorArea coordinadorArea;

    @JsonIgnoreProperties("area")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "area")
    private List<Tarea> tareas;

    public int getCantidadVoluntariosAsignados() {
        if (voluntarios != null) {
          return cantidadVoluntarios = voluntarios.size();
        } else {
            return 0;
        }
    }

    public int getCantidadTareasAsignadas() {
        if (tareas != null) {
            return cantidadTareas = tareas.size();
        } else {
            return 0;
        }
    }


}
