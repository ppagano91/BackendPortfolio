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
    
    //Con ResponseEntity
    @GetMapping("/educacion/ver/formacionacademica")
    public ResponseEntity<List<FormacionAcademica>> getEducation(){
        List<FormacionAcademica> formacionesAcademicas = educacionService.verFormacionAcademica();
        return new ResponseEntity(formacionesAcademicas,HttpStatus.OK);
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
    
    //Con ResponseEntity
    @PostMapping("/experiencia/create")
    public ResponseEntity<?> addEducation(@RequestBody FormacionAcademicaDto dtoeducation){
        if(StringUtils.isBlank(dtoeducation.getTitulo()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(educacionService.existsByTitulo(dtoeducation.getTitulo()))
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        if(dtoeducation.getFechaFin()==null || dtoeducation.getFechaFin()==""){
            dtoeducation.setFechaFin(null);
        }
        
        FormacionAcademica educacion = new FormacionAcademica(dtoeducation.getTitulo(),dtoeducation.getDescripcion(),dtoeducation.getFechaInicio(),dtoeducation.getFechaFin(),dtoeducation.getEstado(),dtoeducation.getLink(),dtoeducation.getImage());
        educacionService.crearFormacionAcademica(educacion);
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);        
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
        if(educacionService.existsByTitulo(educacion.getTitulo()) && educacionService.buscarExperienciaLaboralPorTitulo(educacion.getTitulo()).getId() != id){
            return "La educación ya existe";
        }
        
        if (StringUtils.isBlank(educacion.getTitulo())){
            return "El título de la Formación Académica es obligatorio";
        }
        
        educacionService.editarFormacionAcademica(educacion);
        return "Educación editada exitosamente";
    }
}
