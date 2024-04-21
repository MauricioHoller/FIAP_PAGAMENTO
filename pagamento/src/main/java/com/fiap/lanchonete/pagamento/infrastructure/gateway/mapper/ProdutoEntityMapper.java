package com.fiap.lanchonete.pagamento.infrastructure.gateway.mapper;

import com.fiap.lanchonete.pagamento.domain.entity.Produto;
import com.fiap.lanchonete.pagamento.infrastructure.persistence.entity.ProdutoEntity;

public class ProdutoEntityMapper {

	public ProdutoEntity paraProdutoEntity(Produto produto) {
	return new ProdutoEntity(produto.getCategoria(),produto.getNome(),produto.getDescricao(),produto.getValor());

	}
	
	public Produto paraObjetoDominio(ProdutoEntity produtoEntity) {
		return new Produto(produtoEntity.getCategoria(),produtoEntity.getNome(),produtoEntity.getDescricao(),produtoEntity.getValor());

	}
}
