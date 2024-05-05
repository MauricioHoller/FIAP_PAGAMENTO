package com.fiap.lanchonete.pagamento.infrastructure.requestsdto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fiap.lanchonete.pagamento.domain.entity.StatusPagamento;

class PedidoPagamentoResponseTest {

    @Test
    void testGettersAndSetters() {
        Integer idPedido = 1;
        StatusPagamento statusPagamento = StatusPagamento.EsperandoConfirmação;
        BigDecimal valorTotal = BigDecimal.TEN;

        PedidoPagamentoResponse pedidoPagamentoResponse = new PedidoPagamentoResponse(idPedido, statusPagamento, valorTotal);

        assertEquals(idPedido, pedidoPagamentoResponse.getIdPedido());
        assertEquals(statusPagamento, pedidoPagamentoResponse.getStatusPagamento());
        assertEquals(valorTotal, pedidoPagamentoResponse.getValorTotal());
    }
}
