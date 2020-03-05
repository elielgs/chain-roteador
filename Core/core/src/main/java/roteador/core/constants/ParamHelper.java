package roteador.core.constants;

import java.util.Map;

import org.apache.commons.chain.Context;

import roteador.core.exception.command.ParameterException;

public class ParamHelper {
	
	public static String getParam(String param, Map<String, String> params, Context ctx, Boolean required) throws ParameterException {
		String paramValue = params.get(param);
		if (paramValue != null) {
			if (paramValue.startsWith("$")) {
				paramValue = (String)ctx.get(ContextKey.valueOf(paramValue.replace('$', ' ').trim()));
			}
		}
		if (required && paramValue == null) {
			throw new ParameterException(param);
		}
		return  paramValue;
	}
}
