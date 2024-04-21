package com.fiap.lanchonete.pedido.application.usecases;

import java.math.BigDecimal;
import java.util.List;

import com.fiap.lanchonete.pedido.application.usecases.exceptions.PedidoComProdutoNaoCadastradoException;
import com.fiap.lanchonete.pedido.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.pedido.domain.entity.Pedido;
import com.fiap.lanchonete.pedido.domain.entity.StatusPedido;

public interface PedidoUseCases {

	public List<Pedido> buscaPedidos();
	public List<Pedido> buscaPedidosPorStatus(StatusPedido status);
	public Pedido buscaPedidoId(Integer id) throws PedidoNaoEncontradoException;
	public Pedido realizaPedido(Pedido pedido) throws PedidoComProdutoNaoCadastradoException;
	public void atualizaPedido(Pedido pedido) throws PedidoNaoEncontradoException;
	public void atualizaPedidoStatus(Integer id, StatusPedido status) throws PedidoNaoEncontradoException;
	public String atualizaPedidoPagamento(String topic, Integer id);
	public BigDecimal calculaValorTotal(List<BigDecimal> valores);
}
