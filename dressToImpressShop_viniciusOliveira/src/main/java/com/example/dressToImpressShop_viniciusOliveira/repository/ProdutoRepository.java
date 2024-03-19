package com.example.dressToImpressShop_viniciusOliveira.repository;

import com.example.dressToImpressShop_viniciusOliveira.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto,Long> {
}
