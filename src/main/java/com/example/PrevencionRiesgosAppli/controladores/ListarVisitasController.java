package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Capacitacion;
import com.example.PrevencionRiesgosAppli.modelo.Visita;
import com.example.PrevencionRiesgosAppli.repositorios.VisitaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListarVisitasController {

    @Autowired
    private VisitaRepo visitaRepo;

    @GetMapping("/listarVisitas")
    public String listarVisitas(Model model){
        List<Visita> visitas = visitaRepo.findAll();
        model.addAttribute("visitas", visitas);
        return "listadovisitas";
    }
}
