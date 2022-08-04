package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    

    @Override
    public Persona getPersona() {
        List<Persona> personas = personaRepository.findAll();
        return personas.get(0);
    }
    
    @Override
    public Boolean savePersona(Persona persona) {
        try {
            personaRepository.save(persona);
            return true;
        } catch (DataAccessException ex){
            System.out.println("Error escribiendo en la base de datos.");
            return false;
        }
        
       
    }
}
