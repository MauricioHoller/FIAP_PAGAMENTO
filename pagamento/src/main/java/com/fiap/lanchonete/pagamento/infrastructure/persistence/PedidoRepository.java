package com.fiap.lanchonete.pagamento.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchonete.pagamento.infrastructure.persistence.entity.PedidoEntity;


public interface PedidoRepository  extends JpaRepository<PedidoEntity, Integer>{
}
