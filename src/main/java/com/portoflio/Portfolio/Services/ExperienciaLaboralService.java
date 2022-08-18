package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.ExperienciaLaboral;
import com.portoflio.Portfolio.Repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService {

    @Autowired    
    public ExperienciaLaboralRepository trabajoRepositorio;
    
    @Override
    public List<ExperienciaLaboral> verExperienciaLaboral() {
        return trabajoRepositorio.findAll();
    }

    @Override
    public void crearExperienciaLaboral(ExperienciaLaboral trabajo) {
        trabajoRepositorio.save(trabajo);
    }

    @Override
    public void editarExperienciaLaboral(ExperienciaLaboral trabajo) {
        trabajoRepositorio.save(trabajo);
    }

    @Override
    public void borrarExperienciaLaboral(Long id) {
        trabajoRepositorio.deleteById(id);
    }

    @Override
    public ExperienciaLaboral buscarExperienciaLaboral(Long id) {
        return trabajoRepositorio.findById(id).orElse(null);
    }    
    
    public ExperienciaLaboral buscarExperienciaLaboralPorNombre(String nombre){
        return trabajoRepositorio.findByNombre(nombre).orElse(null);
    }
    
    public boolean existsById(Long id){
        return trabajoRepositorio.existsById(id);
    }
    
    public boolean existsByNombre(String Nombre){
        return trabajoRepositorio.existsByNombre(Nombre);
    }
    
}
