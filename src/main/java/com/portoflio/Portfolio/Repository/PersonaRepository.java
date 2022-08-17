package com.portoflio.Portfolio.Repository;

import com.portoflio.Portfolio.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
    
    
    
}
