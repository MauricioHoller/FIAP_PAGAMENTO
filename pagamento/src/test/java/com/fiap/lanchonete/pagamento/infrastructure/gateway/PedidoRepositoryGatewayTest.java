package com.fiap.lanchonete.pagamento.infrastructure.gateway;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fiap.lanchonete.pagamento.application.gateways.PedidoGateway;
import com.fiap.lanchonete.pagamento.domain.entity.Pedido;
import com.fiap.lanchonete.pagamento.domain.entity.StatusPedido;
import com.fiap.lanchonete.pagamento.infrastructure.gateway.mapper.PedidoEntityMapper;
import com.fiap.lanchonete.pagamento.infrastructure.persistence.PedidoRepository;
import com.fiap.lanchonete.pagamento.infrastructure.persistence.entity.PedidoEntity;

class PedidoRepositoryGatewayTest {

    private PedidoRepository repository;
    private PedidoEntityMapper mapper;
    private PedidoGateway pedidoGateway;

    @BeforeEach
    void setUp() {
        repository = mock(PedidoRepository.class);
        mapper = mock(PedidoEntityMapper.class);
        pedidoGateway = new PedidoRepositoryGateway(repository, mapper);
    }

    @Test
    void testCriaPedido() {
        Pedido pedido = new Pedido();
        PedidoEntity pedidoEntity = new PedidoEntity();
        when(mapper.paraPedidoEntity(pedido)).thenReturn(pedidoEntity);
        when(repository.save(pedidoEntity)).thenReturn(pedidoEntity);
        when(mapper.paraObjetoDominio(pedidoEntity)).thenReturn(pedido);

        Pedido result = pedidoGateway.criaPedido(pedido);

        assertEquals(pedido, result);
    }

    @Test
    void testAtualizaPedido() {
        Pedido pedido = new Pedido();
        PedidoEntity pedidoEntity = new PedidoEntity();
        when(mapper.paraPedidoEntity(pedido)).thenReturn(pedidoEntity);

        pedidoGateway.atualizaPedido(pedido);

        verify(repository, times(1)).save(pedidoEntity);
    }

    @Test
    void testBuscaPedidos() {
        List<PedidoEntity> pedidoEntities = new ArrayList<>();
        when(repository.findAllByStatusPedidoOrderById(StatusPedido.Pronto)).thenReturn(pedidoEntities);
        when(repository.findAllByStatusPedidoOrderById(StatusPedido.EmPreparacao)).thenReturn(pedidoEntities);
        when(repository.findAllByStatusPedidoOrderById(StatusPedido.Recebido)).thenReturn(pedidoEntities);
        when(mapper.paraObjetoDominio(any(PedidoEntity.class))).thenReturn(new Pedido());

        List<Pedido> result = pedidoGateway.buscaPedidos();

        assertEquals(0, result.size());
    }

    @Test
    void testBuscaPedidoId_Existente() {
        int id = 1;
        PedidoEntity pedidoEntity = new PedidoEntity();
        Pedido pedido = new Pedido();
        when(repository.findById(id)).thenReturn(Optional.of(pedidoEntity));
        when(mapper.paraObjetoDominio(pedidoEntity)).thenReturn(pedido);

        Pedido result = pedidoGateway.buscaPedidoId(id);

        assertEquals(pedido, result);
    }

    @Test
    void testBuscaPedidoId_NaoExistente() {
        int id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        Pedido result = pedidoGateway.buscaPedidoId(id);

        assertNull(result);
    }

    @Test
    void testBuscaPedidosStatus() {
        List<PedidoEntity> pedidoEntities = new ArrayList<>();
        StatusPedido status = StatusPedido.Recebido;
        when(repository.findAllByStatusPedidoOrderById(status)).thenReturn(pedidoEntities);
        when(mapper.paraObjetoDominio(any(PedidoEntity.class))).thenReturn(new Pedido());

        List<Pedido> result = pedidoGateway.buscaPedidosStatus(status);

        assertEquals(0, result.size());
    }
}
