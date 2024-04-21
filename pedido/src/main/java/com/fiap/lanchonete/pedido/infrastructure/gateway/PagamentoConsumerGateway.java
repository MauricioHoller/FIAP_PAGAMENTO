package com.fiap.lanchonete.pedido.infrastructure.gateway;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.pedido.application.usecases.PedidoUseCases;
import com.fiap.lanchonete.pedido.application.usecases.exceptions.PedidoNaoEncontradoException;
import com.fiap.lanchonete.pedido.domain.entity.event.PagamentoAtualizado;

@Component
@RabbitListener(queues = PagamentoConsumerGateway.PAGAMENTO_QUEUE_1)
public class PagamentoConsumerGateway {
	private static final String PAGAMENTO_QUEUE_1 = "pedido-queue";

	final PedidoUseCases pedidoUseCases;
	
	PagamentoConsumerGateway(PedidoUseCases pedidoUseCases){
		this.pedidoUseCases = pedidoUseCases;
	}
	
	@RabbitHandler
	public void pagamentoRecebido(PagamentoAtualizado pagamentoAtualizado) throws PedidoNaoEncontradoException {
		pedidoUseCases.atualizaPedidoPagamento(pagamentoAtualizado.getTopico(),pagamentoAtualizado.getPedidoPago().getId());
	}
	
	
	
}
