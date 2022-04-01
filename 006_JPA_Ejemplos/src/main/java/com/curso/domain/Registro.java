package com.curso.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "HR", name = "RECORD")
public class Registro implements Serializable {
	
	@Id
	@Column(name = "RECID")
	private Integer id;
	
	@Column(name = "RECORD_NAME")
	private String nombre;
	
	@OneToOne(mappedBy = "registro")
	private Cliente cliente;
	
	public Registro() {
		
	}

	public Registro(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", nombre=" + nombre + ", cliente=" + cliente + "]";
	}

	
	
}
