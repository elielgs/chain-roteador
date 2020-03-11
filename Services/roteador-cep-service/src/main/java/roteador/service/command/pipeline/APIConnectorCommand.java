package roteador.service.command.pipeline;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import roteador.core.constants.ContextKey;
import roteador.core.constants.ParamHelper;


@ImportResource("application.properties")
public class APIConnectorCommand implements Command {


	@Autowired
	private RestTemplate restTemplate;
	
	public boolean execute(Context context) throws Exception {
		Map<String, String> parameters = (Map<String, String>)context.get(ContextKey.PARAMS);
		String domain = (String)ParamHelper.getParam("domain", parameters, context,  Boolean.TRUE);
		String port = (String)ParamHelper.getParam("port", parameters, context,  Boolean.TRUE);
		String url = (String)ParamHelper.getParam("url", parameters, context,  Boolean.TRUE);
		String method = (String)ParamHelper.getParam("method", parameters, context,  Boolean.TRUE);
		Map<String,String> queryParametersMap = (Map<String, String>)ParamHelper.getParam("queryParameters", parameters, context,  Boolean.FALSE);
		
		String contentType = (String)ParamHelper.getParam("contentType", parameters, context,  Boolean.FALSE);
		
		HttpHeaders headers = new HttpHeaders();
		if (contentType != null) {
			headers.set("Content-Type", contentType);	
		}
	 
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	    Map<String, String> queryParamsMap = new HashMap<String, String>();
	    
	    if (queryParametersMap != null) {
	    	Iterator<Entry<String,String>> iterator = queryParametersMap.entrySet().iterator();
	    	
	    	while(iterator.hasNext()) {
	    		Entry<String, String> entry = iterator.next();
	    		queryParamsMap.put(entry.getKey(), entry.getValue());
	    	}
	    } else {
	    	List<String> queryParametersList = (List<String>)ParamHelper.getParam("queryParametersList", parameters, context,  Boolean.FALSE);
	    	if (queryParametersList != null) {
	    		String queryParameterListAttributeName = (String)ParamHelper.getParam("queryParameterListAttributeName", parameters, context,  Boolean.TRUE);
	    		queryParamsMap.put(queryParameterListAttributeName, queryParametersList.toString().replace('[',  ' ').replace(']', ' ').replaceAll(" ",""));
	    	}
	    }
	    
	    ResponseEntity<String> result = send(domain, port, url, HttpMethod.valueOf(method.toUpperCase()), requestEntity, queryParamsMap, String.class);
		if (result.getStatusCode() == HttpStatus.OK) {
			context.put(ContextKey.JSON, result.getBody());
		}
	    
	    return result.getStatusCode() == HttpStatus.OK;
	}

	
	protected <T> ResponseEntity<T> send(String domain, 
			String port, 
			String uri, HttpMethod httpMethod, HttpEntity<String> requestEntity,
			Map<String, String> params, Class<T> responseType) throws URISyntaxException {

		StringBuffer url = new StringBuffer();
		url.append(domain);
		url.append(":");
		url.append(port);
		url.append(uri);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url.toString());
		if (params != null && !params.isEmpty()) {
			Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> valor = iterator.next();
				builder = builder.queryParam(valor.getKey(), valor.getValue());
			}
		}

		ResponseEntity<T> result = restTemplate.exchange(builder.toUriString(), httpMethod, requestEntity,
				responseType);
		return result;
	}
	
}