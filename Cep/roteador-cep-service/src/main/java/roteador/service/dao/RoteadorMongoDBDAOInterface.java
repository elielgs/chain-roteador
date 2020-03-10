package roteador.service.dao;

import roteador.core.dao.InterfaceDAO;

public interface RoteadorMongoDBDAOInterface extends InterfaceDAO {

	void dropCollection(Class<?> klass);
	
}
