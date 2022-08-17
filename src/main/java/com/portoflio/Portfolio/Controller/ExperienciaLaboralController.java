 package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Model.ExperienciaLaboral;
import com.portoflio.Portfolio.Services.IExperienciaLaboralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService experienciaLaboralService;
    
    @GetMapping("/experiencia/ver/trabajos")
    public List<ExperienciaLaboral> verTrabajos(){        
        return experienciaLaboralService.verExperienciaLaboral();
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
    
    @DeleteMapping("/experiencia/delete/{id}")
    public String borrarTrabajo(@PathVariable Long id){
        if(experienciaLaboralService.buscarExperienciaLaboral(id)!=null){
            experienciaLaboralService.borrarExperienciaLaboral(id);
            return "Trabajo eliminado con éxito";
        }
        return "No existe el trabajo con id "+id;
    }
    
    @PutMapping("/experiencia/edit")
    public String editarTrabajo(@RequestBody ExperienciaLaboral trabajo){
        experienciaLaboralService.editarExperienciaLaboral(trabajo);
        return "Trabajo editado con éxito";
    }
    
}
