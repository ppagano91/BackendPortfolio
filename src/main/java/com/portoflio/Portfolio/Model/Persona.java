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
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String residencia;
    private String email;
    private Date fechaNacimiento;
    private String telefono;
    
    //Redes
    private String linkedin;
    private String github;
    private String instagram;
    
    @Size(max = 750)
    private String sobreMi;
    private String foto;

    public Persona() {
    }     

    public Persona(Long id, String Nombre, String Apellido, String Residencia, String Email, Date FechaNacimiento, String Telefono, String SobreMi, String Foto) {
        this.id = id;
        this.nombre = Nombre;
        this.apellido = Apellido;
        this.residencia = Residencia;
        this.email = Email;
        this.fechaNacimiento = FechaNacimiento;
        this.telefono = Telefono;
        this.sobreMi = SobreMi;
        this.foto = Foto;
    }

    
    
    
    
}
