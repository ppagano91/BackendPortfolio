package com.portoflio.Portfolio.Repository;

import com.portoflio.Portfolio.Model.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long>{
    public Optional<ExperienciaLaboral> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
