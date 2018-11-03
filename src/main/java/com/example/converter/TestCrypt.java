/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mac
 */
public class TestCrypt {
    public static void main(String[] args){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("usuario1"));
        // $2a$10$A3NZXOf4nOqzH/5optc/2.t6dv5zkC8PDpk//tVZHnXnw1d.Ax0oK
    }
}
