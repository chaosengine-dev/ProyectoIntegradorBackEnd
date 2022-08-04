package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectosRepository extends JpaRepository<Proyectos, Long> {
    
}
