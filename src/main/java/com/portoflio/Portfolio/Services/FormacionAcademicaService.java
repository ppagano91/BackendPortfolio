/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    @Override
    public FormacionAcademica buscarFormacionAcademica(Long id) {
        return educacionRepositorio.findById(id).orElse(null);
    }    
    
    /*public Optional<FormacionAcademica> getByTitulo(String titulo){
        return educacionRepositorio.findByTitulo(titulo);
    }*/
    
    public FormacionAcademica buscarExperienciaLaboralPorTitulo(String nombre){
        return educacionRepositorio.findByTitulo(nombre).orElse(null);
    }
    
    public boolean existsById(Long id){
        return educacionRepositorio.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return educacionRepositorio.existsByTitulo(titulo);
    }
    
}
