package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.Tecnologia;
import com.portoflio.Portfolio.Repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService{
    
    @Autowired
    public TecnologiaRepository tecnologiaRepositorio;

    @Override
    public List<Tecnologia> verTecnologia() {        
        return tecnologiaRepositorio.findAll();
    }

    @Override
    public void crearTecnologia(Tecnologia tecnologia) {
        tecnologiaRepositorio.save(tecnologia);
    }

    @Override
    public void editarTecnologia(Tecnologia tecnologia) {
        tecnologiaRepositorio.save(tecnologia);
    }

    @Override
    public void borrarTecnologia(Long id) {
        tecnologiaRepositorio.deleteById(id);
    }

    @Override
    public Tecnologia buscarTecnologia(Long id) {
        return tecnologiaRepositorio.findById(id).orElse(null);
    }
    
}
