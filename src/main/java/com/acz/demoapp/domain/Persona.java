package com.acz.demoapp.domain;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 796077709099751126L;

	private Integer id;
	private String nombre;
	private String email;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Persona(Integer id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
