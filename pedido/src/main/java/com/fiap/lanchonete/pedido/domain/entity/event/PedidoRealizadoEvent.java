package com.fiap.lanchonete.pedido.domain.entity.event;

import com.fiap.lanchonete.pedido.domain.entity.Pedido;

public class PedidoRealizadoEvent {
	Pedido pedidoRealizado;

	public Pedido getPedidoRealizado() {
		return pedidoRealizado;
	}

	public void setPedidoRealizado(Pedido pedidoRealizado) {
		this.pedidoRealizado = pedidoRealizado;
	}

	public PedidoRealizadoEvent(Pedido pedidoRealizado) {
		super();
		this.pedidoRealizado = pedidoRealizado;
	}
	
}
