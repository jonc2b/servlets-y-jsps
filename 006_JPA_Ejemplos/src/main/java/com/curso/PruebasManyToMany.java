package com.curso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.domain.onetomany.Customer;
import com.curso.domain.onetomany.Orders;
import com.curso.domain.Registro;
import com.curso.domain.manytomany.Contacto;
import com.curso.domain.manytomany.Grupo;

public class PruebasManyToMany {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		EntityManager em = factory.createEntityManager();
		
		
		em.getTransaction().begin();
//	   Grupo g1 = new Grupo(null,"azul","grupo1");
//	   em.persist(g1);
//	   Grupo g2 = new Grupo(null,"rojo","grupo2");
//	   em.persist(g2);
//	   Grupo g3 = new Grupo(null,"verde","grupo3");
//	   em.persist(g3);
//       Contacto c1= new Contacto(null,"jon","rodriguez","dfgdfgfd@gmail.com",new Date());
//       c1.setGrupoCollection(new ArrayList<Grupo>());
//       c1.getGrupoCollection().add(g1);
//       c1.getGrupoCollection().add(g2);
//		
//       
//		em.persist(c1);
//		
//        em.getTransaction().commit();
//       
		 Grupo g = em.find(Grupo.class, 4);
		 System.out.println("listar contactos grupo 4");
		 for(Contacto c : g.getContactoCollection()) {
			 System.out.println(c.getNombre());
		 }
		 
		 Contacto c = em.find(Contacto.class, 2);
		 System.out.println("listar Grupos del contacto 2");
		 for(Grupo gru : c.getGrupoCollection()) {
			 System.out.println(gru.getNombre());
		 }
		 

	}

}
