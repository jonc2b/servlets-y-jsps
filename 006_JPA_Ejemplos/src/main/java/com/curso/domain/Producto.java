package com.curso.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema = "HR" ,name = "PRODUCTOS")
//lista todas las consultas que trabajan con productos
@NamedQueries({
	@NamedQuery(name= "Producto.findAll", query = "SELECT p FROM Producto p"),
	@NamedQuery(name= "Producto.findPrecioMenorQue", 
	             query = "SELECT p FROM Producto p WHERE p.precio < :precioMaximo")
})
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_PRODUCTO")
	private String idProducto;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "PRECIO")
	private double precio;
	
	@Transient
	private boolean seleccionado;
	
	public Producto() {
		
	}
	public Producto(String idProducto, String nombre, double precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	
	
}
