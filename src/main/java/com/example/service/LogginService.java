/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.entity.Rol;
import com.example.entity.Usuario;
import com.example.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mac
 */
@Service()
public class LogginService implements UserDetailsService{
    @Autowired
    //@Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("buscando usuario con el correo: " + username);
        Usuario usuario = usuarioRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildAuthorities(usuario.getRol());
        return buildUser(usuario, authorities);
    }

    private User buildUser(Usuario usuario, List<GrantedAuthority> authorities){
        return new User(usuario.getUsuarioname(), 
                usuario.getPassword(), 
                true, 
                true, 
                true, 
                true, 
                authorities);
        
    }
    
    private List<GrantedAuthority> buildAuthorities(Set<Rol> roles){
        Set<GrantedAuthority> auths = new HashSet<>();
        for (Rol rol : roles) {
            auths.add(new SimpleGrantedAuthority(rol.getRole()));
        }
        return new ArrayList<>(auths);
    }    
}
