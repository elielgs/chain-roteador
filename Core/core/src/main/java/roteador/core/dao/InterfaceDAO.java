package roteador.core.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import roteador.core.exception.dao.DeleteException;
import roteador.core.exception.dao.FindException;
import roteador.core.exception.dao.UpdateException;

public interface InterfaceDAO <T> {


    T insert(T objeto) throws UpdateException, DataAccessException, FindException;
    
    T update(T objeto) throws UpdateException, DataAccessException, FindException;

    void remove(T objeto) throws DeleteException;

    T findById(Class<T> klass, Object chave) throws FindException;

	List<T> findAll(Class<T> klass) throws FindException;

}