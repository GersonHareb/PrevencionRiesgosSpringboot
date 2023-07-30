package com.example.PrevencionRiesgosAppli.repositorios;

import com.example.PrevencionRiesgosAppli.modelo.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepo extends JpaRepository<Capacitacion, Long> {



}
