package roteador.cep.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import roteador.chain.Chain;
import roteador.core.ContextECatalogue;
import roteador.core.constants.ECatalogueContextKey;
import roteador.core.exception.command.CommandException;

@SpringBootApplication
@RestController
@ImportResource({"classpath*:applicationContext-roteador-cep-service.xml"})
public class CepServiceMain {
	
	private ApplicationContext appCtx;
	
	public CepServiceMain() {
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CepServiceMain.class, args);
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			appCtx = ctx;
		};
	}
	
	@RequestMapping(value="/buscarCEP/{cep}", method = RequestMethod.GET)
	public String buscarCEP(@PathVariable("cep") String cep) {
		
		String retorno = "CEP inválido";
		Chain chain = (Chain)appCtx.getBean("Chain");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ECatalogueContextKey.TRANSACTION.getChave(), "findCep");
		contextEcatalogue.put(ECatalogueContextKey.CEP, cep);
		try {
			chain.execute(contextEcatalogue);
			retorno = (String)contextEcatalogue.get(ECatalogueContextKey.MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}
