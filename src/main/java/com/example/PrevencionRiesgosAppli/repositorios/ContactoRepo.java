package com.example.PrevencionRiesgosAppli.repositorios;

import com.example.PrevencionRiesgosAppli.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepo extends JpaRepository<Contacto, Integer> {

}
