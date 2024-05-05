package com.fiap.lanchonete.producao.application.usecases.exceptions;

public class PedidoNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException() {
        super("Pedido nao cadastrado");
    }
}