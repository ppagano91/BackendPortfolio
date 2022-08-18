package com.portoflio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaLaboralDto {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String fechaInicio;
    
    private String fechaFin;
    
    @NotBlank
    private Boolean esTrabajoActual;    
    
    private String tipoEmpleo;

    
    //Constructores
    public ExperienciaLaboralDto() {
    }    
    
    public ExperienciaLaboralDto(String nombre, String descripcion, String fechaInicio, String fechaFin, Boolean esTrabajoActual, String tipoEmpleo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esTrabajoActual = esTrabajoActual;
        this.tipoEmpleo = tipoEmpleo;
    }
    
    
    
}
