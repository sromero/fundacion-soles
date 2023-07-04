package com.ues21.fundacionsoles.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "voluntario")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private  String direccion;
    private int telefono;
    private String correo;
    private String disponibilidadHoraria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idArea")
    private Area area;

    @JsonIgnore
    @JsonManagedReference
    @JsonIgnoreProperties("voluntario")
    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL)
    private List<Tarea> tareasAsignadas;
}
