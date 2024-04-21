package com.fiap.lanchonete.pedido.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchonete.pedido.domain.entity.StatusPedido;
import com.fiap.lanchonete.pedido.infrastructure.persistence.entity.PedidoEntity;


public interface PedidoRepository  extends JpaRepository<PedidoEntity, Integer>{
	
	List<PedidoEntity> findAllByStatusPedidoOrderById(StatusPedido status);
	
}
