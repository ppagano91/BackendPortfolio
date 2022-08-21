package com.portoflio.Portfolio.Repository;

import com.portoflio.Portfolio.Model.FormacionAcademica;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacionAcademicaRepository extends JpaRepository<FormacionAcademica,Long>{
    public Optional<FormacionAcademica> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}
