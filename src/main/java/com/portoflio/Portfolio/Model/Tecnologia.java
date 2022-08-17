package com.portoflio.Portfolio.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Tecnologia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Nombre;
    private String Descripcion;
    private String Url;
    private String Foto;
    private int Nivel;
    private String Tipo;
    
    

    public Tecnologia() {
    }    
    
    public Tecnologia(String Nombre, String Descripcion, String Url, String Foto, Integer Nivel, String Tipo) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Url = Url;
        this.Foto = Foto;
        this.Nivel=Nivel;
        this.Tipo=Tipo;
    }
    
    
}
