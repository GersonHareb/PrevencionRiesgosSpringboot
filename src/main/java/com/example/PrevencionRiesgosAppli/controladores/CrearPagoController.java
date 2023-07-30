package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Cliente;
import com.example.PrevencionRiesgosAppli.modelo.Pago;
import com.example.PrevencionRiesgosAppli.modelo.Roles;
import com.example.PrevencionRiesgosAppli.modelo.Usuario;
import com.example.PrevencionRiesgosAppli.repositorios.PagoRepo;
import com.example.PrevencionRiesgosAppli.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class CrearPagoController {
    @Autowired
    UsuarioRepo usuarioRepo;

    @Autowired
    private PagoRepo pagoRepo;

    @GetMapping("/crearPago")
    public String mostrarFormulario(Model model) {
        List<Usuario> clientes = usuarioRepo.findAllClientes(Roles.Cliente);
        model.addAttribute("clientes", clientes);
        model.addAttribute("nuevoPago", new Pago()); // Si necesitas vincular el formulario a una nueva entidad Pago
        return "crearPago";
    }

    @PostMapping("/crearPago")
    public String realizarPago(@RequestParam("usuarioId") int usuarioId,
                               @RequestParam("monto") int monto,
                               @RequestParam("fechaPago") LocalDate fechaPago) {

        Optional<Usuario> optionalCliente = usuarioRepo.findById(usuarioId);
        if (optionalCliente.isPresent() && optionalCliente.get() instanceof Cliente) {
            Cliente cliente = (Cliente)optionalCliente.get();
            Pago nuevoPago = new Pago();
            nuevoPago.setCliente(cliente);
            nuevoPago.setMonto(monto);
            nuevoPago.setFechaPago(fechaPago);
            pagoRepo.save(nuevoPago);
        }

        return "redirect:/listarPagos";
    }
}
