package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Proyectos;
import java.util.List;

public interface IProyectosService {
    public List<Proyectos> getProyectos();
    public Boolean saveProyecto(Proyectos job);
    public Boolean deleteProyecto(Long id);
}
