package com.portoflio.Portfolio.Controller;

import com.portoflio.Portfolio.Model.Tecnologia;
import com.portoflio.Portfolio.Services.ITecnologiaService;
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
public class TecnologiaController {
    
    @Autowired
    private ITecnologiaService tecnologiaService;
    
    @GetMapping("/tecnologia/ver/tecnologias")
    @ResponseBody
    public List<Tecnologia> verTecnologias(){
        return tecnologiaService.verTecnologia();
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
    
}
