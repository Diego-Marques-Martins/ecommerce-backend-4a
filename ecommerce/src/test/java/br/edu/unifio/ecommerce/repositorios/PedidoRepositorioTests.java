package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.unifio.ecommerce.entidades.Pedido;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PedidoRepositorioTests {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Test
    @Order(1)
    public void deveBuscarUmPedidoPorID() {
        Pedido pedido = pedidoRepositorio.findById(1).orElseThrow();

        assertNotNull(pedido);
        assertEquals("Pago", pedido.getStatus());
        assertEquals(0, pedido.getValorTotal().compareTo(new BigDecimal("3500.00")));
    }

    @Test
    @Order(2)
    public void deveListarTodosOsPedidos() {
        List<Pedido> pedidos = pedidoRepositorio.findAll();

        assertNotNull(pedidos);
        assertEquals(5, pedidos.size());
        assertTrue(pedidos.stream().anyMatch(p -> p.getStatus().equals("Pendente")));
    }

    @Test
    @Order(3)
    public void pedidoDeveEstarAssociadoAoSeuCliente() {
        Pedido pedido = pedidoRepositorio.findById(3).orElseThrow(); // pedido da Maria

        assertNotNull(pedido.getCliente());
        assertEquals("Maria", pedido.getCliente().getNome());
        assertEquals("maria@gmail.com", pedido.getCliente().getEmail());
    }
}
