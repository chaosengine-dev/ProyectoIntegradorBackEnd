package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Educacion;
import com.proyecto.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public List<Educacion> getEducacion() {
        return educacionRepository.findAll();
    }
    
    @Override
    public Boolean saveEducacion(Educacion edu) {
        try {
            educacionRepository.save(edu);
            return true;
        } catch (DataAccessException ex){
            System.out.println("Error escribiendo en la base de datos tabla Educacion.");
            return false;
        }
    }
    
    @Override
    public Boolean deleteEducacion(Long id) {
        try {
            educacionRepository.deleteById(id);
            return true;
        } catch (DataAccessException ex){
            System.out.println("Error escribiendo en la base de datos.");
            return false;
        }
    }
}
