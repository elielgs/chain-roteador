package roteador.core.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import roteador.core.exception.dao.DeleteException;
import roteador.core.exception.dao.FindException;
import roteador.core.exception.dao.UpdateException;

public interface InterfaceDAO {


    Object insert(Object objeto) throws UpdateException, DataAccessException, FindException;
    
    Object update(Object objeto) throws UpdateException, DataAccessException, FindException;

    void remove(Object objeto) throws DeleteException;

    Object findById(Class<?> klass, Object chave) throws FindException;

	List<?> findAll(Class<?> klass) throws FindException;

}