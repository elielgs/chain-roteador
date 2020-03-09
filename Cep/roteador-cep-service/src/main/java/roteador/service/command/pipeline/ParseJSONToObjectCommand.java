package roteador.service.command.pipeline;

import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.google.gson.Gson;

import roteador.core.constants.ContextKey;
import roteador.core.constants.ParamHelper;

public class ParseJSONToObjectCommand implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public boolean execute(Context context) throws Exception {
		Map<String, String> parameters = (Map<String, String>)context.get(ContextKey.PARAMS);

		String json = (String)context.get(ContextKey.JSON);
		String objectToParseString = (String)ParamHelper.getParam("objectToParseString", parameters, context,  Boolean.TRUE);
		
		Gson gson = new Gson();
		Class<?> klass = Class.forName(objectToParseString);
		context.put(ContextKey.PARSED_JSON, gson.fromJson(json, klass));
		return true;
	}

}
