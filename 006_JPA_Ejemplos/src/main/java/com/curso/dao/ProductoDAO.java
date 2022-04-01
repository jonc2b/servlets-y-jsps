package com.curso.dao;

import com.curso.domain.Producto;

public interface ProductoDAO {

	void create(Producto p);
	void update (Producto p);
	void delete (String idProducto);
	void getById(String idProducto);
	
}
