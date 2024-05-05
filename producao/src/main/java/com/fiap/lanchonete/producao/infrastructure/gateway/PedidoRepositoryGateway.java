package com.fiap.lanchonete.producao.infrastructure.gateway;

import java.util.List;
import java.util.Optional;

import com.fiap.lanchonete.producao.application.gateways.PedidoGateway;
import com.fiap.lanchonete.producao.domain.entity.Pedido;
import com.fiap.lanchonete.producao.domain.entity.StatusPedido;
import com.fiap.lanchonete.producao.infrastructure.gateway.mapper.PedidoEntityMapper;
import com.fiap.lanchonete.producao.infrastructure.persistence.PedidoRepository;
import com.fiap.lanchonete.producao.infrastructure.persistence.entity.PedidoEntity;

public class PedidoRepositoryGateway implements PedidoGateway {

	private final PedidoRepository repository;
	private final PedidoEntityMapper mapper;

	public PedidoRepositoryGateway(PedidoRepository repository, PedidoEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Pedido criaPedido(Pedido pedido) {
		return mapper.paraObjetoDominio(repository.save(mapper.paraPedidoEntity(pedido)));
	}

	@Override
	public void atualizaPedido(Pedido pedido) {
		repository.save(mapper.paraPedidoEntity(pedido));
	}

	@Override
	public List<Pedido> buscaPedidos() {
		List<PedidoEntity> pedidos = repository.findAllByStatusPedidoOrderByDataCricao(StatusPedido.Pronto);
		pedidos.addAll(repository.findAllByStatusPedidoOrderByDataCricao(StatusPedido.EmPreparacao).stream().toList());
		pedidos.addAll(repository.findAllByStatusPedidoOrderByDataCricao(StatusPedido.Recebido).stream().toList());

		return pedidos.stream().map(mapper::paraObjetoDominio).toList();
	}

	@Override
	public Pedido buscaPedidoId(Integer id) {
		Optional<PedidoEntity> pedidos = repository.findById(id);
		if (pedidos.isPresent())
			return mapper.paraObjetoDominio(pedidos.get());
		return null;
	}

	@Override
	public List<Pedido> buscaPedidosStatus(StatusPedido status) {
		List<PedidoEntity> listaPedidos = repository.findAllByStatusPedidoOrderByDataCricao(status);
		return listaPedidos.stream().map(mapper::paraObjetoDominio).toList();

	}
}