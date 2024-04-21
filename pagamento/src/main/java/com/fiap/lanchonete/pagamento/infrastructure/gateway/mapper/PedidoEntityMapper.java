package com.fiap.lanchonete.pagamento.infrastructure.gateway.mapper;

import com.fiap.lanchonete.pagamento.domain.entity.Pedido;
import com.fiap.lanchonete.pagamento.infrastructure.persistence.entity.PedidoEntity;

public class PedidoEntityMapper {
	ProdutoEntityMapper mapperProduct = new ProdutoEntityMapper();
	public PedidoEntity paraPedidoEntity(Pedido PedidoObjectDomain) {
	return new PedidoEntity(PedidoObjectDomain.getId() ,PedidoObjectDomain.getListaProdutos(), PedidoObjectDomain.getStatusPagamento(), PedidoObjectDomain.getValorTotal());

	}
	
	public Pedido paraObjetoDominio(PedidoEntity pedidoEntity) {
		return new Pedido(pedidoEntity.getId(), pedidoEntity.getListaProdutosPedido(),
				pedidoEntity.getStatusPagamento(), pedidoEntity.getValorTotal());
	}
}