package com.fiap.lanchonete.pagamento.application.usecases.exceptions;

public class ProdutoJaCadastradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProdutoJaCadastradoException() {
        super("Produto já existe no banco de dados");
    }
}