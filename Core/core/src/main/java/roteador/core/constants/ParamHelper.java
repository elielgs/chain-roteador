package roteador.core.constants;

import java.util.Map;

import org.apache.commons.chain.Context;

import roteador.core.exception.command.ParameterException;

public class ParamHelper {
	
	public static Object getParam(String param, Map<String, String> params, Context ctx, Boolean required) throws ParameterException {
		String paramValueString = params.get(param);
		Object paramReturn = null;
		if (paramValueString != null) {
			if (paramValueString.startsWith("$")) {
				paramReturn = ctx.get(ContextKey.valueOf(paramValueString.replace('$', ' ').trim()));
			} else {
				paramReturn = paramValueString;
			}
		}
		if (required && paramReturn == null) {
			throw new ParameterException(param);
		}
		return  paramReturn;
	}
}
