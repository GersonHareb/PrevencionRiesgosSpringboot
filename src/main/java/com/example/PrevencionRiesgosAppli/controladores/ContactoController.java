package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Contacto;
import com.example.PrevencionRiesgosAppli.repositorios.ContactoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactoController {

    @Autowired
    private ContactoRepo contactoRepo;

    @RequestMapping(path="/contacto", method = RequestMethod.GET)
    public String Contacto(){
        return "contacto";
    }

    @PostMapping("/postContacto")
    public String PostContacto(@ModelAttribute Contacto contacto){

        Contacto newContacto = new Contacto();
        newContacto.setNombre(contacto.getNombre());
        newContacto.setEmail(contacto.getEmail());
        newContacto.setDireccion(contacto.getDireccion());
        newContacto.setComentario(contacto.getComentario());
        contactoRepo.save(newContacto);

        return "redirect:/inicio";
    }
}
