/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portoflio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TecnologiaDto {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String descripcion;
    
    private String url;    
    private String foto;
    private int nivel;
    private String tipo;

    public TecnologiaDto() {
    }

    public TecnologiaDto(String nombre, String descripcion, String url, String foto, int nivel, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.foto = foto;
        this.nivel = nivel;
        this.tipo = tipo;
    }
    
    
}
