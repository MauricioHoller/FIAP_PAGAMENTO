package com.fiap.lanchonete.pagamento.application.usecases;

import java.util.List;

import com.fiap.lanchonete.pagamento.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.pagamento.domain.entity.Pedido;
import com.fiap.lanchonete.pagamento.domain.entity.StatusPedido;

public interface PedidoUseCases {

	public List<Pedido> buscaPedidos();

	public List<Pedido> buscaPedidosPorStatus(StatusPedido status);

	public Pedido buscaPedidoId(Integer id) throws PedidoNaoEncontradoException;
	public Pedido criaPedido(Pedido pedido);
	public Pedido atualizaPedidoPagamento(String topic, Integer id);
}
