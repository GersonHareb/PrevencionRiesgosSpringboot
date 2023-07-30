package com.example.PrevencionRiesgosAppli.modelo;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class Administrativo extends Usuario{

    @Column
    private String area_exp;
    @Column
    private String experienciaPrevia;

    public Administrativo() {
    }

    public Administrativo(int id, String nombre, String email, String password, Roles tipo, LocalDate fechaNacimiento, String rut, String area_exp, String experienciaPrevia) {
        super(id, nombre, email, password, tipo, fechaNacimiento, rut);
        this.area_exp = area_exp;
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getArea_exp() {
        return area_exp;
    }

    public void setArea_exp(String area_exp) {
        this.area_exp = area_exp;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }
}


