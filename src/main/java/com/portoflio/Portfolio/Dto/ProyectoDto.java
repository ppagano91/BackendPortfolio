package com.portoflio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDto {
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    private String fecha;
    
    private String foto;
    
    private String url;

    public ProyectoDto() {
    }

    public ProyectoDto(String titulo, String descripcion, String fecha, String foto, String url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.foto = foto;
        this.url = url;
    }
    
    
}
