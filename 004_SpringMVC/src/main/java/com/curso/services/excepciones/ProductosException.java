package com.curso.services.excepciones;

public class ProductosException extends Exception {

	private String idProducto;
	
	public ProductosException(String mensaje, String idProducto) {
		super(mensaje);
		this.idProducto= idProducto;
	}
	
	public String getIdProducto() {
		return idProducto;
	}
}
