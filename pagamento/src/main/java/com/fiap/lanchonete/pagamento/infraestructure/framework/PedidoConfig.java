package com.fiap.lanchonete.pagamento.infraestructure.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.pagamento.application.gateways.PedidoGateway;
import com.fiap.lanchonete.pagamento.application.usecases.PedidoUseCases;
import com.fiap.lanchonete.pagamento.application.usecases.PedidoUseCasesImp;
import com.fiap.lanchonete.pagamento.infrastructure.gateway.PedidoRepositoryGateway;
import com.fiap.lanchonete.pagamento.infrastructure.gateway.mapper.PedidoEntityMapper;
import com.fiap.lanchonete.pagamento.infrastructure.mapper.PedidoRequestMapper;
import com.fiap.lanchonete.pagamento.infrastructure.persistence.PedidoRepository;

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
