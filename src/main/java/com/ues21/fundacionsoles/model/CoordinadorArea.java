package com.ues21.fundacionsoles.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coordinador_area")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoordinadorArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordinador;
    private String nombre;
    private String apellido;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idArea")
    private Area area;
}
