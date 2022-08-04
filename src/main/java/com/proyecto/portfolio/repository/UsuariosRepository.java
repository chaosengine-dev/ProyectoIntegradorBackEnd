package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    
}
