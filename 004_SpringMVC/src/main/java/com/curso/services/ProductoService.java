package com.curso.services;

import java.util.List;

import com.curso.domain.Producto;
import com.curso.services.excepciones.ProductosException;

public interface ProductoService {

	Producto getProducto(String idProducto)throws ProductosException;
	public List<Producto> getAllProductos();
	public void crearProducto(Producto producto)throws ProductosException;
	public List<Producto> getAllCategoria(String categoria);
}
