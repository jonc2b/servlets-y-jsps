package com.curso.services;

import java.util.List;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.services.excepciones.ProductosException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	@Qualifier("JpaProductoRepository")
	private ProductoRepository repositorio;

	@Override
	public Producto getProducto(String idProducto) throws ProductosException {
		Producto p = repositorio.getProducto(idProducto);
		if (p == null) {
			throw new ProductosException("El producto no existe", idProducto);
		}
		return p;
	}

	@Override
	public List<Producto> getAllProductos() {
		return repositorio.getAllProductos();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void crearProducto(Producto producto) throws ProductosException {

		if (producto == null) {
			throw new ProductosException("Debes pasar un producto. No puede ser null", "Null");
		}
		if (repositorio.getProducto(producto.getIdProducto()) != null) {
			throw new ProductosException("No se puede crear. El producto ya existe", producto.getIdProducto());
		}
		repositorio.create(producto);

	}

	@Override
	public List<Producto> getAllCategoria(String categoria) {
		return repositorio.getProductosCategoria(categoria);
	}

}
