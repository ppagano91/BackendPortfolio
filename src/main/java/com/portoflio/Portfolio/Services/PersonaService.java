package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.Persona;
import com.portoflio.Portfolio.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository personaRepositorio;

    @Override
    public List<Persona> verPersonas() {
        return personaRepositorio.findAll();
    }

    @Override
    public void crearPersona(Persona persona) {
        personaRepositorio.save(persona);
    }
    
    @Override
    public void editarPersona(Persona persona) {
        personaRepositorio.save(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepositorio.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return personaRepositorio.findById(id).orElse(null);
    }
        
    public Persona buscarPersonaPorNombre(String nombre) {
        return personaRepositorio.findByNombre(nombre).orElse(null);
    }
    
    public boolean existsByNombre(String nombre){
        return personaRepositorio.existsByNombre(nombre);
    }
    
    public boolean existsById(Long id){
        return personaRepositorio.existsById(id);
    }   
        
}
