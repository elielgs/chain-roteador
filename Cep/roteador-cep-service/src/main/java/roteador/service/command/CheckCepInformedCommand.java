package roteador.service.command;


import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import roteador.core.command.AbstractBaseCommand;
import roteador.core.constants.ContextKey;

public class CheckCepInformedCommand extends AbstractBaseCommand {

	public boolean execute(Context context) throws Exception {
//		String codigoCep = (String)context.get(ECatalogueContextKey.CEP);
//		if (codigoCep.equals("00000-000")) {
//			return false;
//		}
		return true;
	}

}
