package roteador.service.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import roteador.core.constants.ECatalogueContextKey;
import roteador.entities.APIVersionDTO;
import roteador.entities.ApiDTO;

public class SearchAPIVersionCommand extends AbstractAPIConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {
		ApiDTO apiDTO = (ApiDTO)context.get(ECatalogueContextKey.API_DTO);
		String idAPI = (String)context.get(ECatalogueContextKey.API_ID);
		StringBuffer uri = new StringBuffer();
		uri.append("/api/").append(idAPI).append("/versao");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
	 
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	    Map<String, String> params = new HashMap<String, String>();
	 
	    ResponseEntity<APIVersionDTO> result = super.send(uri.toString(), HttpMethod.GET, requestEntity, params, APIVersionDTO.class);
		APIVersionDTO apiVersionDTO = result.getBody();
		apiDTO.setApiVersionDTO(apiVersionDTO);
		return true;
	}

}
