package roteador.service.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import roteador.core.constants.ContextKey;
import roteador.entities.APIVersionDTO;
import roteador.entities.ApiDTO;

public class SearchAPIVersionCommand extends AbstractAPIConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {
		String idAPI = (String)context.get(ContextKey.API_ID);
		StringBuffer uri = new StringBuffer();
		uri.append("/api/version/").append(idAPI.toLowerCase());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
	 
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	    Map<String, String> params = new HashMap<String, String>();
	 
	    ResponseEntity<APIVersionDTO[]> result = super.send(uri.toString(), HttpMethod.GET, requestEntity, params, APIVersionDTO[].class);
	    APIVersionDTO[] apiVersionDTOList = null;
	     
	    if( result.getStatusCode() == HttpStatus.OK) {
		    apiVersionDTOList = result.getBody();
			context.put(ContextKey.API_VERSION_LIST, apiVersionDTOList);
	    }
	    
		return apiVersionDTOList != null;
	}

}
