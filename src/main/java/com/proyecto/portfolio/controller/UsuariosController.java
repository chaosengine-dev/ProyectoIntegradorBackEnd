package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.Usuarios;
import com.proyecto.portfolio.service.IUsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {
    
    @Autowired
    private IUsuariosService interfaceUsuarios;
    
    @GetMapping("usuarios")
    public List<Usuarios> mostrarUsuarios(){
        return interfaceUsuarios.getUsuarios();
    }
    
}
