package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService interfacePersona;
    
    @GetMapping("datospersonales")
    public Persona mostrarDatosPersonales(){
        return interfacePersona.getPersona();
    }
    
    @PostMapping("datospersonales")
    @CrossOrigin(origins="http://localhost:8080/editPersona")
    public Boolean guardarDatosPersonales(@RequestBody Persona persona){    
        Boolean guardarDatos = false;
        guardarDatos = interfacePersona.savePersona(persona);
        return guardarDatos;
    }
}
