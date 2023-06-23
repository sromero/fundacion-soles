package com.ues21.fundacionsoles.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coordinador_general")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoordinadorGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordinador;
    private String nombre;
    private String apellido;


}
