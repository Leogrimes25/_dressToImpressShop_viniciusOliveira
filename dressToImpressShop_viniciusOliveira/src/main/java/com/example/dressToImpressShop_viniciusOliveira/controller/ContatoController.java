package com.example.dressToImpressShop_viniciusOliveira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {
    @GetMapping
    public String Contato(){
        return "contato.html";
    }
}
