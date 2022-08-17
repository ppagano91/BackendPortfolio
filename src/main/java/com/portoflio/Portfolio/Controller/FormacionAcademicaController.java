package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Model.FormacionAcademica;
import com.portoflio.Portfolio.Services.IFormacionAcademicaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FormacionAcademicaController {
    
    @Autowired
    private IFormacionAcademicaService educacionService;
    
    
    @PostMapping("/educacion/new")
    public String agregarEducacion(@RequestBody FormacionAcademica educacion){
        educacionService.crearFormacionAcademica(educacion);
        return "Eduación agregada existosamente";
    }
    
    @GetMapping("/educacion/ver/educaciones")
    @ResponseBody
    public List<FormacionAcademica> verEeducaciones(){
        List<FormacionAcademica> formacionesAcademicas=educacionService.verFormacionAcademica();
        return formacionesAcademicas;
    }
    
    @DeleteMapping("/educacion/delete/{id}")
    public String borrarEducacion(@PathVariable Long id){
        if (educacionService.buscarFormacionAcademica(id)!=null){
            educacionService.borrarFormacionAcademica(id);
            return "Eduación eliminada exitosamente";
        }
        return "No existe la Formación Academica con id "+id;
    }
    
    @PutMapping("/educacion/edit")
    public String editarEducacion(@RequestBody FormacionAcademica educacion){
        educacionService.editarFormacionAcademica(educacion);
        return "Educación editada exitosamente";
    }
    
    
    @PutMapping("/educacion/edit/{id}")
    public String editarEducacion2(@PathVariable Long id, @RequestBody FormacionAcademica educacion){
        if(!educacionService.existsById(id))
            //return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
            return "El id no existe";
        if(educacionService.existsByTitulo(educacion.getTitulo()) && educacionService.getByTitulo(educacion.getTitulo()).get().getId() != id){
            return "La educación ya existe";
        }
        
        if (StringUtils.isBlank(educacion.getTitulo())){
            return "El título de la Formación Académica es obligatorio";
        }
        
        educacionService.editarFormacionAcademica(educacion);
        return "Educación editada exitosamente";
    }
}
