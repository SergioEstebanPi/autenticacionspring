package com.example.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
@RestController
public class AccountController {
    @RequestMapping(value = "zone/public/{accountNumber}")
    public String getPublic(@PathVariable final int accountNumber){
        return "Esta es la zona publica cuenta: " + accountNumber;
    }
    @RequestMapping(value = "zone/private/{accountNumber}")
    public String getPrivate(@PathVariable final int accountNumber){
        return "Esta es la zona privada cuenta: " + accountNumber;
    }    
}
