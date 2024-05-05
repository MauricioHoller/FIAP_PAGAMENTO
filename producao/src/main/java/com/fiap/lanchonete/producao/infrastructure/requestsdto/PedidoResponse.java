package com.fiap.lanchonete.producao.infrastructure.requestsdto;

import java.math.BigDecimal;

import com.fiap.lanchonete.producao.domain.entity.StatusPedido;

public class PedidoResponse {

	private Integer idPedido;

	private String listaProdutos;
	private StatusPedido statusPedido;
	private BigDecimal valorTotal;
	
	public PedidoResponse(Integer idPedido, String listaProdutos, 
			StatusPedido statusPedido, BigDecimal valorTotal) {
		super();
		this.idPedido = idPedido;
		this.listaProdutos = listaProdutos;
		this.valorTotal = valorTotal;
		this.statusPedido = statusPedido;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public String getListaProdutos() {
		return listaProdutos;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}


}
