package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Capacitacion;
import com.example.PrevencionRiesgosAppli.modelo.Usuario;
import com.example.PrevencionRiesgosAppli.repositorios.CapacitacionRepo;
import com.example.PrevencionRiesgosAppli.servicios.ClienteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class CrearCapacitacionController {

    @Autowired
    private CapacitacionRepo capacitacionRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(CrearCapacitacionController.class);

    private final String url = "http://localhost:8080/clientes";

    @RequestMapping(path="/crearCapacitacion", method = RequestMethod.GET)
    public String MostrarCrearCapacitacion(){
        return "crearcapacitacion";
    }

    @PostMapping("/crearCapacitacion")
    public String crearCapacitacion(@RequestParam("nombre") String nombre,
                                    @RequestParam("detalle") String detalle,
                                    @RequestParam("dia") LocalDate dia,
                                    @RequestParam("hora") LocalTime hora,
                                    @RequestParam("lugar") String lugar,
                                    @RequestParam("duracion") LocalTime duracion,
                                    @RequestParam("cantidadAsistentes") Integer cantidadAsistentes)   {

        RestTemplate restTemplate = new RestTemplate();
        List<ClienteDTO> clientes = restTemplate.getForObject(url, List.class);

        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setNombre(nombre);
        capacitacion.setDetalle(detalle);
        capacitacion.setDia(dia);
        capacitacion.setHora(hora);
        capacitacion.setLugar(lugar);
        capacitacion.setDuracion(duracion);
        capacitacion.setCantidadAsistentes(cantidadAsistentes);
        capacitacionRepo.save(capacitacion);
        LOGGER.info("Lista de clientes: {}", clientes);
        return "redirect:/listarCapacitaciones";
    }


}
