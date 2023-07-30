package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Usuario;
import com.example.PrevencionRiesgosAppli.repositorios.VisitaRepo;
import com.example.PrevencionRiesgosAppli.servicios.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private VisitaService visitaService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(@RequestParam(required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "Credenciales incorrectas. Inténtalo de nuevo.");
        }

        // Capturar el nombre de usuario y agregarlo al modelo de vista
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = auth.getName();
        System.out.println(nombreUsuario);
        model.addAttribute("nombre", nombreUsuario); // Usamos "nombre" como atributo

        return "login";
    }

    @EventListener
    public void onAuthenticationSuccess(InteractiveAuthenticationSuccessEvent event) {
        Authentication auth = event.getAuthentication();
        String nombreUsuario = auth.getName();

        // Obtener el rol del usuario si está disponible en la autenticación
        String rolUsuario = "";
        if (auth.getAuthorities() != null && !auth.getAuthorities().isEmpty()) {
            rolUsuario = auth.getAuthorities().iterator().next().getAuthority();
        }

        // Registrar la visita utilizando el servicio VisitaService
        visitaService.registrarVisita(nombreUsuario, rolUsuario);
    }


}
