/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.entity.Usuario;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mac
 */
@Repository()
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
    //@Autowired
    public abstract Usuario findByUsername(String username);
}
