package com.example.PrevencionRiesgosAppli.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Cliente extends Usuario {
    @Column
    private String telefono;
    @Column
    private String afp;
    @Column
    private String sistemaSalud;
    @Column
    private String direccion;
    @Column
    private String comuna;
    @Column
    private int edad;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String email, String password, Roles tipo, LocalDate fechaNacimiento, String rut, String telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad) {
        super(id, nombre, email, password, tipo, fechaNacimiento, rut);
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(String sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
