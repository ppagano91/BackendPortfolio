package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.FormacionAcademica;
import java.util.List;
//import java.util.Optional;

public interface IFormacionAcademicaService {
    public List<FormacionAcademica> verFormacionAcademica();
    public void crearFormacionAcademica (FormacionAcademica educacion);
    public void editarFormacionAcademica (FormacionAcademica educacion);
    public void borrarFormacionAcademica (Long id);    
    public FormacionAcademica buscarFormacionAcademica (Long id);
    public FormacionAcademica buscarFormacionAcademicaPorTitulo(String nombre);
    //public Optional<FormacionAcademica> getByTitulo(String Titulo);
    public boolean existsById(Long id);
    public boolean existsByTitulo(String titulo);
}
