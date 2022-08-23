package com.portoflio.Portfolio.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FormacionAcademicaDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    
    private String institucion;
    
    @NotBlank
    private String fechaInicio;
    
    private String fechaFin;
    
    //@NotBlank
    private String estado;
    
    private String link;
    
    private String image;

    public FormacionAcademicaDto() {
    }
    
    public FormacionAcademicaDto(String titulo, String descripcion, String fechaInicio, String fechaFin, String estado, String link, String image) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.link = link;
        this.image = image;
    }
    
    

      
    
}
