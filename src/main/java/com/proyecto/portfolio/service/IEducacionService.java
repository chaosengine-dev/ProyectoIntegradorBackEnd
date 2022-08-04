package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> getEducacion();
    public Boolean saveEducacion(Educacion edu);
    public Boolean deleteEducacion(Long id);
}
