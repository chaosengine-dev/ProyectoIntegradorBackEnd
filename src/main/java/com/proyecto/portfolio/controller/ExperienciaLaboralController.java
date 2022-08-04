package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.ExperienciaLaboral;
import com.proyecto.portfolio.service.IExperienciaLaboralService;
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
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService interfaceExperienciaLaboral;
    
    @GetMapping("experiencialaboral")
    public List<ExperienciaLaboral> mostrarExperienciaLaboral(){
        return interfaceExperienciaLaboral.getExperienciaLaboral();
    }
    
    @PostMapping("experiencialaboral")
    public Boolean modificarExperiencia(@RequestBody ExperienciaLaboral job){
        Boolean guardarDatos = false;
        guardarDatos = interfaceExperienciaLaboral.saveExperiencia(job);
        return guardarDatos;        
    }
    
    @DeleteMapping("experiencialaboral")
    @CrossOrigin(origins="http://localhost:8080/editPersona")
    public Boolean eliminaExperiencia(@RequestParam("id") Long id){
        Boolean guardarDatos = false;
        System.out.println("borrando " + id);
        guardarDatos = interfaceExperienciaLaboral.deleteExperiencia(id);
        return guardarDatos;        
    }
}
