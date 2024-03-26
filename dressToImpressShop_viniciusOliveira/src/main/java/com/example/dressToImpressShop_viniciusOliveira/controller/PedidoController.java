package com.example.dressToImpressShop_viniciusOliveira.controller;

import com.example.dressToImpressShop_viniciusOliveira.model.Pedido;
import com.example.dressToImpressShop_viniciusOliveira.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> visualizarTodos() {
        return pedidoRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pedido> visualizarPorId(@PathVariable Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        return pedidoOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletarPedido(@PathVariable Long id){
        Optional<Pedido> pedidoOptional =pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
             return ResponseEntity.notFound().build();
        }

    }
}