package com.acz.demoapp.service;

import java.util.List;

import com.acz.demoapp.domain.Persona;

public interface PersonaService {
	
	public void insert(Persona p)throws Exception;
	public List<Persona> findAll()throws Exception;
	public Persona findById(long id)throws Exception;
	public void update(Persona p)throws Exception;
	public void deleteById(long id)throws Exception;
	public void deleteAll()throws Exception;

}
