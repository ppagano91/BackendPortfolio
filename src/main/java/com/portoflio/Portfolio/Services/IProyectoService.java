package com.portoflio.Portfolio.Services;


import com.portoflio.Portfolio.Model.Proyecto;
import java.util.List;

public interface IProyectoService {    
    public List<Proyecto> verProyectos();
    public void crearProyecto (Proyecto proyecto);
    public void editarProyecto (Proyecto proyecto);
    public void borrarProyecto (Long id);    
    public Proyecto buscarProyecto (Long id);
    public Proyecto buscarProyectoPorTitulo (String titulo);
    public boolean existsById(Long id);
    public boolean existsByTitulo(String titulo);
    
}
