package com.fiap.lanchonete.pagamento.infrastructure.requestsdto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fiap.lanchonete.pagamento.domain.entity.Produto;
import com.fiap.lanchonete.pagamento.domain.entity.StatusPagamento;

class PedidoResponseTest {

    @Test
    void testGettersAndSetters() {
        Integer idPedido = 1;
        List<Produto> listaProdutos = new ArrayList<>();
        StatusPagamento statusPagamento = StatusPagamento.EsperandoConfirmação;
        BigDecimal valorTotal = BigDecimal.TEN;

        PedidoResponse pedidoResponse = new PedidoResponse(idPedido, listaProdutos, statusPagamento, valorTotal);

        assertEquals(idPedido, pedidoResponse.getIdPedido());
        assertEquals(listaProdutos, pedidoResponse.getListaProdutos());
        assertEquals(statusPagamento, pedidoResponse.getStatusPagamento());
        assertEquals(valorTotal, pedidoResponse.getValorTotal());
    }
}
