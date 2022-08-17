
package com.portoflio.Portfolio.Controller;

//import com.portfolio.Portfolio.Model.FormacionAcademica;
import com.portoflio.Portfolio.Model.Persona;
import com.portoflio.Portfolio.Services.IPersonaService;
import java.util.Date;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    //List <FormacionAcademica> listaFormacionAcademica= new ArrayList();   
    
    
    
    @PostMapping("/usuario/new")
    public String agregarUsuario(@RequestBody Persona user){
        personaService.crearPersona(user);
        return "La persona fue creada correctamente";
    }
    
    @GetMapping("/persona/ver/perfil")    
    public Persona verUsuario(){
        return personaService.buscarPersona((long)1);
    }
    
    @GetMapping("/usuario/ver/usuarios")
    @ResponseBody
    public List<Persona> verUsuarios(){
        return personaService.verPersonas();
    }
    
    @DeleteMapping("/usuario/delete/{id}")
    public String borrarUsuario(@PathVariable Long id){
        if (personaService.buscarPersona(id) != null){
           personaService.borrarPersona(id);
           return "La persona fue eliminada correctamente";
        }        
        return "No existen personas con el Id "+id;        
    }
    
    @PutMapping("/usuario/edit")
    public void editarPersona(@RequestBody Persona persona){
        personaService.editarPersona(persona);
    }
    
    
    //Tener en cuenta esta posibilidad de Edit
    @PutMapping("/usuario/edit/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("apellido") String nuevoApellido,
                                 @RequestParam("residencia") String nuevoResidencia,
                                 @RequestParam("email") String nuevoEmail,
                                 @RequestParam("fechaNacimiento") Date nuevaFechaNacimiento,
                                 @RequestParam("telefono") String nuevoTelefono,
                                 @RequestParam("sobreMi") String nuevoSobreMi,
                                 @RequestParam("foto") String nuevaFoto
                                 ){
        Persona persona = personaService.buscarPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setResidencia(nuevoResidencia);
        persona.setEmail(nuevoEmail);
        persona.setFechaNacimiento(nuevaFechaNacimiento);
        persona.setTelefono(nuevoTelefono);
        persona.setSobreMi(nuevoSobreMi);
        persona.setFoto(nuevaFoto);
        personaService.editarPersona(persona);
        return persona;
    }
    
}
