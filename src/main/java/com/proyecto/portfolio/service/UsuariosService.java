package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Usuarios;
import com.proyecto.portfolio.repository.UsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements IUsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> getUsuarios() {
        return usuariosRepository.findAll();
    }
}
