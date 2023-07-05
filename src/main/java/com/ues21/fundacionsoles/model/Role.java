package com.ues21.fundacionsoles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstado;
    private String name;

    @JsonIgnoreProperties("estado")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "area")
    private List<Tarea> tareas;
}
