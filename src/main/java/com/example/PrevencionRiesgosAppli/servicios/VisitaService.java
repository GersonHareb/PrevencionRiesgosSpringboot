package com.example.PrevencionRiesgosAppli.servicios;

import com.example.PrevencionRiesgosAppli.modelo.Usuario;
import com.example.PrevencionRiesgosAppli.modelo.Visita;
import com.example.PrevencionRiesgosAppli.repositorios.VisitaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepo visitaRepo;

    public void registrarVisita(String nombreUsuario, String rol){
        LocalDateTime fechaRegistro = LocalDateTime.now();

        Visita visita = new Visita();
        visita.setNombre(nombreUsuario);
        visita.setRol(rol);
        visita.setFechaIngreso(fechaRegistro);
        visitaRepo.save(visita);
    }
}
