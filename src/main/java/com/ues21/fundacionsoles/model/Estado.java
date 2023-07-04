package com.ues21.fundacionsoles.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;


@Entity
@Table(name = "estado")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String estado;
    private boolean active;

    @OneToMany(mappedBy = "estado")
    @Cascade(CascadeType.ALL)
    @JsonBackReference
    private List<Tarea> tareas;

}
