/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.Proyecto;
import com.portoflio.Portfolio.Repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    public ProyectoRepository proyectoRepositorio;
    
    @Override
    public List<Proyecto> verProyectos() {
        return proyectoRepositorio.findAll();
    }

    @Override
    public void crearProyecto(Proyecto proyecto) {
        proyectoRepositorio.save(proyecto);
    }

    @Override
    public void editarProyecto(Proyecto proyecto) {
        proyectoRepositorio.save(proyecto);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectoRepositorio.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyectoRepositorio.findById(id).orElse(null);
    }
    
}
