package roteador.service.command;


import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import roteador.core.command.AbstractBaseCommand;
import roteador.core.constants.ECatalogueContextKey;

public class SendMailCommand extends AbstractBaseCommand {

	public boolean execute(Context context) throws Exception {
		return true;
	}

}
