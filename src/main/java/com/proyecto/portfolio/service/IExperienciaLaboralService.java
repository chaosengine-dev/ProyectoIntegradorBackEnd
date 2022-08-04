package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> getExperienciaLaboral();
    public Boolean saveExperiencia(ExperienciaLaboral job);
    public Boolean deleteExperiencia(Long id);
}
