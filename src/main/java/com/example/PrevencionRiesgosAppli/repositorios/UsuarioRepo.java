package com.example.PrevencionRiesgosAppli.repositorios;

import com.example.PrevencionRiesgosAppli.modelo.Roles;
import com.example.PrevencionRiesgosAppli.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepo extends JpaRepository <Usuario, Integer> {
    Usuario findByEmail(String email);
    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipoCliente")
    List<Usuario> findAllClientes(@Param("tipoCliente") Roles tipoCliente);
    Usuario findByNombre(String nombre);
}
