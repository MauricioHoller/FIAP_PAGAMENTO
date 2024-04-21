package com.fiap.lanchonete.pedido.infraestructure.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.pedido.application.gateways.PedidoGateway;
import com.fiap.lanchonete.pedido.application.gateways.ProdutoGateway;
import com.fiap.lanchonete.pedido.application.usecases.PedidoUseCases;
import com.fiap.lanchonete.pedido.application.usecases.PedidoUseCasesImp;
import com.fiap.lanchonete.pedido.infrastructure.gateway.PedidoRepositoryGateway;
import com.fiap.lanchonete.pedido.infrastructure.gateway.mapper.PedidoEntityMapper;
import com.fiap.lanchonete.pedido.infrastructure.mapper.PedidoRequestMapper;
import com.fiap.lanchonete.pedido.infrastructure.persistence.PedidoRepository;

@Configuration
public class PedidoConfig {

	@Bean
	PedidoUseCases pedidoInteractorBean(PedidoGateway PedidoGateway, ProdutoGateway produtoGateway) {
		return new PedidoUseCasesImp(PedidoGateway, produtoGateway);
	}

	@Bean
	PedidoGateway pedidoGateway(PedidoEntityMapper mapper, PedidoRepository repository) {
		return new PedidoRepositoryGateway(repository, mapper);
	}

	@Bean
	PedidoEntityMapper pedidoMapper() {
		return new PedidoEntityMapper();
	}

	@Bean
	PedidoRequestMapper pedidoRequestMapper() {
		return new PedidoRequestMapper();
	}
}
