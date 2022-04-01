package com.curso.services;

import com.curso.services.excepciones.PedidosException;

public interface PedidosService {

	public void hacerPedido(String idProducto, int cantidad)throws PedidosException;
}
