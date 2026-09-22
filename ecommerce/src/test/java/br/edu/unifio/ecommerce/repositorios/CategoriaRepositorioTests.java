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

import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositorioTests {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    @Order(1)
    public void deveBuscarUmaCategoriaPorID() {
        Categoria categoria = categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();

        assertNotNull(categoria);
        assertEquals("Eletrônicos", categoria.getNome());
        assertEquals("Equipamentos Eletrônicos", categoria.getDescricao());
    }

    @Test
    @Order(2)
    public void deveListarTodasAsCategorias() {
        List<Categoria> categorias = categoriaRepositorio.findAll();

        assertNotNull(categorias);
        assertEquals(5, categorias.size());
        assertTrue(categorias.stream().anyMatch(c -> c.getNome().equals("Livros")));
        assertTrue(categorias.stream().anyMatch(c -> c.getNome().equals("Informática")));
    }
}
