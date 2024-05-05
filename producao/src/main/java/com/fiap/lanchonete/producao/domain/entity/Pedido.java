package com.fiap.lanchonete.producao.domain.entity;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Pedido {
	
	Integer id;
	String listaProdutos;
	StatusPedido statusPedido;
	BigDecimal valorTotal;
	LocalTime dataCricao;
	
	Pedido(){
		
	}
	public Pedido(Integer id, String listaProdutos,
			StatusPedido statusPedido,  BigDecimal valorTotal, LocalTime dataCricao) {
	
		this.id = id;
		this.listaProdutos = listaProdutos;
		this.valorTotal = valorTotal;
		this.dataCricao = dataCricao;
		this.statusPedido = statusPedido;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(String listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalTime getDataCricao() {
		return dataCricao;
	}
	public void setDataCricao(LocalTime dataCricao) {
		this.dataCricao = dataCricao;
	}
	
}
