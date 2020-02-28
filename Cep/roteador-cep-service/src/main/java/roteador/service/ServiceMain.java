package roteador.service;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import roteador.chain.Chain;
import roteador.core.ContextECatalogue;
import roteador.core.constants.ContextKey;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext-roteador-service.xml"})
public class ServiceMain {
	
	private static ApplicationContext appCtx;
	
	public ServiceMain() {
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServiceMain.class, args);
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			appCtx = ctx;
		};
	}
	
	@Bean
    public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        return restTemplate;
	}
	
	public static ApplicationContext getApplicationContext() {
		return appCtx;
	}
	
}
