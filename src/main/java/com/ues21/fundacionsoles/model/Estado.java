package com.ues21.fundacionsoles.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import org.hibernate.annotations.Cascade;

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
    private long idEstado;

    private String descripcion; //in-progress o completed o cancelled
    private boolean active; //true o false

    @JsonIgnoreProperties("estado")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "estado")
    private List<Tarea> tareas;

}
