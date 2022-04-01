package com.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.domain.Cliente;
import com.curso.domain.Registro;

public class PruebasOneToOne {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		EntityManager em = factory.createEntityManager();
		
		
//		em.getTransaction().begin();
//		
//		
//		Registro r1= new Registro(10, "Registro 10");
//		em.persist(r1);
//		Cliente c1 = new Cliente(1,"Luis Ramos",r1);
//		em.persist(c1);
//		
//		
//		em.getTransaction().commit();
		
		Cliente c = em.find(Cliente.class, 1);
		System.out.printf("El cliente %s tiene el reg %s", c.getNombre(),c.getRegistro().getNombre());

	}

}
