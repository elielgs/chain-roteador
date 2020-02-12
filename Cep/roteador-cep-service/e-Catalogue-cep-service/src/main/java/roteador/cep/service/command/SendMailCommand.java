package roteador.cep.service.command;


import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import roteador.core.command.AbstractBaseCommand;
import roteador.core.constants.ECatalogueContextKey;

public class SendMailCommand extends AbstractBaseCommand {
	private static final Logger LOG = Logger.getLogger(SendMailCommand.class);

	public boolean execute(Context context) throws Exception {
		LOG.info((String)context.get(ECatalogueContextKey.MESSAGE));
		return true;
	}

}
