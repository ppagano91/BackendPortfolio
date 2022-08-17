/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portoflio.Portfolio.Repository;

import com.portoflio.Portfolio.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Patricio
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
