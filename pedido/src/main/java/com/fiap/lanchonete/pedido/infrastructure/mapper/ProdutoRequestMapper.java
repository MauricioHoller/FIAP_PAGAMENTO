package com.fiap.lanchonete.pedido.infrastructure.mapper;

import com.fiap.lanchonete.pedido.domain.entity.Produto;
import com.fiap.lanchonete.pedido.domain.entity.ProdutoResponse;
import com.fiap.lanchonete.pedido.infrastructure.requestsdto.ProdutoRequest;

public class ProdutoRequestMapper {
	
	public Produto paraObjetoDominio(ProdutoRequest produtoRequest) {
		return new Produto(produtoRequest.getCategoria(), produtoRequest.getNome(), produtoRequest.getDescricao(), produtoRequest.getValor());

	}
	
	public ProdutoResponse paraResponse(Produto Produto) {
		return new ProdutoResponse(Produto.getCategoria(), Produto.getNome(), Produto.getDescricao(), Produto.getValor());
	}
}
