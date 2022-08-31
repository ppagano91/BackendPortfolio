/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Dto.ProyectoDto;
import com.portoflio.Portfolio.Model.Proyecto;
import com.portoflio.Portfolio.Security.Controller.Mensaje;
import com.portoflio.Portfolio.Services.IProyectoService;
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
@CrossOrigin(origins="https://paganopatricioportfolio.web.app")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
    
    @GetMapping("/proyecto/ver/proyectos")
    //@ResponseBody
    public List<Proyecto> verProyectos(){
        return proyectoService.verProyectos();
    }
    
    @PostMapping("/proyecto/new")
    public String agregarProyecto(@RequestBody Proyecto proyecto){
        proyectoService.crearProyecto(proyecto);
        return "Proyecto creado exitosamente";
    }
    
    @DeleteMapping("/proyecto/delete/{id}")
    public String borrarProyecto(@PathVariable Long id){
        if(proyectoService.buscarProyecto(id)!=null){
            proyectoService.borrarProyecto(id);
            return "Proyecto eliminado exitosamente";            
        }       
        return "No existe la Proyecto con id "+id;
    }
    
    @PutMapping("/proyecto/edit")
    public String editarProyecto(@RequestBody Proyecto proyecto){
        proyectoService.editarProyecto(proyecto);
        return "El proyecto fue editado correctamente";
    }
    
    @GetMapping("/proyecto/get/{id}")
    public ResponseEntity<Proyecto> getProjectById(@PathVariable Long id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto=proyectoService.buscarProyecto(id);
        return new ResponseEntity(proyecto,HttpStatus.OK);
                
    }
    
    
    //Con ResponseEntity
    @GetMapping("/proyecto/get/proyectos")
    public ResponseEntity<List<Proyecto>> getProject(){
        List <Proyecto> proyectos = proyectoService.verProyectos();
        return new ResponseEntity(proyectos, HttpStatus.OK);    
    }
    
    //Con ResponseEntity
    @PostMapping("/proyecto/create")
    public ResponseEntity<?> addProject(@RequestBody ProyectoDto projectdto){
        if(StringUtils.isBlank(projectdto.getTitulo()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyectoService.existsByTitulo(projectdto.getTitulo()))
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        if(projectdto.getFecha()==null || projectdto.getFecha()==""){
            projectdto.setFecha(null);
        }
        Proyecto proyecto = new Proyecto(projectdto.getTitulo(), projectdto.getDescripcion(), projectdto.getFecha(), projectdto.getFoto(), projectdto.getUrl());
        proyectoService.crearProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
                
        
    }
    
    //Con ResponseEntity
    @PutMapping("/proyecto/update/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") Long id, @RequestBody ProyectoDto projectdto){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existsByTitulo(projectdto.getTitulo()) && proyectoService.buscarProyectoPorTitulo(projectdto.getTitulo()).getId()!=id){
            return new ResponseEntity(new Mensaje("Este proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(projectdto.getTitulo())){
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.buscarProyecto(id);
        proyecto.setTitulo(projectdto.getTitulo());
        proyecto.setDescripcion(projectdto.getDescripcion());
        proyecto.setFecha(projectdto.getFecha());
        proyecto.setFoto(projectdto.getFoto());
        proyecto.setUrl(projectdto.getUrl());
        
        
        
        proyectoService.editarProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    //Con ResponseEntity
    @DeleteMapping("/proyecto/remove/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        proyectoService.borrarProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
                
    }
    
}
