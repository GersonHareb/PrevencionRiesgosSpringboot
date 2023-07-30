package com.example.PrevencionRiesgosAppli.modelo;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class Profesional extends Usuario {

    @Column
    private String titulo;
    @Column
    private LocalDate fechaIngreso;

    public Profesional() {
    }

    public Profesional(int id, String nombre, String email, String password, Roles tipo, LocalDate fechaNacimiento, String rut, String titulo, LocalDate fechaIngreso) {
        super(id, nombre, email, password, tipo, fechaNacimiento, rut);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}


