package roteador.service.controller;

import java.util.List;

import org.springframework.data.repository.query.ReturnedType;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import roteador.chain.Chain;
import roteador.core.ContextECatalogue;
import roteador.core.constants.ContextKey;
import roteador.core.constants.Transaction;
import roteador.core.exception.command.CommandException;
import roteador.entities.APIVersionDTO;
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
	
	@RequestMapping(value="/api/list", method = RequestMethod.GET)
	public ResponseEntity<ReturnDTO<List<ApiDTO>>> listApis(@RequestParam String email) {

		ReturnDTO<List<ApiDTO>> returnDTO = new ReturnDTO<List<ApiDTO>>();
		HttpStatus httpStatusReturn = HttpStatus.OK;
		Chain chain = (Chain)ServiceMain.getApplicationContext().getBean("Chain");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ContextKey.TRANSACTION.getChave(), Transaction.FIND_APIS_BY_USER.getChave());
		contextEcatalogue.put(ContextKey.EMAIL, email);
		try {
			chain.execute(contextEcatalogue);
			List<ApiDTO> body = (List<ApiDTO>)contextEcatalogue.get(ContextKey.API_LIST);
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
	
	@RequestMapping(value="/api/version/{id}", method = RequestMethod.GET)
	public ResponseEntity<ReturnDTO<APIVersionDTO[]>> apiVersion(@PathVariable String id,
			@RequestParam(required = false) String status) {

		ReturnDTO<APIVersionDTO[]> returnDTO = new ReturnDTO<APIVersionDTO[]>();
		HttpStatus httpStatusReturn = HttpStatus.OK;
		Chain chain = (Chain)ServiceMain.getApplicationContext().getBean("Chain");
		ContextECatalogue contextEcatalogue = new ContextECatalogue();
		contextEcatalogue.put(ContextKey.TRANSACTION.getChave(), Transaction.FIND_APIS_VERSION_BY_ID.getChave());
		contextEcatalogue.put(ContextKey.API_ID, id);
		
		if (status != null) {
			contextEcatalogue.put(ContextKey.API_VERSION_STATUS_LIST, status);
		}

		try {
			chain.execute(contextEcatalogue);
			APIVersionDTO[] body = (APIVersionDTO[])contextEcatalogue.get(ContextKey.API_VERSION_LIST);
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
