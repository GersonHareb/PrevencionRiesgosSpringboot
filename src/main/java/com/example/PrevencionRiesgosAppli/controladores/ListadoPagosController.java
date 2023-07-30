package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Pago;
import com.example.PrevencionRiesgosAppli.repositorios.PagoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListadoPagosController {

    @Autowired
    private PagoRepo pagoRepo;

    @GetMapping("/listarPagos")
    public String listarPagos(Model model){
        List<Pago> pagos = pagoRepo.findAll();
        model.addAttribute("pagos", pagos);
        return "listadoPagos";
    }
}
