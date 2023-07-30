package com.example.PrevencionRiesgosAppli.repositorios;

import com.example.PrevencionRiesgosAppli.modelo.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepo extends JpaRepository <Profesional, Integer> {
}
