package com.portoflio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDto {    
    
    @NotBlank
    private String nombre;
    private String apellido;
    private String residencia;
    
    @NotBlank
    private String email;
    private String fechaNacimiento;
    private String telefono;
    
    //Redes
    private String linkedin;
    private String github;
    private String instagram;    
    
    
    @NotBlank
    private String sobreMi;
    
    @NotBlank
    private String foto;
    
    private String urlCV;

    public PersonaDto() {
    }     

    public PersonaDto(String Nombre, String Apellido, String Residencia, String Email, String FechaNacimiento, String Telefono, String SobreMi, String Foto, String urlCV) {        
        this.nombre = Nombre;
        this.apellido = Apellido;
        this.residencia = Residencia;
        this.email = Email;
        this.fechaNacimiento = FechaNacimiento;
        this.telefono = Telefono;
        this.sobreMi = SobreMi;
        this.foto = Foto;
        this.urlCV=urlCV;
    }
    
}
