package com.acz.demoapp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acz.demoapp.dao.PersonaDao;
import com.acz.demoapp.domain.Persona;

@Repository("personaDao")
public class PersonaDaoImpl implements PersonaDao{
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public void insert(Persona p)throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("personaXml.insert", p);		
		}
		finally{
			session.commit();
			session.close();
		}
	}

	public List<Persona> findAll() throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<Persona> lst =null;
		try {
			lst = session.selectList("personaXml.findAll");			
		}
		finally{
			session.close();
		}
		return lst;
	}
	public Persona findById(long id)throws Exception{
		Persona prov = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	prov = session.selectOne("personaXml.findById",id);
        } finally {
            session.close();
        }
		return prov;
	}
	
	public void update(Persona p)throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("personaXml.update", p);		
		}
		finally{
			session.commit();
			session.close();
		}
	}
	public void deleteById(long id)throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("personaXml.deleteById", id);		
		}
		finally{
			session.commit();
			session.close();
		}
	}
	public void deleteAll()throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("personaXml.deleteAll");		
		}
		finally{
			session.commit();
			session.close();
		}
	}
}
