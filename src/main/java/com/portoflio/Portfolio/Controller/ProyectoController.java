/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Model.Proyecto;
import com.portoflio.Portfolio.Services.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
    
    @GetMapping("/proyecto/ver/proyectos")
    @ResponseBody
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
    
}
