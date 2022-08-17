package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona (Persona persona);
    public void editarPersona (Persona persona);
    public void borrarPersona (Long id);    
    public Persona buscarPersona (Long id);
}
