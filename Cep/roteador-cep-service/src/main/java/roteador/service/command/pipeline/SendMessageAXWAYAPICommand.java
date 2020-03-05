package roteador.service.command.pipeline;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Context;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import roteador.core.constants.ContextKey;
import roteador.core.constants.ParamHelper;
import roteador.service.command.AbstractAPIConnectionCommand;

public class SendMessageAXWAYAPICommand extends AbstractAPIConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {

		Map<String, String> parameters = (Map<String, String>)context.get(ContextKey.PARAMS);
		String url = ParamHelper.getParam("url", parameters, context,  Boolean.TRUE);
		String method = ParamHelper.getParam("method", parameters, context,  Boolean.TRUE);
		String queryParamsParameter = ParamHelper.getParam("params", parameters, context,  Boolean.FALSE);
		String contentType = ParamHelper.getParam("contentType", parameters, context,  Boolean.FALSE);
		
		HttpHeaders headers = new HttpHeaders();
		if (contentType != null) {
			headers.set("Content-Type", contentType);	
		}
	 
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	    Map<String, String> queryParamsMap = new HashMap<String, String>();
	    
	    if (queryParamsParameter != null) {
	    	String[] parametersContextArray = queryParamsParameter.split(",");
	    	for (int i = 0; i < parametersContextArray.length; i++) {
	    		queryParamsMap.put(parametersContextArray[i].toLowerCase(), (String)context.get(ContextKey.valueOf(parametersContextArray[i])));
	    	}
	    }
	    
	    ResponseEntity<String> result = super.send(url, HttpMethod.valueOf(method), requestEntity, queryParamsMap, String.class);
		if (result.getStatusCode() == HttpStatus.OK) {
			context.put(ContextKey.API_JSON, result.getBody());
		}
	    
	    return result.getStatusCode() == HttpStatus.OK;
	}

}
