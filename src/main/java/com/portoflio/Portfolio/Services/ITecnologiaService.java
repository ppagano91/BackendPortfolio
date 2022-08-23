package com.portoflio.Portfolio.Services;

import java.util.List;
import com.portoflio.Portfolio.Model.Tecnologia;
        
public interface ITecnologiaService {
    
    public List<Tecnologia> verTecnologia();
    public void crearTecnologia (Tecnologia tecnologia);
    public void editarTecnologia (Tecnologia tecnologia);
    public void borrarTecnologia (Long id);    
    public Tecnologia buscarTecnologia (Long id);
    public Tecnologia buscarTecnologiaPorNombre (String nombre);
    public boolean existsById(Long id);
    public boolean existsByNombre(String nombre);
    
}
