package roteador.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;

import roteador.core.dao.InterfaceDAO;
import roteador.core.exception.dao.DeleteException;
import roteador.core.exception.dao.FindException;
import roteador.core.exception.dao.UpdateException;

public class MongoDBDAO implements RoteadorMongoDBDAOInterface {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Object insert(Object objeto) throws UpdateException, DataAccessException, FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Object objeto) throws UpdateException, DataAccessException, FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object objeto) throws DeleteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(Class<?> klass, Object chave) throws FindException {
		return mongoTemplate.findById(chave, klass);
	}

	@Override
	public List<?> findAll(Class<?> klass) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dropCollection(Class<?> klass) {
		// TODO Auto-generated method stub
		
	}


}
