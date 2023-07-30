package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Administrativo;
import com.example.PrevencionRiesgosAppli.modelo.Cliente;
import com.example.PrevencionRiesgosAppli.modelo.Profesional;
import com.example.PrevencionRiesgosAppli.modelo.Roles;
import com.example.PrevencionRiesgosAppli.repositorios.AdministrativoRepo;
import com.example.PrevencionRiesgosAppli.repositorios.ClienteRepo;
import com.example.PrevencionRiesgosAppli.repositorios.ProfesionalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class CrearUsuarioController {

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private ProfesionalRepo profesionalRepo;

    @Autowired
    private AdministrativoRepo administrativoRepo;

    @RequestMapping(path = "/crearUsuario", method = RequestMethod.GET)
    public String crearUsuarioForm(Model model) {
        //Muestra las opciones de rol en el combobozzz
        model.addAttribute("allRoles", Arrays.asList(Roles.values()));
        return "crearusuario";
    }




    @PostMapping("/crearUsuario")
    public String crearUsuario(@RequestParam("nombre") String nombre,
                               @RequestParam("fechaNacimiento") LocalDate fechaNacimiento,
                               @RequestParam("rut") String rut,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("tipo") String tipo,
                               @RequestParam(required = false) String titulo,
                               @RequestParam(required = false) LocalDate fechaIngreso,
                               @RequestParam(required = false) String telefono,
                               @RequestParam(required = false) String afp,
                               @RequestParam(required = false) String sistemaSalud,
                               @RequestParam(required = false) String direccion,
                               @RequestParam(required = false) String comuna,
                               @RequestParam(required = false) Integer edad,
                               @RequestParam(required = false) String area_exp,
                               @RequestParam(required = false) String experienciaPrevia) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        if (tipo.equalsIgnoreCase("Cliente")) {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setEmail(email);
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setRut(rut);
            String encodedPassword = encoder.encode(password);
            cliente.setPassword(encodedPassword);
            cliente.setTipo(Roles.valueOf(tipo));
            cliente.setTelefono(telefono);
            cliente.setAfp(afp);
            cliente.setSistemaSalud(sistemaSalud);
            cliente.setDireccion(direccion);
            cliente.setComuna(comuna);
            cliente.setEdad(edad);

            clienteRepo.save(cliente);
        } else if (tipo.equalsIgnoreCase("Administrativo")) {
            Administrativo administrativo = new Administrativo();
            administrativo.setNombre(nombre);
            administrativo.setEmail(email);
            administrativo.setFechaNacimiento(fechaNacimiento);
            administrativo.setRut(rut);
            String encodedPassword = encoder.encode(password);
            administrativo.setPassword(encodedPassword);
            administrativo.setTipo(Roles.valueOf(tipo));
            administrativo.setArea_exp(area_exp);
            administrativo.setExperienciaPrevia(experienciaPrevia);

            administrativoRepo.save(administrativo);
        } else if (tipo.equalsIgnoreCase("Profesional")) {
            Profesional profesional = new Profesional();
            profesional.setNombre(nombre);
            profesional.setEmail(email);
            profesional.setFechaNacimiento(fechaNacimiento);
            profesional.setRut(rut);
            String encodedPassword = encoder.encode(password);
            profesional.setPassword(encodedPassword);
            profesional.setTipo(Roles.valueOf(tipo));
            profesional.setTitulo(titulo);
            profesional.setFechaIngreso(fechaIngreso);

            profesionalRepo.save(profesional);
        }

        return "redirect:/listarUsuario";
    }
}
