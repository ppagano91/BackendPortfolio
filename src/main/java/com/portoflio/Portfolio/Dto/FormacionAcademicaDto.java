package com.portoflio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FormacionAcademicaDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;

    public FormacionAcademicaDto() {
    }

    public FormacionAcademicaDto(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    
    
}
