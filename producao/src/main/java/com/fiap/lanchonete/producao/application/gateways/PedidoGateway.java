package com.fiap.lanchonete.producao.application.gateways;

import java.util.List;

import com.fiap.lanchonete.producao.domain.entity.Pedido;
import com.fiap.lanchonete.producao.domain.entity.StatusPedido;



public interface PedidoGateway {
	Pedido criaPedido(Pedido pedido);

	void atualizaPedido(Pedido pedido);

	List<Pedido> buscaPedidos();

	Pedido buscaPedidoId(Integer id);

	List<Pedido> buscaPedidosStatus(StatusPedido status); 

}
