package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Dto.FormacionAcademicaDto;
import com.portoflio.Portfolio.Model.FormacionAcademica;
import com.portoflio.Portfolio.Security.Controller.Mensaje;
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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("trabajo")
@CrossOrigin(origins="http://localhost:4200")
public class FormacionAcademicaController {
    
    @Autowired
    private IFormacionAcademicaService educacionService;    
    
    @GetMapping("/educacion/ver/educaciones")
    @ResponseBody
    public List<FormacionAcademica> verEeducaciones(){
        List<FormacionAcademica> formacionesAcademicas=educacionService.verFormacionAcademica();
        return formacionesAcademicas;
    }
    
    
    @GetMapping("/educacion/ver/{id}")
    public FormacionAcademica verEducacion(@PathVariable Long id){
        return educacionService.buscarFormacionAcademica(id);
    }
    
    
    @PostMapping("/educacion/new")
    public String agregarEducacion(@RequestBody FormacionAcademica educacion){
        educacionService.crearFormacionAcademica(educacion);
        return "Eduación agregada existosamente";
    }
    
    @PutMapping("/educacion/edit")
    public String editarEducacion(@RequestBody FormacionAcademica educacion){
        educacionService.editarFormacionAcademica(educacion);
        return "Educación editada exitosamente";
    }
    
    @DeleteMapping("/educacion/delete/{id}")
    public String borrarEducacion(@PathVariable Long id){
        if (educacionService.buscarFormacionAcademica(id)!=null){
            educacionService.borrarFormacionAcademica(id);
            return "Eduación eliminada exitosamente";
        }
        return "No existe la Formación Academica con id "+id;
    }
    
    
    //Con ResponseEntity
    @GetMapping("/educacion/get/formacionacademica")
    public ResponseEntity<List<FormacionAcademica>> getEducation(){
        List<FormacionAcademica> formacionesAcademicas = educacionService.verFormacionAcademica();
        return new ResponseEntity(formacionesAcademicas,HttpStatus.OK);
    }
    
    //Con ResponseEntity
    @GetMapping("/educacion/get/{id}")
    public ResponseEntity<FormacionAcademica> getEducationById(@PathVariable Long id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        FormacionAcademica educacion=educacionService.buscarFormacionAcademica(id);
        return new ResponseEntity(educacion,HttpStatus.OK);
                
    }
    
    //Con ResponseEntity
    @PostMapping("/educacion/create")
    public ResponseEntity<?> addEducation(@RequestBody FormacionAcademicaDto dtoeducation){
        if(StringUtils.isBlank(dtoeducation.getTitulo()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(educacionService.existsByTitulo(dtoeducation.getTitulo()))
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        if(dtoeducation.getFechaFin()==null || dtoeducation.getFechaFin()==""){
            dtoeducation.setFechaFin(null);
        }
        
        FormacionAcademica educacion = new FormacionAcademica(dtoeducation.getTitulo(),dtoeducation.getDescripcion(),dtoeducation.getInstitucion(),dtoeducation.getFechaInicio(),dtoeducation.getFechaFin(),dtoeducation.getEstado(),dtoeducation.getLink(),dtoeducation.getImage());
        educacionService.crearFormacionAcademica(educacion);
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);        
    }
    
    //Con ResponseEntity
    @PutMapping("/educacion/update/{id}")
    public ResponseEntity<?> updateEducation(@PathVariable("id") Long id, @RequestBody FormacionAcademicaDto dtoeducation){
         if (!educacionService.existsById(id)){
             return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
         }
         if(educacionService.existsByTitulo(dtoeducation.getTitulo()) && educacionService.buscarFormacionAcademicaPorTitulo(dtoeducation.getTitulo()).getId()!=id){
             return new ResponseEntity(new Mensaje("Esta educación ya existe"), HttpStatus.BAD_REQUEST);
         }
         
         if(StringUtils.isBlank(dtoeducation.getTitulo())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        FormacionAcademica educacion = educacionService.buscarFormacionAcademica(id);
        educacion.setTitulo(dtoeducation.getTitulo());
        educacion.setDescripcion(dtoeducation.getDescripcion());
        educacion.setInstitucion(dtoeducation.getInstitucion());
        educacion.setFechaInicio(dtoeducation.getFechaInicio());
        educacion.setFechaFin(dtoeducation.getFechaFin());
        educacion.setEstado(dtoeducation.getEstado());
        educacion.setLink(dtoeducation.getLink());
        educacion.setImage(dtoeducation.getImage());
        
        educacionService.editarFormacionAcademica(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada"),HttpStatus.OK);        
    }
    
    //Con ResponseEntity
    @DeleteMapping("/educacion/remove/{id}")
    public ResponseEntity<?> deleteEducation (@PathVariable("id") Long id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        educacionService.borrarFormacionAcademica(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
}
