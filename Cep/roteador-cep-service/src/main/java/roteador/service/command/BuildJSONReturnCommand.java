package roteador.service.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.google.gson.Gson;

import roteador.core.constants.ContextKey;

public class BuildJSONReturnCommand implements Command {

	@Override
	public boolean execute(Context context) throws Exception {
		ContextKey keyFromObject = (ContextKey) context.get(ContextKey.JSON_PARSE_FROM_OBJECT);
		Gson gson = new Gson();
		context.put(ContextKey.JSON_OBJECT, gson.toJson(context.get(keyFromObject)));
		
		return true;
	}

}
