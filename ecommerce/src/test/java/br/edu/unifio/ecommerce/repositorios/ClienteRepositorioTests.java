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

import br.edu.unifio.ecommerce.entidades.Cliente;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteRepositorioTests {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    @Order(1)
    public void deveBuscarUmClientePorID() {
        Cliente cliente = clienteRepositorio.findById(1).orElseThrow();

        assertNotNull(cliente);
        assertEquals("Diego", cliente.getNome());
        assertEquals("diego@gmail.com", cliente.getEmail());
    }

    @Test
    @Order(2)
    public void deveListarTodosOsClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();

        assertNotNull(clientes);
        assertEquals(5, clientes.size());
        assertTrue(clientes.stream().anyMatch(c -> c.getNome().equals("Maria")));
        assertTrue(clientes.stream().anyMatch(c -> c.getEmail().equals("pedro@gmail.com")));
    }
}
