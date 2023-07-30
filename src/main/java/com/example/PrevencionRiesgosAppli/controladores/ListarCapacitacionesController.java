package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.*;
import com.example.PrevencionRiesgosAppli.repositorios.CapacitacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class ListarCapacitacionesController {

    @Autowired
    private CapacitacionRepo caprep;

    @GetMapping("/listarCapacitaciones")
    public String listarCapacitaciones(Model model){
        List<Capacitacion> capacitaciones = caprep.findAll();
        model.addAttribute("capacitaciones", capacitaciones);
        return "listarcapacitacion";
    }


    // Método para procesar la actualización de la capacitación
    @GetMapping("/editarCapacitacion/{id}")
    public String editarCapacitacionForm(@PathVariable("id") Long id, Model model) {
        Optional<Capacitacion> capacitacionOpcional = caprep.findById(id);

        if(capacitacionOpcional.isPresent()){
            Capacitacion capacitacion = capacitacionOpcional.get();
            model.addAttribute("capacitacion", capacitacion);

            return "editarcapacitacion"; // Nombre de la plantilla Thymeleaf para el formulario de edición
        }

        return "redirect:/listarCapacitaciones";


    }

    // Método para procesar la actualización de la capacitación
    @PostMapping("/editarCapacitacion")
    public String editarCapacitacion(@ModelAttribute Capacitacion capacitacionActualizada) {
        Optional<Capacitacion> capacitacionExistenteOpcional = caprep.findById(capacitacionActualizada.getId());

        if (capacitacionExistenteOpcional.isPresent()) {
            Capacitacion capacitacionExistente = capacitacionExistenteOpcional.get();
            // Actualiza los atributos de la capacitación existente con los nuevos valores
            capacitacionExistente.setNombre(capacitacionActualizada.getNombre());
            capacitacionExistente.setDetalle(capacitacionActualizada.getDetalle());
            capacitacionExistente.setDetalle(capacitacionActualizada.getDetalle());
            capacitacionExistente.setDia(capacitacionActualizada.getDia());
            capacitacionExistente.setHora(capacitacionActualizada.getHora());
            capacitacionExistente.setLugar(capacitacionActualizada.getLugar());
            capacitacionExistente.setDuracion(capacitacionActualizada.getDuracion());
            capacitacionExistente.setCantidadAsistentes(capacitacionActualizada.getCantidadAsistentes());
            // ... Actualiza otros atributos según corresponda ...

            // Guarda los cambios en la base de datos
            caprep.save(capacitacionExistente);
        }

        return "redirect:/listarCapacitaciones";
    }







    @GetMapping("/borrarCapacitacion")
    public String borrarCapacitacion(@RequestParam("id") Long id) {
        Optional<Capacitacion> capacitacionOpcional = caprep.findById(id);

        if (capacitacionOpcional.isPresent()) {
            caprep.deleteById(id);
        }

        return "redirect:/listarCapacitaciones";
    }
}
