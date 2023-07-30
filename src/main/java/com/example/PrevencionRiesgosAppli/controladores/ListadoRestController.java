package com.example.PrevencionRiesgosAppli.controladores;


import com.example.PrevencionRiesgosAppli.modelo.Roles;
import com.example.PrevencionRiesgosAppli.modelo.Usuario;
import com.example.PrevencionRiesgosAppli.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListadoRestController {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping("/clientes")
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> clientes = usuarioRepo.findAllClientes(Roles.Cliente);
        System.out.println("Listado de Clientes: ");
        System.out.println("");
        for (Usuario cliente : clientes) {
            System.out.println("Id : " + cliente.getId());
            System.out.println("Nombre : " + cliente.getNombre());
            System.out.println("Email : " + cliente.getEmail());
            System.out.println("Fecha de Nacimiento : " + cliente.getFechaNacimiento());
            System.out.println("Rut : " + cliente.getRut());
            System.out.println("--------------------------");
        }
        return clientes;
    }

}
