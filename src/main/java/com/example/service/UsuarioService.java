/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.entity.Usuario;
import com.example.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mac
 */
@Service()
public class UsuarioService {
    
    @Autowired
    //@Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> getAllUsuario(){
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> getUsuarioById(long id){
        return usuarioRepository.findById(id);
    }
    
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    } 
    
    public void removeUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
    
}
