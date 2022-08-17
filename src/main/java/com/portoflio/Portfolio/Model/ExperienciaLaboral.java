package com.portoflio.Portfolio.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class ExperienciaLaboral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private Boolean esTrabajoActual;
    private String tipoEmpleo;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombre, String descripcion, String fechaInicio, String fechaFin, Boolean esTrabajoActual, String tipoEmpleo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esTrabajoActual = esTrabajoActual;
        this.tipoEmpleo = tipoEmpleo;
    }
    
    
}
