package com.example.dressToImpressShop_viniciusOliveira.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPedido;

    @NotNull
    private FormaPagamento formaPagamento;

    @NotEmpty
    private int quantidade;

    @NotEmpty
    private double valorUnitario;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Produto produto;

    public enum FormaPagamento {
        DINHEIRO, CARTAO_CREDITO, CHAVE_PIX
    }
}


