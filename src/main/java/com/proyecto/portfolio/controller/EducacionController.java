package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.Educacion;
import com.proyecto.portfolio.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired
    private IEducacionService interfaceEducacion;
    
    @GetMapping("educacion")
    @CrossOrigin(origins="http://localhost:8080")
    public List<Educacion> mostrarDatosEducacion(){
        return interfaceEducacion.getEducacion();
    }   
    
    @PostMapping("educacion")
    public Boolean modificarEducacion(@RequestBody Educacion edu){
        Boolean guardarDatos = false;
        guardarDatos = interfaceEducacion.saveEducacion(edu);
        return guardarDatos;        
    }
    
    @DeleteMapping("educacion")
    @CrossOrigin(origins="http://localhost:8080/deleteEducacion")
    public Boolean eliminaEducacion(@RequestParam("id") Long id){
        Boolean guardarDatos = false;
        System.out.println("borrando " + id);
        guardarDatos = interfaceEducacion.deleteEducacion(id);
        return guardarDatos;        
    }
}
