package com.example.PrevencionRiesgosAppli.servicios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {
    private int id;
    @JsonProperty("nombreCliente")
    private String nombre;
    @JsonProperty("emailCliente")
    private String email;
    @JsonProperty("fechaNacimiento")
    private LocalDate fechaNacimiento;
    @JsonProperty("rut")
    private String rut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
