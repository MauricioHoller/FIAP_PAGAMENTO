package com.fiap.lanchonete.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fiap.lanchonete.application.usecases.PedidoUseCases;
import com.fiap.lanchonete.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.domain.entity.Pedido;
import com.fiap.lanchonete.infrastructure.mapper.PedidoRequestMapper;
import com.fiap.lanchonete.infrastructure.requestsdto.PedidoResponse;

public class PedidoControllerTest {

    private PedidoUseCases pedidoUseCases;
    private PedidoController pedidoController;
    private PedidoRequestMapper mapper;
    private RabbitTemplate template;
    
    @BeforeEach
    public void setup() {
        pedidoUseCases = mock(PedidoUseCases.class);
        mapper =new PedidoRequestMapper();
        template = mock (RabbitTemplate.class);

        pedidoController = new PedidoController(pedidoUseCases, mapper, template);
    }

    @Test
    public void testBuscaPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        when(pedidoUseCases.buscaPedidos()).thenReturn(pedidos);
        
        List<PedidoResponse> response = pedidoController.buscaPedidos();

        assertEquals(pedidos.size(), response.size());
    }
    @Test
    public void testBuscaPedidosPorId_PedidoEncontrado() throws PedidoNaoEncontradoException {
        Pedido pedido = new Pedido();
        when(pedidoUseCases.buscaPedidoId(1)).thenReturn(pedido);

        ResponseEntity<PedidoResponse> responseEntity = pedidoController.buscaPedidosPorId(1);

        assertEquals(pedido, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testBuscaPedidosPorId_PedidoNaoEncontrado() throws PedidoNaoEncontradoException {
        when(pedidoUseCases.buscaPedidoId(1)).thenThrow(new PedidoNaoEncontradoException());

        ResponseEntity<PedidoResponse> responseEntity = pedidoController.buscaPedidosPorId(1);

        assertEquals(null, responseEntity.getBody());
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}
