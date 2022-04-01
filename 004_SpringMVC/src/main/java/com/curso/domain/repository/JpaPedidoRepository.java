package com.curso.domain.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Pedido;


@Repository
@Transactional
public class JpaPedidoRepository implements PedidoRepository {
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public void create(Pedido pedido) {
		em.persist(pedido);
		
	}


}
