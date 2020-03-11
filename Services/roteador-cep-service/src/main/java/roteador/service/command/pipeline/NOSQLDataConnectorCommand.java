package roteador.service.command.pipeline;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import roteador.chain.processo.pipeline.ContextTransform;
import roteador.core.constants.ContextKey;
import roteador.core.constants.ParamHelper;
import roteador.core.exception.command.ParameterException;
import roteador.core.exception.dao.FindException;
import roteador.service.dao.MongoDBDAO;
import roteador.service.mongo.model.MembroOrganizacao;

public class NOSQLDataConnectorCommand implements Command {
	
	@Autowired
	private MongoDBDAO mongoDBDAO;
	
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

	private boolean findById(Context context) throws ParameterException, FindException, SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		Map<String, String> parameters = (Map<String, String>)context.get(ContextKey.PARAMS);

		String email = (String)ParamHelper.getParam("email", parameters, context,  Boolean.TRUE);
		String objectType = (String)ParamHelper.getParam("objectType", parameters, context,  Boolean.TRUE);
		Object membroOrganizacao =  mongoDBDAO.findById(Class.forName(objectType) , email);
		context.put(ContextKey.MONGODB_OBJECT, membroOrganizacao);
		
		return membroOrganizacao != null;
	}
}