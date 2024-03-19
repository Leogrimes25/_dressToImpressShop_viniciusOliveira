package com.example.dressToImpressShop_viniciusOliveira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nomeCompleto;

    @NotNull
    private Genero genero;

    @NotEmpty
    private String rua;

    @NotEmpty
    private String bairro;

    @NotEmpty
    private int numero;

    @NotEmpty
    private String cidade;

    @NotEmpty
    @Email
    private String email;

    @Pattern(regexp = "\\+\\d{2} \\(\\d{2}\\) \\d{4}-\\d{4}")
    private String telefone;

    public enum Genero {
        MASCULINO, FEMININO, NAO_INFORMADO
    }

}
