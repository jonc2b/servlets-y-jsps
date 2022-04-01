package com.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.domain.onetomany.Customer;
import com.curso.domain.onetomany.Orders;
import com.curso.domain.Registro;

public class PruebasOneToMany {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		EntityManager em = factory.createEntityManager();
		
		
		em.getTransaction().begin();
	       
        //1 crear el cliente con el id 2
       
        Customer customer = new Customer(2, "Carlos López");
       
       // em.persist(customer);
      
       
       //2 añadir dos pedidos a  cada cliente
      
       // creo 2 pedidos para clietne 2
       
//      Orders o1 = new Orders(1, "Compra 2 ruedas de repuesto");
//       Orders o2 = new Orders(2, "Compra 1 retrovisor");
//       
//        o1.setCustomer(customer);
//        o2.setCustomer(customer);
      
       // em.persist(o1);
       // em.persist(o2);
      
       //crear 1 pedido para el cliente 2
      
//        Customer c = em.find(Customer.class, 2);
//        Orders o3 = new Orders(3, "Compra 50 cuadernos");
//        o3.setCustomer(c);
//     
//        em.persist(o3);
        
        
        Orders pedido3 = em.find(Orders.class, 3);
        System.out.printf("El pedido 3 es %s del cliente %s", pedido3.getDescription(),pedido3.getCustomer().getCustomerName());
        
        Customer c = new Customer(null,"jon rodriguez");
        em.persist(c);
        em.getTransaction().commit();
       
        

	}

}
