package com.fiap.lanchonete.pedido.domain.entity.event;

import com.fiap.lanchonete.pedido.domain.entity.Pedido;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
public class PagamentoAtualizado {
	Pedido pedidoPago;
	String topico;
	
	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public Pedido getPedidoPago() {
		return pedidoPago;
	}

	public void setPedidoPago(Pedido pedidoPago) {
		this.pedidoPago = pedidoPago;
	}
	
	
	
}
