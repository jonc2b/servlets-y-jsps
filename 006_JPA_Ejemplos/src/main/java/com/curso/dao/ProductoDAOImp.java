package com.curso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.domain.Producto;


public class ProductoDAOImp implements ProductoDAO {
	private static EntityManagerFactory factory=Persistence.createEntityManagerFactory("OracleHRPU");

	@Override
	public void create(Producto p) {
 	
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

	}

	@Override
	public void update(Producto p) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		
		Producto p2=em.merge(p);
		
		em.getTransaction().commit();

	}

	@Override
	public void delete(String idProducto) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Producto p = em.find(Producto.class, idProducto);

		if (p != null) {
			em.remove(p);
		}

		em.getTransaction().commit();

	}

	@Override
	public void getById(String idProducto) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Producto p = em.find(Producto.class, idProducto);
		
		if(p == null) {
			System.out.println(" el producto no existe");
		}else {
			System.out.println(p);
		}

	}

}
