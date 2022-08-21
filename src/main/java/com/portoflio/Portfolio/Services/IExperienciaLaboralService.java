package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> verExperienciaLaboral();
    public void crearExperienciaLaboral (ExperienciaLaboral trabajo);
    public void editarExperienciaLaboral (ExperienciaLaboral trabajo);
    public void borrarExperienciaLaboral (Long id);    
    public ExperienciaLaboral buscarExperienciaLaboral (Long id);
    public ExperienciaLaboral buscarExperienciaLaboralPorNombre(String nombre);
    public boolean existsById(Long id);
    public boolean existsByNombre(String Nombre);
    
    
    
}
