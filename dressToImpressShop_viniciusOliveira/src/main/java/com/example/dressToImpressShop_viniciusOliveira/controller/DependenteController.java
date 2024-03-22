package com.example.dressToImpressShop_viniciusOliveira.controller;

import com.example.dressToImpressShop_viniciusOliveira.model.Dependente;
import com.example.dressToImpressShop_viniciusOliveira.model.Produto;
import com.example.dressToImpressShop_viniciusOliveira.repository.DependenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/dependentes")
public class DependenteController {
    @Autowired
    private DependenteRepository dependenteRepository;

    @GetMapping
    public List<Dependente> visualizarTodos(){
        return dependenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dependente> visualizarPorId(@PathVariable Long id) {
        Optional<Dependente> dependenteOptional = dependenteRepository.findById(id);
        return dependenteOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dependente> adicionarDependente(@RequestBody Dependente dependente){
        Dependente novoDependente = dependenteRepository.save(dependente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDependente);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Dependente> atualizarDependente(@PathVariable Long id, @RequestBody Dependente dependente){
        Optional<Dependente> dependenteOptional= dependenteRepository.findById(id);
        if (dependenteOptional.isPresent()){
            Dependente _dependente = dependenteOptional.get();
            BeanUtils.copyProperties(dependente,_dependente,"id");
            return new ResponseEntity<>(dependenteRepository.save(_dependente), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Produto> deletarDependente(@PathVariable Long id){
        Optional<Dependente> dependenteOptional = dependenteRepository.findById(id);
        if (dependenteOptional.isPresent()){
            dependenteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}


