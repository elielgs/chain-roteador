package roteador.service.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import roteador.core.constants.ContextKey;
import roteador.entities.ApiDTO;

public class SelectAPIFromAPIListCommand implements Command {

	@Override
	public boolean execute(Context context) throws Exception {
		ApiDTO[] apiList = (ApiDTO[]) context.get(ContextKey.API_LIST);
		String idAPI = (String)context.get(ContextKey.API_ID);
		
		for (int i = 0; i <  apiList.length; i++) {
			ApiDTO api = (ApiDTO)apiList[i];
			if (api.getId().contentEquals(idAPI)) {
				context.put(ContextKey.API_DTO, api);
				return true;
			}
		}
		return false;
	}

}