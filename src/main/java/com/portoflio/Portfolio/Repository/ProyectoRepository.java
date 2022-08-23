package com.portoflio.Portfolio.Repository;

import com.portoflio.Portfolio.Model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    public Optional<Proyecto> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
