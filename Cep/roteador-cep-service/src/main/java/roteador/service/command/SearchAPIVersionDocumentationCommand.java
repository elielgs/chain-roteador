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
import roteador.entities.ApiDTO;

public class SearchAPIVersionDocumentationCommand extends AbstractCMSConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("cache-control", "no-cache");
		headers.set("postman-token", "29a7b988-6e94-5648-2828-445eaea42320");
	 
		ApiDTO apiDTO = (ApiDTO)context.get(ContextKey.API_DTO);
		String idAPI = (String)context.get(ContextKey.API_ID);	
		StringBuffer uri = new StringBuffer();
		uri.append("/docs/").append(idAPI).append("/").append(apiDTO.getApiVersionDTO().getVersion()).append("?_format=json");
		
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	 
	    ResponseEntity<APIVersionDocumentationDTO[]> result = super.send(uri.toString(), HttpMethod.GET, requestEntity, APIVersionDocumentationDTO[].class);
	    
	    APIVersionDocumentationDTO apiVersionDocumentationDTO = result.getBody()[0];
	    apiDTO.setApiVersionDocumentationDTO(apiVersionDocumentationDTO);
		return true;
	}

}
