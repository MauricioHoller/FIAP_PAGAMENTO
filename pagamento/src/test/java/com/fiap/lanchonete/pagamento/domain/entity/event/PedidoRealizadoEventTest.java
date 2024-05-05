package com.fiap.lanchonete.pagamento.domain.entity.event;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fiap.lanchonete.pagamento.domain.entity.Pedido;

class PedidoRealizadoEventTest {

    @Test
    void testGetSetPedidoRealizado() {
        Pedido pedido = new Pedido();
        PedidoRealizadoEvent evento = new PedidoRealizadoEvent();

        evento.setPedidoRealizado(pedido);

        assertEquals(pedido, evento.getPedidoRealizado());
    }
}
