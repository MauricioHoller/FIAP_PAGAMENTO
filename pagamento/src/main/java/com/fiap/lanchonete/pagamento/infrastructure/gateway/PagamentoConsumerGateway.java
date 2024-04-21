package com.fiap.lanchonete.pagamento.infrastructure.gateway;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.pagamento.application.usecases.PedidoUseCases;
import com.fiap.lanchonete.pagamento.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.pagamento.domain.entity.event.PedidoRealizadoEvent;

@Component
public class PagamentoConsumerGateway {
	private static final String PAGAMENTO_QUEUE_1 = "pagamento-queue";

	final PedidoUseCases pedidoUseCases;
	
	PagamentoConsumerGateway(PedidoUseCases pedidoUseCases){
		this.pedidoUseCases = pedidoUseCases;
	}
	
	@RabbitListener(queues = PAGAMENTO_QUEUE_1)
	public void pagamentoRecebido(PedidoRealizadoEvent pedidoRealizado) throws PedidoNaoEncontradoException {
		pedidoUseCases.criaPedido(pedidoRealizado.getPedidoRealizado());
		System.out.println("Pedido Cadastrado com sucesso!");
	}
	
}
