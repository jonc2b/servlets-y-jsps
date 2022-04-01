package com.curso.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.services.ProductoService;
import com.curso.services.excepciones.ProductosException;

@RestController
public class ProductosRESTController {

	@Autowired
	@Qualifier("JpaProductoRepository")
	private ProductoRepository repositorio;
	

	//leer todos
	@GetMapping("/rest/productos")
	public List<Producto> all(){
		return repositorio.getAllProductos();
	}
	
	@GetMapping("/rest/productos/{id}")
	public Producto verProducto(@PathVariable("id")String idProducto) throws ProductosException {
		return repositorio.getProducto(idProducto);
	}
	
	@PostMapping("/rest/productos")
	public Producto crear(@RequestBody Producto nuevoProducto) {
		repositorio.create(nuevoProducto);
		return nuevoProducto;
	}
	
	@PutMapping("/rest/productos/{id}")
	public Producto modificar(@RequestBody Producto producto,@PathVariable("id")String idProducto) throws ProductosException {
		repositorio.update(producto);
		return producto;
	}
	
	@DeleteMapping("/rest/productos/{id}")
	public void borrar(@PathVariable("id")String idProducto) throws ProductosException {
		repositorio.delete(idProducto);
		
	}
	
}
