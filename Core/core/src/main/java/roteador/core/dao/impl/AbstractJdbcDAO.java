package roteador.core.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import roteador.core.dao.InterfaceDAO;

/**
 * 
 * @author Mauricio Santos
 *
 */
public abstract class AbstractJdbcDAO <T> extends JdbcDaoSupport implements InterfaceDAO<T> {

	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	public List<T> populateList(SqlRowSet rs) {
 		List<T> retorno = new ArrayList<T>();
		if (rs.isFirst() && rs.isLast()) {
			return retorno;
		}
		while (!rs.isAfterLast()) {
			T t = populateTO(rs);
			if(t != null){
				retorno.add(t);
			}
		}
		return retorno;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	protected abstract T populateTO(SqlRowSet rs);
}
