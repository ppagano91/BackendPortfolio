package com.portoflio.Portfolio.Services;

import com.portoflio.Portfolio.Model.FormacionAcademica;
import com.portoflio.Portfolio.Repository.FormacionAcademicaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class FormacionAcademicaService implements IFormacionAcademicaService {
    
    @Autowired    
    public FormacionAcademicaRepository educacionRepositorio;
    
    @Override
    public List<FormacionAcademica> verFormacionAcademica() {
        return educacionRepositorio.findAll();
    }

    @Override
    public void crearFormacionAcademica(FormacionAcademica educacion) {
        educacionRepositorio.save(educacion);
    }

    @Override
    public void editarFormacionAcademica(FormacionAcademica educacion) {
        educacionRepositorio.save(educacion);
    }

    @Override
    public void borrarFormacionAcademica(Long id) {
        educacionRepositorio.deleteById(id);
    }
    
    public FormacionAcademica buscarFormacionAcademica(Long id) {
        return educacionRepositorio.findById(id).orElse(null);
    }   
    
    
    @Override
    public FormacionAcademica buscarFormacionAcademicaPorTitulo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public boolean existsById(Long id){
        return educacionRepositorio.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return educacionRepositorio.existsByTitulo(titulo);
    }

    // Otra opción en lugar de buscarFormacionAcademicaPorTitulo
    /*public Optional<FormacionAcademica> getByTitulo(String titulo){
        return educacionRepositorio.findByTitulo(titulo);
    }*/
    
}
