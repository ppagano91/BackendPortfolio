package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Dto.TecnologiaDto;
import com.portoflio.Portfolio.Model.Tecnologia;
import com.portoflio.Portfolio.Security.Controller.Mensaje;
import com.portoflio.Portfolio.Services.ITecnologiaService;
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
public class TecnologiaController {
    
    @Autowired
    private ITecnologiaService tecnologiaService;
    
    @GetMapping("/tecnologia/ver/tecnologias")
    @ResponseBody
    public List<Tecnologia> verTecnologias(){
        return tecnologiaService.verTecnologia();
    }
    
    //Con ResponseEntity
    @GetMapping("/tecnologia/get/{id}")
    public ResponseEntity<Tecnologia> getSkillById(@PathVariable Long id){
        if(!tecnologiaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        Tecnologia tecnologia=tecnologiaService.buscarTecnologia(id);
        return new ResponseEntity(tecnologia,HttpStatus.OK);
    }
    
    @PostMapping("/tecnologia/new")
    public String agregarTecnologia(@RequestBody Tecnologia tecnologia){
        tecnologiaService.crearTecnologia(tecnologia);
        return "Tecnología agregada exitosamente";
    }
    
    @DeleteMapping("/tecnologia/delete/{id}")
    public String borrarTecnologia(@PathVariable Long id){
        if(tecnologiaService.buscarTecnologia(id)!=null){
            tecnologiaService.borrarTecnologia(id);
            return "Tecnología borrada exitosamente";
        }
        return "No existe tecnología con el id buscado";
    }
    
    @PutMapping("/tecnologia/editar")
    public String editarTecnologia(@RequestBody Tecnologia tecnologia){        
        tecnologiaService.editarTecnologia(tecnologia);
        
        return "Tecnología editada exitosamente";
    }
    
    
    
    
    //Con ResponseEntity
    @GetMapping("/tecnologia/get/tecnologias")
    public ResponseEntity<List<Tecnologia>> getSkill(){
        List <Tecnologia> tecnologias = tecnologiaService.verTecnologia();
        return new ResponseEntity(tecnologias, HttpStatus.OK);    
    }
    
    //Con ResponseEntity
    @PostMapping("/tecnologia/create")
    public ResponseEntity<?> addSkill(@RequestBody TecnologiaDto skilldto){
        if(StringUtils.isBlank(skilldto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(tecnologiaService.existsByNombre(skilldto.getNombre()))
            return new ResponseEntity(new Mensaje("Esa tecnología ya existe"), HttpStatus.BAD_REQUEST);
        
        /*if(skilldto.getFecha()==null || skilldto.getFecha()==""){
            skilldto.setFecha(null);
        }*/
        Tecnologia tecnologia = new Tecnologia(skilldto.getNombre(), skilldto.getDescripcion(), skilldto.getUrl(), skilldto.getFoto(), skilldto.getNivel(),skilldto.getTipo());
        tecnologiaService.crearTecnologia(tecnologia);
        return new ResponseEntity(new Mensaje("Tecnología agregada"), HttpStatus.OK);
                
        
    }
    
    //Con ResponseEntity
    @PutMapping("/tecnologia/update/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable("id") Long id, @RequestBody TecnologiaDto skilldto){
        if(!tecnologiaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(tecnologiaService.existsByNombre(skilldto.getNombre()) && tecnologiaService.buscarTecnologiaPorNombre(skilldto.getNombre()).getId()!=id){
            return new ResponseEntity(new Mensaje("Esta tecnología ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(skilldto.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Tecnologia tecnologia = tecnologiaService.buscarTecnologia(id);
        tecnologia.setNombre(skilldto.getNombre());
        tecnologia.setDescripcion(skilldto.getDescripcion());
        tecnologia.setUrl(skilldto.getUrl());
        tecnologia.setFoto(skilldto.getFoto());
        tecnologia.setNivel(skilldto.getNivel());
        tecnologia.setTipo(skilldto.getTipo());
        
        
        
        tecnologiaService.editarTecnologia(tecnologia);
        return new ResponseEntity(new Mensaje("Tecnología actualizada"), HttpStatus.OK);
    }
    
    //Con ResponseEntity
    @DeleteMapping("/tecnologia/remove/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id){
        if(!tecnologiaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        tecnologiaService.borrarTecnologia(id);
        return new ResponseEntity(new Mensaje("Tecnología eliminada"), HttpStatus.OK);
                
    }
    
}
