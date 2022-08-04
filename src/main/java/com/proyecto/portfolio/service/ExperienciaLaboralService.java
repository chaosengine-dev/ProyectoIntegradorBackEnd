package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ExperienciaLaboral;
import com.proyecto.portfolio.repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService {
    @Autowired
    private ExperienciaLaboralRepository experienciaLaboralRepository;

    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral() {
        return experienciaLaboralRepository.findAll();
    }

    @Override
    public Boolean saveExperiencia(ExperienciaLaboral job) {
        try {
            experienciaLaboralRepository.save(job);
            return true;
        } catch (DataAccessException ex){
            System.out.println("Error escribiendo en la base de datos.");
            return false;
        }
    }

    @Override
    public Boolean deleteExperiencia(Long id) {
        try {
            experienciaLaboralRepository.deleteById(id);
            return true;
        } catch (DataAccessException ex){
            System.out.println("Error escribiendo en la base de datos.");
            return false;
        }
    }
}
