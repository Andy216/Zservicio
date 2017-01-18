package com.acz.demoapp.util;

import org.springframework.http.HttpStatus;

public class Respuesta {
	
	private HttpStatus codigo;
	private String detalle;
	
	public Respuesta() {
		super();
	}

	public Respuesta(HttpStatus codigo, String detalle) {
		super();
		this.codigo = codigo;
		this.detalle = detalle;
	}

	public HttpStatus getCodigo() {
		return codigo;
	}
	public void setCodigo(HttpStatus codigo) {
		this.codigo = codigo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Respuesta [codigo=" + codigo + ", detalle=" + detalle + "]";
	}

}
