package com.fiap.lanchonete.pagamento.application.usecases;

import java.util.List;

import com.fiap.lanchonete.pagamento.application.gateways.PedidoGateway;
import com.fiap.lanchonete.pagamento.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.pagamento.domain.entity.Pedido;
import com.fiap.lanchonete.pagamento.domain.entity.StatusPagamento;
import com.fiap.lanchonete.pagamento.domain.entity.StatusPedido;

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
	public Pedido atualizaPedidoPagamento(String topic, Integer id) {
		Pedido pedidoParaAtualizar = pedidoGateway.buscaPedidoId(id);
		Pedido pedidoAtaulizado;
		if (topic.equals("chargebacks")) {
			pedidoAtaulizado = new Pedido(pedidoParaAtualizar.getId(), 
					pedidoParaAtualizar.getListaProdutos(), StatusPagamento.Cancelado,pedidoParaAtualizar.getValorTotal());
			pedidoGateway.atualizaPedido(pedidoAtaulizado);
			
			return pedidoAtaulizado;
		} else {
			pedidoAtaulizado = new Pedido(pedidoParaAtualizar.getId(), 
					pedidoParaAtualizar.getListaProdutos(), StatusPagamento.Pago, pedidoParaAtualizar.getValorTotal());
			pedidoGateway.atualizaPedido(pedidoAtaulizado);
			return pedidoAtaulizado;

		}

	}

}
