package com.example.dressToImpressShop_viniciusOliveira.controller;

import com.example.dressToImpressShop_viniciusOliveira.model.Dependente;
import com.example.dressToImpressShop_viniciusOliveira.repository.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dependentes")
public class DependenteController {
    @Autowired
    private DependenteRepository dependenteRepository;

    @GetMapping
    public List<Dependente> visualizarTodos(){
        return dependenteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Dependente> adicionarProduto(@RequestBody Dependente dependente){
        Dependente novoDependente = dependenteRepository.save(dependente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDependente);

    }
}


