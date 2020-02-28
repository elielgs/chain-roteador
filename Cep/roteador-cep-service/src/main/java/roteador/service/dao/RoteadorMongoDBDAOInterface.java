package roteador.service.dao;

import roteador.core.dao.InterfaceDAO;

public interface RoteadorMongoDBDAOInterface<T> extends InterfaceDAO<T> {

	void dropCollection(Class<T> klass);
	
}
