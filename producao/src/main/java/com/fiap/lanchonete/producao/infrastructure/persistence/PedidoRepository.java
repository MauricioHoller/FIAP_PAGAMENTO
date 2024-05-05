package com.fiap.lanchonete.producao.infrastructure.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fiap.lanchonete.producao.domain.entity.StatusPedido;
import com.fiap.lanchonete.producao.infrastructure.persistence.entity.PedidoEntity;


public interface PedidoRepository  extends CrudRepository<PedidoEntity, Integer>{
	
	List<PedidoEntity> findAllByStatusPedidoOrderByDataCricao(StatusPedido status);
	
}
