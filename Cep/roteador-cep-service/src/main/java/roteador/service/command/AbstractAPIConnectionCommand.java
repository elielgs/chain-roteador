package roteador.service.command;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import roteador.service.domain.ApiDTO;

@ImportResource("application.properties")
public abstract class AbstractAPIConnectionCommand implements Command {

	@Value("${axway.url}")
	private String domain;
	@Value("${axway.port}")
	private String port;
	@Autowired
	private RestTemplate restTemplate;
	
	protected <T> ResponseEntity<T> send(String uri, HttpMethod httpMethod, HttpEntity<String> requestEntity,
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

		ResponseEntity<T> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity,
				responseType);
		return result;
	}
}