package com.example.dressToImpressShop_viniciusOliveira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ListagemController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/pedidos")
    public ModelAndView listarPedidos(){
        ModelAndView modelAndView= new ModelAndView("pedidos");
        try {
            List<Map<String,Object>> pedidos = jdbcTemplate.queryForList("""
                    SELECT data_pedido,forma_pagamento,quantidade,valor_unitario,cliente_id,produto_id,(quantidade*valor_unitario) as valor_total,
                    ((quantidade * valor_unitario) * 0.3575) as imposto
                    FROM pedidos""");
            modelAndView.addObject("pedidos", pedidos);

        }
        catch (DataAccessException e) {
            modelAndView.setViewName("erro");
            modelAndView.addObject("mensagem", "Erro ao recuperar os pedidos do banco de dados.");
        }

        return modelAndView;
    }

}
