package com.fiap.lanchonete.producao.infrastructure.mapper;

import com.fiap.lanchonete.producao.domain.entity.Pedido;
import com.fiap.lanchonete.producao.infrastructure.requestsdto.PedidoResponse;

public class PedidoRequestMapper {
	

	public PedidoResponse paraResponse(Pedido pedido) {
		return new PedidoResponse(pedido.getId(), pedido.getListaProdutos(), pedido.getStatusPedido(), pedido.getValorTotal());
	}
}
