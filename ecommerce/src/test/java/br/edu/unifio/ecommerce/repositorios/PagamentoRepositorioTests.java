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

import br.edu.unifio.ecommerce.entidades.Pagamento;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PagamentoRepositorioTests {

    @Autowired
    private PagamentoRepositorio pagamentoRepositorio;

    @Test
    @Order(1)
    public void deveBuscarUmPagamentoPorID() {
        Pagamento pagamento = pagamentoRepositorio.findById(3).orElseThrow();

        assertNotNull(pagamento);
        assertEquals("Pendente", pagamento.getStatus());
        assertEquals("Boleto", pagamento.getTipo());
    }

    @Test
    @Order(2)
    public void deveListarTodosOsPagamentos() {
        List<Pagamento> pagamentos = pagamentoRepositorio.findAll();

        assertNotNull(pagamentos);
        assertEquals(5, pagamentos.size());
        assertTrue(pagamentos.stream().anyMatch(p -> p.getTipo().equals("Pix")));
    }

    @Test
    @Order(3)
    public void pagamentoDeveEstarAssociadoAoSeuPedido() {
        Pagamento pagamento = pagamentoRepositorio.findById(1).orElseThrow();

        assertNotNull(pagamento.getPedido());
        assertEquals(0, pagamento.getPedido().getValorTotal().compareTo(new BigDecimal("3500.00")));
    }
}
