package com.curso.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Producto;

@Repository
@Qualifier("JpaProductoRepository")
@Transactional
public class JpaProductoRepository implements ProductoRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getAllProductos() {
		Query q = em.createNamedQuery("Producto.findAll");
		return q.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto getProducto(String idProducto) {
		Producto p = em.find(Producto.class, idProducto);
		return p;
	}

	@Override
	public void create(Producto producto) {
		em.persist(producto);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getProductosCategoria(String categoria) {
		Query q = em.createNamedQuery("Producto.findAllCategoria");
		q.setParameter("categoria", categoria);
		return q.getResultList();
	}

	@Override
	public void update(Producto producto) {
		em.merge(producto);
	}

	@Override
	public void delete(String idProducto) {
		Producto p = this.getProducto(idProducto);
		if(p!=null) {
			em.remove(p);
		}
		
	}

	

}
