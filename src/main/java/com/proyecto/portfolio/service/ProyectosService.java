package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Proyectos;
import com.proyecto.portfolio.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService {
    @Autowired
    private ProyectosRepository proyectosRepository;

    @Override
    public List<Proyectos> getProyectos() {
        return proyectosRepository.findAll();
    }

    @Override
    public Boolean saveProyecto(Proyectos job) {
        try {
            proyectosRepository.save(job);
            return true;
        } catch (DataAccessException ex){
            System.out.println("Error escribiendo en la base de datos.");
            return false;
        }
    }

    @Override
    public Boolean deleteProyecto(Long id) {
        try {
            proyectosRepository.deleteById(id);
            return true;
        } catch (DataAccessException ex){
            System.out.println("Error escribiendo en la base de datos.");
            return false;
        }
    }
}
