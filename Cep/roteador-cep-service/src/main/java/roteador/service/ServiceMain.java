package roteador.service;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import roteador.chain.Chain;
import roteador.chain.pipeline.Pipeline;
import roteador.chain.processo.Excecao;
import roteador.chain.processo.Resultado;
import roteador.chain.processo.pipeline.CommandConfiguration;
import roteador.chain.processo.pipeline.PipelineConfiguration;
import roteador.core.ContextECatalogue;
import roteador.core.constants.ContextKey;
import roteador.entities.ApiDTO;
import roteador.entities.ReturnDTO;

@SpringBootApplication
@ImportResource({ "classpath*:applicationContext-roteador-service.xml" })
public class ServiceMain {

	private static ApplicationContext appCtx;

	public ServiceMain() {
	}

	public static <E> void main(String[] args) throws Exception {
//		PipelineConfiguration pipelineConfiguration = new PipelineConfiguration();
//		CommandConfiguration commandConfiguration = new CommandConfiguration();
//		commandConfiguration.setComponentJSONFilename("arquivo1");
//		CommandConfiguration commandConfiguration2 = new CommandConfiguration();
//		commandConfiguration2.setComponentJSONFilename("arquivo2");
//		List<CommandConfiguration> list = new LinkedList<CommandConfiguration>();
//		list.add(commandConfiguration);
//		list.add(commandConfiguration2);
//		pipelineConfiguration.setCommandsConfiguration(list);
//		
//		Gson gson = new Gson();
//		String pipelineConfigurationJSON = gson.toJson(pipelineConfiguration);
//		System.out.println(pipelineConfigurationJSON);
//		
//		PipelineConfiguration pipelineConfiguration2 = gson.fromJson(pipelineConfigurationJSON, PipelineConfiguration.class);
//		Iterator<CommandConfiguration> iterator = pipelineConfiguration2.getCommandsConfiguration().iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next().getComponentJSONFilename());
//		}
		
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
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		return restTemplate;
	}

	public static ApplicationContext getApplicationContext() {
		return appCtx;
	}

}
