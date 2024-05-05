package com.fiap.lanchonete.producao.infraestructure.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.producao.application.gateways.PedidoGateway;
import com.fiap.lanchonete.producao.application.usecases.PedidoUseCases;
import com.fiap.lanchonete.producao.application.usecases.PedidoUseCasesImp;
import com.fiap.lanchonete.producao.infrastructure.gateway.PedidoRepositoryGateway;
import com.fiap.lanchonete.producao.infrastructure.gateway.mapper.PedidoEntityMapper;
import com.fiap.lanchonete.producao.infrastructure.mapper.PedidoRequestMapper;
import com.fiap.lanchonete.producao.infrastructure.persistence.PedidoRepository;

@Configuration
public class PedidoConfig {

	@Bean
	PedidoUseCases pedidoInteractorBean(PedidoGateway PedidoGateway) {
		return new PedidoUseCasesImp(PedidoGateway);
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
