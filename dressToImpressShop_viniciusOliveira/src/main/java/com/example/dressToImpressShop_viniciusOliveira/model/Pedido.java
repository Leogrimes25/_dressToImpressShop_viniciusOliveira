package com.example.dressToImpressShop_viniciusOliveira.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection
    private List<Carrinho> carrinhoList = new ArrayList<>();

    public enum FormaPagamento {
        DINHEIRO, CARTAO_CREDITO, CHAVE_PIX
    }

    // Adicionar um item ao pedido
    public void adicionarItem(Produto produto, int quantidade, double valorUnitario) {
        this.carrinhoList.add(new Carrinho(produto, quantidade, valorUnitario));
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Embeddable
    @Table(name = "carrinho")
    public static class Carrinho implements Serializable {

        @ManyToOne
        private Produto produto;

        @NotEmpty
        private int quantidade;

        @NotEmpty
        private double valorUnitario;
    }
}
