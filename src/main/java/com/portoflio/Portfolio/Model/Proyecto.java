package com.portoflio.Portfolio.Model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min=1, max=50,  message="Entre 1 y 50 caracteres")
    private String titulo;
    
    @NotNull
    @Size(min=1, max=750,  message="Máximo 200 caracteres")
    private String descripcion;
    private String url;
    
    //@DefaultValue()
    private Date fecha;
    private String foto;

    public Proyecto() {
    }

    public Proyecto(String titulo, String descripcion, String url, Date fecha, String foto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.fecha = fecha;
        this.foto = foto;
    }
    
    
}
