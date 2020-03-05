package roteador.service.command;

import org.apache.commons.chain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import roteador.core.constants.ContextKey;
import roteador.entities.APIVersionDocumentationDTO;

public class SearchDocumentationVersionCommand extends AbstractAPIConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("cache-control", "no-cache");
	 
		String idAPI = (String)context.get(ContextKey.API_ID);	
		String version = (String)context.get(ContextKey.API_VERSION);
		StringBuffer uri = new StringBuffer();
		uri.append("/api/docs/").append(idAPI).append("/").append(version);
		
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	 
	    ResponseEntity<String> result = super.send(uri.toString(), HttpMethod.GET, requestEntity, null, String.class);
	    
	    String documentationVersion = result.getBody();
	    context.put(ContextKey.DOCUMENTATION_VERSION, documentationVersion);
		return documentationVersion != null;
	}

}
