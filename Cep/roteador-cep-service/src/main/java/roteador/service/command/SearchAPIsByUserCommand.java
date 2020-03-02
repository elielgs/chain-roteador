package roteador.service.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.chain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import roteador.core.constants.ContextKey;
import roteador.entities.ApiDTO;
import roteador.service.mongo.model.MembroOrganizacao;

public class SearchAPIsByUserCommand extends AbstractAPIConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {
		MembroOrganizacao membroOrganizacao = (MembroOrganizacao)context.get(ContextKey.MEMBRO_ORGANIZACAO);
		List<ApiDTO> apisList = new ArrayList<ApiDTO>();
		
		String[] apisNames = membroOrganizacao.getApis();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
	 
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	    Map<String, String> params = new HashMap<String, String>();
	    
		
		for (int i = 0; i< apisNames.length; i++) {
			String apiName = apisNames[i];
			params.put("nomeAPI", apiName);
			ResponseEntity<ApiDTO> result = super.send("/buscaapis/listaApis", HttpMethod.GET, requestEntity, params, ApiDTO.class);
		    apisList.add(result.getBody());
		}
		context.put(ContextKey.API_LIST, apisList);
		return false;
	}
}