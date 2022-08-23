/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portoflio.Portfolio.Repository;

import com.portoflio.Portfolio.Model.Tecnologia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Patricio
 */
public interface TecnologiaRepository extends JpaRepository<Tecnologia,Long>{
    public Optional<Tecnologia> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
