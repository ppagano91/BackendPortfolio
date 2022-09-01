 package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Dto.ExperienciaLaboralDto;
import com.portoflio.Portfolio.Model.ExperienciaLaboral;
import com.portoflio.Portfolio.Security.Controller.Mensaje;
import com.portoflio.Portfolio.Services.IExperienciaLaboralService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("experiencia")
//@CrossOrigin(origins="https://paganopatricioportfolio.web.app")
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService experienciaLaboralService;
    
    @GetMapping("/experiencia/ver/trabajos")
    public List<ExperienciaLaboral> verTrabajos(){        
        return experienciaLaboralService.verExperienciaLaboral();
    }
    
    //Con ResponseEntity
    @GetMapping("/experiencia/ver/experiencialaboral")
    public ResponseEntity<List<ExperienciaLaboral>> getExperience(){
        List <ExperienciaLaboral> experienciasLaborales = experienciaLaboralService.verExperienciaLaboral();
        return new ResponseEntity(experienciasLaborales, HttpStatus.OK);    
    }
    
    
    
    @GetMapping("/experiencia/ver/{id}")    
    public ExperienciaLaboral verTrabajo(@PathVariable Long id){
        return experienciaLaboralService.buscarExperienciaLaboral(id);
    }
    
    
    @PostMapping("/experiencia/new")
    public String agregarTrabajo(@RequestBody ExperienciaLaboral trabajo){
        experienciaLaboralService.crearExperienciaLaboral(trabajo);
        return "Trabjo agregadp con éxito";
    }
    
    //Con ResponseEntity
    @PostMapping("/experiencia/create")
    public ResponseEntity<?> addJob(@RequestBody ExperienciaLaboralDto dtojob){
        if(StringUtils.isBlank(dtojob.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaLaboralService.existsByNombre(dtojob.getNombre()))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(dtojob.getFechaFin()==null || dtojob.getFechaFin()==""){
            dtojob.setFechaFin(null);
        }
        ExperienciaLaboral experiencia = new ExperienciaLaboral(dtojob.getNombre(), dtojob.getDescripcion(), dtojob.getFechaInicio(), dtojob.getFechaFin(), dtojob.getEsTrabajoActual(),dtojob.getTipoEmpleo(), dtojob.getEmpresa(), dtojob.getTipoJornada());
        experienciaLaboralService.crearExperienciaLaboral(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Laboral agregada"), HttpStatus.OK);
                
        
    }
    
    //Con ResponseEntity
    @PutMapping("/experiencia/update/{id}")
    public ResponseEntity<?> updateJob(@PathVariable("id") Long id, @RequestBody ExperienciaLaboralDto dtojob){
        if(!experienciaLaboralService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(experienciaLaboralService.existsByNombre(dtojob.getNombre()) && experienciaLaboralService.buscarExperienciaLaboralPorNombre(dtojob.getNombre()).getId()!=id){
            return new ResponseEntity(new Mensaje("Esta experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtojob.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        ExperienciaLaboral experiencia = experienciaLaboralService.buscarExperienciaLaboral(id);
        experiencia.setNombre(dtojob.getNombre());
        experiencia.setDescripcion(dtojob.getDescripcion());
        experiencia.setEmpresa(dtojob.getEmpresa());
        experiencia.setFechaInicio(dtojob.getFechaInicio());
        experiencia.setFechaFin(dtojob.getFechaFin());
        experiencia.setEsTrabajoActual(dtojob.getEsTrabajoActual());
        experiencia.setTipoJornada(dtojob.getTipoJornada());
        experiencia.setTipoEmpleo(dtojob.getTipoEmpleo());
        
        
        
        experienciaLaboralService.editarExperienciaLaboral(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/experiencia/delete/{id}")
    public String borrarTrabajo(@PathVariable Long id){
        if(experienciaLaboralService.buscarExperienciaLaboral(id)!=null){
            experienciaLaboralService.borrarExperienciaLaboral(id);
            return "Trabajo eliminado con éxito";
        }
        return "No existe el trabajo con id "+id;
    }
    
    
    //Con ResponseEntity
    @DeleteMapping("/experiencia/remove/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") Long id){
        if(!experienciaLaboralService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        experienciaLaboralService.borrarExperienciaLaboral(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/experiencia/edit")
    public String editarTrabajo(@RequestBody ExperienciaLaboral trabajo){
        experienciaLaboralService.editarExperienciaLaboral(trabajo);
        return "Trabajo editado con éxito";
    }
    
}
