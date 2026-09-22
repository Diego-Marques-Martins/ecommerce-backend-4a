package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.unifio.ecommerce.entidades.ItemPedido;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemPedidoRepositorioTests {

    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Test
    @Order(1)
    public void deveBuscarUmItemPedidoPorID() {
        ItemPedido itemPedido = itemPedidoRepositorio.findById(2).orElseThrow();

        assertNotNull(itemPedido);
        assertEquals(1, itemPedido.getQuantidade());
        assertEquals(0, itemPedido.getValorUnitario().compareTo(new BigDecimal("1200.00")));
    }

    @Test
    @Order(2)
    public void deveListarTodosOsItensPedido() {
        List<ItemPedido> itens = itemPedidoRepositorio.findAll();

        assertNotNull(itens);
        assertEquals(5, itens.size());
    }

    @Test
    @Order(3)
    public void itemPedidoDeveEstarAssociadoAoPedidoEAoProduto() {
        ItemPedido itemPedido = itemPedidoRepositorio.findById(1).orElseThrow();

        assertNotNull(itemPedido.getPedido());
        assertNotNull(itemPedido.getProduto());
        assertEquals("Pago", itemPedido.getPedido().getStatus());
        assertEquals("Notebook", itemPedido.getProduto().getNome());
    }
}
