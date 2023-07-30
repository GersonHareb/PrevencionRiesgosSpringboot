package com.example.PrevencionRiesgosAppli.servicios;

import com.example.PrevencionRiesgosAppli.modelo.Usuario;
import com.example.PrevencionRiesgosAppli.repositorios.UsuarioRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UsuarioRepo usuarioRepo;

    public UserService(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("No existen registros de este usuario en el sistema: " + email);
        }
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getTipo().name()));
        return new User(usuario.getEmail(), usuario.getPassword(), authorities);
    }
}

