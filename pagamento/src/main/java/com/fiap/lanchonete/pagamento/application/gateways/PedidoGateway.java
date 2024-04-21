package com.fiap.lanchonete.pagamento.application.gateways;

import java.util.List;

import com.fiap.lanchonete.pagamento.domain.entity.Pedido;
import com.fiap.lanchonete.pagamento.domain.entity.StatusPedido;



public interface PedidoGateway {
	Pedido criaPedido(Pedido pedido);

	void atualizaPedido(Pedido pedido);

	List<Pedido> buscaPedidos();

	Pedido buscaPedidoId(Integer id);

	List<Pedido> buscaPedidosStatus(StatusPedido status); 

}
