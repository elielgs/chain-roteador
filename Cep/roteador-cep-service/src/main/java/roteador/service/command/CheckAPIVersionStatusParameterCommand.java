package roteador.service.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import roteador.core.constants.ContextKey;

public class CheckAPIVersionStatusParameterCommand implements Command {

	@Override
	public boolean execute(Context context) throws Exception {
		return context.get(ContextKey.API_VERSION_STATUS_LIST) != null;
	}

}
