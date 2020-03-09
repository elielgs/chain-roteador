package roteador.service.command.pipeline;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import roteador.core.constants.ContextKey;
import roteador.entities.ApiDTO;

public class SearchAPIsListByAPIsNamesCommand extends SendMessageAXWAYAPICommand {

	@SuppressWarnings("unchecked")
	@Override
	public boolean execute(Context context) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
	 
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	    Map<String, String> params = new HashMap<String, String>();
	 
	    ResponseEntity<ApiDTO[]> result = super.send("/apis/list", HttpMethod.GET, requestEntity, params, ApiDTO[].class);
	    context.put(ContextKey.API_LIST, result.getBody());
	    return true;
	}

	@Override
	protected String getDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getPort() {
		// TODO Auto-generated method stub
		return null;
	}

}
