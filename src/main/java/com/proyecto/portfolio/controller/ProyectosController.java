package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.Proyectos;
import com.proyecto.portfolio.service.IProyectosService;
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
public class ProyectosController {
    
    @Autowired
    private IProyectosService interfaceProyectos;
    
    @GetMapping("proyecto")
    public List<Proyectos> mostrarProyectos(){
        return interfaceProyectos.getProyectos();
    }
    
    @PostMapping("proyecto")
    @CrossOrigin(origins="http://localhost:8080/addProyecto")
    public Boolean modificaProyecto(@RequestBody Proyectos job){
        Boolean guardarDatos = false;
        guardarDatos = interfaceProyectos.saveProyecto(job);
        return guardarDatos;        
    }
    
    @DeleteMapping("proyecto")
    @CrossOrigin(origins="http://localhost:8080/deleteProyecto")
    public Boolean eliminaProyecto(@RequestParam("id") Long id){
        Boolean guardarDatos = false;
        System.out.println("borrando " + id);
        guardarDatos = interfaceProyectos.deleteProyecto(id);
        return guardarDatos;        
    }
}

