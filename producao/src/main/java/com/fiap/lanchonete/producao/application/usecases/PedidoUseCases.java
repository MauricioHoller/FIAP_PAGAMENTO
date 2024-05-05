package com.fiap.lanchonete.producao.application.usecases;

import java.util.List;

import com.fiap.lanchonete.producao.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.producao.domain.entity.Pedido;
import com.fiap.lanchonete.producao.domain.entity.StatusPedido;

public interface PedidoUseCases {

	public List<Pedido> buscaPedidos();

	public List<Pedido> buscaPedidosPorStatus(StatusPedido status);

	public Pedido buscaPedidoId(Integer id) throws PedidoNaoEncontradoException;
	
	public Pedido buscaProximoPedido() throws PedidoNaoEncontradoException;
	
	public Pedido atualizaPedidoStatus(Integer id, StatusPedido status);
	
	public Pedido criaPedido(Pedido pedido);
}
