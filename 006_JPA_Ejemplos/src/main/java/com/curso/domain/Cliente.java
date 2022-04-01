package com.curso.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "HR", name = "CUSTOMER")
public class Cliente implements Serializable {
	
	@Id
	private Integer id;
	
	@Column(name = "CUSTOMER_NAME")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="CUSTRECORD_RECID")
	private Registro registro;
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String nombre, Registro registro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.registro = registro;
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

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", registro=" + registro + "]";
	}
	
	
}
