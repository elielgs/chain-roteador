package roteador.cep.service.dao.jdbc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import roteador.core.exception.dao.FindException;

public class CepJdbcDAO {

	public Map<String, String> listByCep(String cep) throws FindException {
		StringBuffer sql = new StringBuffer();
		 Map<String, String> cepMap = null;
		
		
		return cepMap;
	}
	
	public List<String> getAllUf() throws FindException {
		StringBuffer sql = new StringBuffer();
		 List<String> ufList = new ArrayList<String>();
		
		
		return ufList;
	}
	
	public List<String> listCityByUf(String uf) throws FindException {
		StringBuffer sql = new StringBuffer();
		 List<String> cityList = new ArrayList<String>();
		
		
		return cityList;
	}
	
}
