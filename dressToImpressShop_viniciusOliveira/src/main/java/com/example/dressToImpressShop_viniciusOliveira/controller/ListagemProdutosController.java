package com.example.dressToImpressShop_viniciusOliveira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ListagemProdutosController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/produtos")
    public ModelAndView listarProdutos() {
        ModelAndView modelAndView = new ModelAndView("produtos");
        try {
            List<Map<String, Object>> produtos = jdbcTemplate.queryForList("SELECT * FROM produtos");
            modelAndView.addObject("produtos", produtos);
        } catch (DataAccessException e) {
            modelAndView.setViewName("erro");
            modelAndView.addObject("mensagem", "Erro ao recuperar os pedidos do banco de dados.");
        }


        return modelAndView;
    }

    @GetMapping("/buscar")
    public String buscarProdutosPorNome(@RequestParam("termo") String termo, Model model) {
        String sql = "SELECT * FROM produtos WHERE nome_produto = ?";
        List<Map<String, Object>> produtos = jdbcTemplate.queryForList(sql, termo);
        model.addAttribute("produtos",produtos);
        return "produtos";
    }

    @GetMapping("/buscar/marca")
    public String buscarProdutosPorMarca(@RequestParam("termo") String termo, Model model) {
        String sql = "SELECT * FROM produtos WHERE marca = ?";
        List<Map<String, Object>> produtos = jdbcTemplate.queryForList(sql, termo);
        model.addAttribute("produtos",produtos);
        return "produtos";
    }

    @GetMapping("/buscar/modelo")
    public String buscarProdutosPorModelo(@RequestParam("termo") String termo, Model model) {
        String sql = "SELECT * FROM produtos WHERE modelo = ?";
        List<Map<String, Object>> produtos = jdbcTemplate.queryForList(sql, termo);
        model.addAttribute("produtos",produtos);
        return "produtos";
    }

    @GetMapping("/buscar/memoria")
    public String buscarProdutosPorCapacidadeMemoria(@RequestParam("termo") String termo, Model model) {
        String sql = "SELECT * FROM produtos WHERE capacidade_memoria = ?";
        List<Map<String, Object>> produtos = jdbcTemplate.queryForList(sql, termo);
        model.addAttribute("produtos",produtos);
        return "produtos";
    }

}
