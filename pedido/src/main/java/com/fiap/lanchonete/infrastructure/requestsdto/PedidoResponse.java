package com.fiap.lanchonete.infrastructure.requestsdto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fiap.lanchonete.domain.entity.Produto;
import com.fiap.lanchonete.domain.entity.StatusPagamento;
import com.fiap.lanchonete.domain.entity.StatusPedido;

public class PedidoResponse {

	Integer idPedido;

	List<Produto>listaProdutos;
	StatusPedido statusPedido;
	StatusPagamento statusPagamento;
	BigDecimal valorTotal;
	
	@Override
	public int hashCode() {
		return Objects.hash(idPedido, listaProdutos, statusPagamento, statusPedido, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoResponse other = (PedidoResponse) obj;
		return Objects.equals(idPedido, other.idPedido) && Objects.equals(listaProdutos, other.listaProdutos)
				&& statusPagamento == other.statusPagamento && statusPedido == other.statusPedido
				&& Objects.equals(valorTotal, other.valorTotal);
	}

	public PedidoResponse(Integer idPedido, List<Produto>listaProdutos, StatusPedido statusPedido,
			StatusPagamento statusPagamento, BigDecimal valorTotal) {
		super();
		this.idPedido = idPedido;
		this.listaProdutos = listaProdutos;
		this.valorTotal = valorTotal;
		this.statusPedido = statusPedido;
		this.statusPagamento = statusPagamento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public List<Produto>getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto>listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

}
