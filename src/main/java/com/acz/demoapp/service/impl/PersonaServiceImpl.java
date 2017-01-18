package com.acz.demoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acz.demoapp.dao.PersonaDao;
import com.acz.demoapp.domain.Persona;
import com.acz.demoapp.service.PersonaService;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaDao personaDao;
	
	public void insert(Persona p)throws Exception{
		personaDao.insert(p);
	}

	public List<Persona> findAll() throws Exception{
		return personaDao.findAll();
	}
	
	public Persona findById(long id)throws Exception{
		return personaDao.findById(id);
	}
	
	public void update(Persona p)throws Exception{
		personaDao.update(p);
	}
	
	public void deleteById(long id)throws Exception{
		personaDao.deleteById(id);
	}
	public void deleteAll()throws Exception{
		personaDao.deleteAll();
	}
}


