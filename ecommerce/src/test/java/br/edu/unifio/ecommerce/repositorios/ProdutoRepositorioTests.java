package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.unifio.ecommerce.entidades.Produto;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdutoRepositorioTests {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Test
    @Order(1)
    public void deveBuscarUmProdutoPorID() {
        Produto produto = produtoRepositorio.findById(1).orElseThrow();

        assertNotNull(produto);
        assertEquals("Código Limpo", produto.getNome());
        assertEquals(0, produto.getPreco().compareTo(new java.math.BigDecimal("73.44")));
    }

    @Test
    @Order(2)
    public void deveListarTodosOsProdutos() {
        List<Produto> produtos = produtoRepositorio.findAll();

        assertNotNull(produtos);
        assertEquals(5, produtos.size());
        assertTrue(produtos.stream().anyMatch(p -> p.getNome().equals("Notebook")));
        assertTrue(produtos.stream().anyMatch(p -> p.getNome().equals("Mouse")));
    }

    @Test
    @Order(3)
    public void produtoDeveEstarAssociadoASuaCategoria() {
        Produto produto = produtoRepositorio.findById(2).orElseThrow(); // Notebook

        assertNotNull(produto.getCategoria());
        assertEquals("Informática", produto.getCategoria().getNome());
    }
}
