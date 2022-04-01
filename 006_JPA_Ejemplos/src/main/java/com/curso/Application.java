package com.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.dao.ProductoDAOImp;
import com.curso.domain.Producto;
import javax.persistence.Query;
import java.util.List;

public class Application
{
	public static void main( String[] args )
	{
		
		
		
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		EntityManager em = factory.createEntityManager();
//		
//		
////		em.getTransaction().begin();
////		Producto p = new Producto("P1","calcetines",12.7);
////		
////		em.persist(p);
////		
////		em.getTransaction().commit();
//		
////		
//		
//		
////		em.getTransaction().begin();
////		Producto p = em.find(Producto.class, "P1");
////		
////		if(p == null) {
////			System.out.println(" el producto no existe");
////		}else {
////			System.out.println(p);
////		}
////		
////		
////		
////		Producto p2 = em.find(Producto.class, "P2");
////		
////		System.out.println("precio ahora es "+p2.getPrecio());
////		
////		p2.setPrecio(650);
////		em.getTransaction().commit();
//		
//		
////		em.getTransaction().begin();
////		Producto p = em.find(Producto.class, "P1");
////
////		if (p != null) {
////			em.remove(p);
////		}
////
////		em.getTransaction().commit();
////		
//		
//		
//		
//		em.getTransaction().begin();
//		Producto p = new Producto("P2","calcetin rojo",5.7);
//		
//		Producto p2=em.merge(p);
//		
//		em.getTransaction().commit();
//		
		
//		
//		ProductoDAOImp dao = new ProductoDAOImp();
//		Producto p= new Producto("P8","iphone",1000);
//		Producto p2= new Producto("P8","iphone 12",1000);
//		dao.create(p);
//		
//		dao.getById("P8");
//		
//		dao.update(p2);
//		
//		dao.delete("P2");

		
		// JPA QUERYS
				String querySQL = "SELECT * FROM HR.PRODUCTOS";  // tablas y sus columnas
				// SELECT ID_PRODUCTO FROM PRODUCTOS
				
				String queryJPA = "SELECT  p  FROM Producto p "; // clases y sus atributos
				String queryJPA2 = "SELECT p.idProducto FROM Producto p";  
				
				Query query = em.createQuery(queryJPA);
				
				List<Producto> productos = query.getResultList();
				
				for(Producto p : productos) {
					System.out.println(p);
				}
				
				//QUERY NATIVA  
				Query queryNativa = em.createNativeQuery(querySQL);
				
				List<Object> list  = queryNativa.getResultList();
			
				//NAMED QUERIES
				
				Query queryPrecio = em.createNamedQuery("Producto.findPrecioMenorQue");
				queryPrecio.setParameter("precioMaximo", 10.0);
				
				List<Producto> listaProdPreciosMenor = queryPrecio.getResultList();
				System.out.println("productos con precio menor que 10");
				for(Producto p : listaProdPreciosMenor) {
					System.out.println(p);
				}
				
				em.getTransaction().begin();
				
				String updatePrecios = "UPDATE  Producto p SET p.precio = p.precio  + 0.1";
				int contador = em.createQuery(updatePrecios).executeUpdate();
				
				System.out.println("mofifico precios de " + contador);
				em.getTransaction().commit();
				
				// yo API JPA   
				// orm  hibernate monta query  - API JDBC
				// driver oracle
				// bd oracle xe
		
		
		
	}
}