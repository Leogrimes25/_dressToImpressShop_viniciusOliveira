package com.example.dressToImpressShop_viniciusOliveira.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nomeProduto;

    @NotEmpty
    private String marca;

    @NotEmpty
    private String tipoTecido;

    @NotEmpty
    @DecimalMin(value = "0.0", inclusive = false)
    private Double precoCompra;

    @NotEmpty
    @DecimalMin(value = "0.0", inclusive = false)
    private Double precoVenda;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCadastro;

}
