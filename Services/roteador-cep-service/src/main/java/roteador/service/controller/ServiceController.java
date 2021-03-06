package roteador.service.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import roteador.chain.Chain;
import roteador.chain.pipeline.Pipeline;
import roteador.core.ContextECatalogue;
import roteador.core.constants.ContextKey;
import roteador.core.constants.Transaction;
import roteador.core.exception.command.CommandException;
import roteador.entities.APIVersionDTO;
import roteador.entities.APIVersionDocumentationDTO;
import roteador.entities.ApiDTO;
import roteador.entities.ReturnDTO;
import roteador.service.ServiceMain;

@RestController
public class ServiceController {
	
	@RequestMapping(value="/salvarorganizacoes", method = RequestMethod.GET)
	public String salvarOrganizacoes() {

		String retorno = "";
		Chain chain = (Chain)ServiceMain.getApplicationContext().getBean("Chain");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ContextKey.TRANSACTION.getChave(), Transaction.SALVAR_ORGANIZACOES.getChave());
		try {
			chain.execute(contextEcatalogue);
		} catch (CommandException e) {
			retorno = e.getMensagem().getChave();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/api/list", method = RequestMethod.GET)
	public ResponseEntity<ReturnDTO<ApiDTO[]>> listApis(@RequestParam String email) {

		ReturnDTO<ApiDTO[]> returnDTO = new ReturnDTO<ApiDTO[]>();
		HttpStatus httpStatusReturn = HttpStatus.OK;
		Pipeline chain = (Pipeline)ServiceMain.getApplicationContext().getBean("Pipeline");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ContextKey.TRANSACTION.getChave(), Transaction.FIND_APIS_BY_USER.getChave());
		contextEcatalogue.put(ContextKey.EMAIL, email);
		try {
			chain.execute(contextEcatalogue);
			ApiDTO[] body = (ApiDTO[])contextEcatalogue.get(ContextKey.PARSED_JSON);
			returnDTO.setBody(body);
		} catch (CommandException e) {
			returnDTO.setMessage(e.getMensagem().getChave());
			httpStatusReturn = HttpStatus.NO_CONTENT;
			e.printStackTrace();
		} catch (Exception e) {
			returnDTO.setMessage(e.getMessage());
			httpStatusReturn = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		
		return ResponseEntity.status(httpStatusReturn).body(returnDTO);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/api/version/{id}", method = RequestMethod.GET)
	public ResponseEntity<ReturnDTO<APIVersionDTO[]>> apiVersion(@PathVariable String id,
			@RequestParam(required = false) String status) {

		ReturnDTO<APIVersionDTO[]> returnDTO = new ReturnDTO<APIVersionDTO[]>();
		HttpStatus httpStatusReturn = HttpStatus.OK;
		Pipeline pipeline = (Pipeline)ServiceMain.getApplicationContext().getBean("Pipeline");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ContextKey.TRANSACTION.getChave(), Transaction.FIND_APIS_VERSION_BY_ID.getChave());
		contextEcatalogue.put(ContextKey.URL, "/api/version/" + id);
		
		if (status != null) {
			contextEcatalogue.put(ContextKey.API_VERSION_STATUS_LIST, status);
		}

		try {
			pipeline.execute(contextEcatalogue);
			APIVersionDTO[] body = (APIVersionDTO[])contextEcatalogue.get(ContextKey.PARSED_JSON);
			returnDTO.setBody(body);
		} catch (CommandException e) {
			returnDTO.setMessage(e.getMensagem().getChave());
			httpStatusReturn = HttpStatus.NO_CONTENT;
			e.printStackTrace();
		} catch (Exception e) {
			returnDTO.setMessage(e.getMessage());
			httpStatusReturn = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		
		return ResponseEntity.status(httpStatusReturn).body(returnDTO);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/testpipeline", method = RequestMethod.GET)
	public ResponseEntity<ReturnDTO<ApiDTO>> testPipeline() {
		ReturnDTO<ApiDTO> returnDTO = new ReturnDTO<ApiDTO>();
		HttpStatus httpStatusReturn = HttpStatus.OK;
		Map<String, String> queryParameters = new LinkedHashMap<String, String>();
		queryParameters.put("nomeAPI", "Preco");
		
		Pipeline pipeline = (Pipeline)ServiceMain.getApplicationContext().getBean("Pipeline");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ContextKey.TRANSACTION.getChave(), Transaction.FIND_APIS_VERSION_BY_ID.getChave());
		contextEcatalogue.put(ContextKey.URL, "/buscaapis/listaApis");
		contextEcatalogue.put(ContextKey.QUERY_PARAMETERS, queryParameters);
		
		try {
			pipeline.execute(contextEcatalogue);
			ApiDTO body = (ApiDTO)contextEcatalogue.get(ContextKey.PARSED_JSON);
			returnDTO.setBody(body);
		} catch (CommandException e) {
			returnDTO.setMessage(e.getMensagem().getChave());
			httpStatusReturn = HttpStatus.NO_CONTENT;
			e.printStackTrace();
		} catch (Exception e) {
			returnDTO.setMessage(e.getMessage());
			httpStatusReturn = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		
		return ResponseEntity.status(httpStatusReturn).body(returnDTO);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/api/docs/{id}/{version}", method = RequestMethod.GET)
	public ResponseEntity<ReturnDTO<APIVersionDocumentationDTO[]>> apiDocuments(@PathVariable String id,
																 @PathVariable String version) {

		StringBuffer url = new StringBuffer();
		url.append("/api/docs/").append(id).append("/").append(version);
		ReturnDTO<APIVersionDocumentationDTO[]> returnDTO = new ReturnDTO<APIVersionDocumentationDTO[]>();
		HttpStatus httpStatusReturn = HttpStatus.OK;
		Pipeline pipeline = (Pipeline)ServiceMain.getApplicationContext().getBean("Pipeline");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ContextKey.TRANSACTION.getChave(), Transaction.FIND_DOCS_BY_VERSION.getChave());
		contextEcatalogue.put(ContextKey.API_ID, id);
		contextEcatalogue.put(ContextKey.API_VERSION, version);
		contextEcatalogue.put(ContextKey.URL, url.toString());

		try {
			pipeline.execute(contextEcatalogue);
			APIVersionDocumentationDTO[] body = (APIVersionDocumentationDTO[])contextEcatalogue.get(ContextKey.PARSED_JSON);
			returnDTO.setBody(body);
		} catch (CommandException e) {
			returnDTO.setMessage(e.getMensagem().getChave());
			httpStatusReturn = HttpStatus.NO_CONTENT;
			e.printStackTrace();
		} catch (Exception e) {
			returnDTO.setMessage(e.getMessage());
			httpStatusReturn = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}

		return ResponseEntity.status(httpStatusReturn).body(returnDTO);
	}

}
