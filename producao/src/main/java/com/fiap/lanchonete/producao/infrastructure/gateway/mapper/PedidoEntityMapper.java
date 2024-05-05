package com.fiap.lanchonete.producao.infrastructure.gateway.mapper;

import com.fiap.lanchonete.producao.domain.entity.Pedido;
import com.fiap.lanchonete.producao.infrastructure.persistence.entity.PedidoEntity;

public class PedidoEntityMapper {

	public PedidoEntity paraPedidoEntity(Pedido PedidoObjectDomain) {
	return new PedidoEntity(PedidoObjectDomain.getId() ,PedidoObjectDomain.getListaProdutos(), PedidoObjectDomain.getStatusPedido(), PedidoObjectDomain.getValorTotal());

	}
	
	public Pedido paraObjetoDominio(PedidoEntity pedidoEntity) {
		return new Pedido(pedidoEntity.getId(), pedidoEntity.getListaProdutosPedido(),
				pedidoEntity.getStatusPedido(), pedidoEntity.getValorTotal(),pedidoEntity.getDataCricao() );
	}
}