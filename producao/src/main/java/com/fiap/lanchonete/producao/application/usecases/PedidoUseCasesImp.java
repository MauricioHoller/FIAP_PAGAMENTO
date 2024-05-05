package com.fiap.lanchonete.producao.application.usecases;

import java.util.List;

import com.fiap.lanchonete.producao.application.gateways.PedidoGateway;
import com.fiap.lanchonete.producao.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.producao.domain.entity.Pedido;
import com.fiap.lanchonete.producao.domain.entity.StatusPagamento;
import com.fiap.lanchonete.producao.domain.entity.StatusPedido;

public class PedidoUseCasesImp implements PedidoUseCases {

	
	private final PedidoGateway pedidoGateway;

	public PedidoUseCasesImp(PedidoGateway pedidoGateway) {
		this.pedidoGateway = pedidoGateway;
	}

	@Override
	public List<Pedido> buscaPedidos() {
		return pedidoGateway.buscaPedidos();
	}

	
	@Override
	public List<Pedido> buscaPedidosPorStatus(StatusPedido status) {
		return pedidoGateway.buscaPedidosStatus(status);
	}
	
	@Override
	public Pedido criaPedido(Pedido pedido) {
		return pedidoGateway.criaPedido(pedido);
	}
	
	@Override
	public Pedido buscaPedidoId(Integer id) throws PedidoNaoEncontradoException {
		Pedido pedido = pedidoGateway.buscaPedidoId(id);
		if (pedido == null)
			throw new PedidoNaoEncontradoException();

		return pedido;
	}
	
	@Override
	public Pedido buscaProximoPedido() throws PedidoNaoEncontradoException {
		Pedido pedido = pedidoGateway.buscaPedidosStatus(StatusPedido.Recebido).isEmpty() ? null : pedidoGateway.buscaPedidosStatus(StatusPedido.Recebido).get(0);
		return pedido;
	}

	@Override
	public Pedido atualizaPedidoStatus(Integer id, StatusPedido status) {
		Pedido pedido = pedidoGateway.buscaPedidoId(id);
		pedido.setStatusPedido(status);
		pedidoGateway.atualizaPedido(pedido);
		return pedido;
	}
	


}
