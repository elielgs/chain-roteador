package roteador.service.command;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import roteador.core.command.AbstractBaseCommand;
import roteador.core.constants.ContextKey;

public class BuildMessageCommand extends AbstractBaseCommand {

	public boolean execute(Context context) throws Exception {
//		String codigoCep = (String)context.get(ECatalogueContextKey.CEP);
//
//		String messageMail = "Mensagem enviada para o CEP " + codigoCep;
//		context.put(ECatalogueContextKey.MESSAGE, messageMail);
		return true;
	}

}
