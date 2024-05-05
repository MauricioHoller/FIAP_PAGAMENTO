package com.fiap.lanchonete.pagamento.domain.entity.event;

import com.fiap.lanchonete.pagamento.domain.entity.Pedido;

public class PedidoRealizadoEvent {
	Pedido pedidoRealizado;

	public Pedido getPedidoRealizado() {
		return pedidoRealizado;
	}

	public void setPedidoRealizado(Pedido pedidoRealizado) {
		this.pedidoRealizado = pedidoRealizado;
	}
	PedidoRealizadoEvent(){
		
	}
	PedidoRealizadoEvent(Pedido pedidoRealizado){
		this.pedidoRealizado =pedidoRealizado;
	}
}
