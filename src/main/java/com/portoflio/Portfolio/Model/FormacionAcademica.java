package com.portoflio.Portfolio.Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
        
@Getter @Setter
@Entity
public class FormacionAcademica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    
    @Size(min=1, max=750,  message="Máximo 750 caracteres")
    private String descripcion;
    private String institucion;
    private String fechaInicio;
    private String fechaFin;
    private String estado;    
    private String link;
    private String image;

    public FormacionAcademica() {
    }

        
    public FormacionAcademica(String titulo, String descripcion, String institucion, String fechaInicio, String fechaFin, String estado, String link, String image) {
        //this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.link = link;
        this.image = image;
    }
    
    
}
