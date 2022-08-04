package com.proyecto.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nombre;
    private String tipo;
    private String detalle;
    private String logo;
    private String url;
}
