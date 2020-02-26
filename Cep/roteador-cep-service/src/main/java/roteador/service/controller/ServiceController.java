package roteador.service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import roteador.chain.Chain;
import roteador.core.ContextECatalogue;
import roteador.core.constants.ECatalogueContextKey;
import roteador.core.exception.command.CommandException;
import roteador.service.ServiceMain;

@RestController
public class ServiceController {
	
	@RequestMapping(value="/buscarapi/{id}", method = RequestMethod.GET)
	public String buscarDescricao(@PathVariable("id") String id) {

		String retorno = "";
		Chain chain = (Chain)ServiceMain.getApplicationContext().getBean("Chain");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ECatalogueContextKey.TRANSACTION.getChave(), "findAPIById");
		contextEcatalogue.put(ECatalogueContextKey.API_ID, id);
		contextEcatalogue.put(ECatalogueContextKey.JSON_PARSE_FROM_OBJECT, ECatalogueContextKey.API_DTO);
		try {
			chain.execute(contextEcatalogue);
			retorno = (String)contextEcatalogue.get(ECatalogueContextKey.JSON_OBJECT);
		} catch (CommandException e) {
			retorno = e.getMensagem().getChave();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
