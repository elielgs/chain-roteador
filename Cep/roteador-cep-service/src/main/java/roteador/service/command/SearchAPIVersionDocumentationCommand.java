package roteador.service.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import roteador.core.constants.ContextKey;
import roteador.entities.APIVersionDocumentationDTO;

public class SearchAPIVersionDocumentationCommand extends AbstractCMSConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("cache-control", "no-cache");

		String idAPI = (String)context.get(ContextKey.API_ID);
		String version = (String)context.get(ContextKey.DOCUMENTATION_VERSION);
		StringBuffer uri = new StringBuffer();
		uri.append("/docs/").append(idAPI).append("/").append(version).append("?_format=json");
		
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	 
	    ResponseEntity<APIVersionDocumentationDTO> result = super.send(uri.toString(), HttpMethod.GET, requestEntity, APIVersionDocumentationDTO.class);
	    
	    APIVersionDocumentationDTO apiVersionDocumentationDTO = result.getBody();
	    context.put(ContextKey.DOCUMENTATION_VERSION, apiVersionDocumentationDTO);
		return apiVersionDocumentationDTO != null;
	}

}
