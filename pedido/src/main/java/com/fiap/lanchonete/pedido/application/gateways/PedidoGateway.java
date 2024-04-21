package com.fiap.lanchonete.pedido.application.gateways;

import java.util.List;

import com.fiap.lanchonete.pedido.application.usecases.exceptions.PedidoComProdutoNaoCadastradoException;
import com.fiap.lanchonete.pedido.domain.entity.Pedido;
import com.fiap.lanchonete.pedido.domain.entity.StatusPedido;



public interface PedidoGateway {
	Pedido criaPedido(Pedido pedido) throws PedidoComProdutoNaoCadastradoException;

	void atualizaPedido(Pedido pedido);

	List<Pedido> buscaPedidos();

	Pedido buscaPedidoId(Integer id);

	List<Pedido> buscaPedidosStatus(StatusPedido status); 

}
