package roteador.service.command.pipeline;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import roteador.core.constants.ContextKey;
import roteador.core.constants.ParamHelper;
import roteador.core.exception.command.ParameterException;
import roteador.core.exception.dao.FindException;
import roteador.service.dao.MongoDBDAO;
import roteador.service.mongo.model.MembroOrganizacao;

public class MembroOrganizacaoDataCommand implements Command {
	
	@Autowired
	private MongoDBDAO<MembroOrganizacao> mongoDBDAO;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public boolean execute(Context context) throws Exception {
		Map<String, String> parameters = (Map<String, String>)context.get(ContextKey.PARAMS);
		
		String method = (String)ParamHelper.getParam("method", parameters, context,  Boolean.TRUE);
		switch (method) {
			case "findById":
				return findById(context);
		}

		return false;
	}

	private boolean findById(Context context) throws ParameterException, FindException, SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, String> parameters = (Map<String, String>)context.get(ContextKey.PARAMS);

		String email = (String)ParamHelper.getParam("email", parameters, context,  Boolean.TRUE);
		
		MembroOrganizacao membroOrganizacao = mongoDBDAO.findById(MembroOrganizacao.class, email);
		//context.put(ContextKey.MEMBRO_ORGANIZACAO, membroOrganizacao);
		context.put(ContextKey.MEMBER_APIS_DESC_LIST, membroOrganizacao.getApis());
		
//		Method[] methods = membroOrganizacao.getClass().getMethods();
//		for (int i = 0; i< methods.length; i++) {
//			Method method = methods[i];
//			if (method.getName().equals("setName")) {
//				method.invoke(membroOrganizacao, "Teste Eliel");	
//			}
//		}
		return membroOrganizacao != null;
	}
}