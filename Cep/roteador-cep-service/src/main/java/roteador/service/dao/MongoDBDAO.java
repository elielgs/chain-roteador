package roteador.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;

import roteador.core.dao.InterfaceDAO;
import roteador.core.exception.dao.DeleteException;
import roteador.core.exception.dao.FindException;
import roteador.core.exception.dao.UpdateException;

public class MongoDBDAO<T> implements RoteadorMongoDBDAOInterface<T> {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public T insert(T objeto) throws UpdateException, DataAccessException, FindException {
		mongoTemplate.insert(objeto);
		return objeto;
	}

	@Override
	public T update(T objeto) throws UpdateException, DataAccessException, FindException {
		return null;
	}

	@Override
	public void remove(T objeto) throws DeleteException {
		mongoTemplate.remove(objeto);
		
	}

	@Override
	public T findById(Class<T> klass, Object chave) throws FindException {
		return mongoTemplate.findById(chave, klass);
	}

	@Override
	public List<T> findAll(Class<T> klass) throws FindException {
		return mongoTemplate.findAll(klass);
	}

	@Override
	public void dropCollection(Class<T> klass) {
		mongoTemplate.dropCollection(klass);
	}
}
