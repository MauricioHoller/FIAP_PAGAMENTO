package com.fiap.lanchonete.pagamento.application.usecases.exceptions;

public class ProdutoNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException() {
        super("Produto não existe no banco de dados");
    }
}