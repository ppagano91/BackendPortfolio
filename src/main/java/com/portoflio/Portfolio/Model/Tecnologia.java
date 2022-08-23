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
    private String nombre;
    private String descripcion;
    private String url;
    private String foto;
    private int nivel;
    private String tipo;
    
    

    public Tecnologia() {
    }    
    
    public Tecnologia(String Nombre, String Descripcion, String Url, String Foto, int Nivel, String Tipo) {
        this.nombre = Nombre;
        this.descripcion = Descripcion;
        this.url = Url;
        this.foto = Foto;
        this.nivel = Nivel;
        this.tipo = Tipo;
    }
    
    
}
