package com.example.PrevencionRiesgosAppli.modelo;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private Roles tipo;
    @Column
    private LocalDate fechaNacimiento;
    @Column
    private String rut;


    public Usuario() {
    }

     public Usuario(int id, String nombre, String email, String password, Roles tipo, LocalDate fechaNacimiento, String rut) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
    }

    public String mostrarEdad() {
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
        return "El usuario tiene " + edad + " años";
    }

    public String analizarUsuario() {
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", RUN: " + rut;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "\nNombre: " + nombre  +
                "\nEdad: " + mostrarEdad() +
                "\nRut: " + rut +
                "\n ";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public Roles getTipo() {
        return tipo;
    }

    public void setTipo(Roles tipo) {
        this.tipo = tipo;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRut(String rut) {
            this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Metodos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(tipo.name()));
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

