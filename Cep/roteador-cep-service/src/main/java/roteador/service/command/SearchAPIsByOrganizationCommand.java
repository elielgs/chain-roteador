package roteador.service.command;

import org.apache.commons.chain.Context;

import roteador.core.constants.ContextKey;
import roteador.service.mongo.model.MembroOrganizacao;

public class SearchAPIsByOrganizationCommand extends AbstractMongodbConnectionCommand {

	@Override
	public boolean execute(Context context) throws Exception {
		String email = (String)context.get(ContextKey.EMAIL);
		MembroOrganizacao membroOrganizacao = mongoDBDAO.findById(MembroOrganizacao.class, email);
		context.put(ContextKey.MEMBRO_ORGANIZACAO, membroOrganizacao);
		return membroOrganizacao != null;
	}
}
