package com.example.PrevencionRiesgosAppli.repositorios;

import com.example.PrevencionRiesgosAppli.modelo.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepo extends JpaRepository <Administrativo, Integer> {
}
