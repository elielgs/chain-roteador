package roteador.service.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import roteador.core.constants.ContextKey;
import roteador.entities.APIVersionDTO;

public class FilterAPIVersionStatusCommand implements Command {

	@Override
	public boolean execute(Context context) throws Exception {
		String statusFilter = (String) context.get(ContextKey.API_VERSION_STATUS_LIST);
		APIVersionDTO[] apiVersionDTOList = (APIVersionDTO[]) context.get(ContextKey.API_VERSION_LIST);

		APIVersionDTO[] filteredAPIVersionDTOArray = new APIVersionDTO[apiVersionDTOList.length];
		int returnIndex = 0;
		
		for (int i = 0; i < apiVersionDTOList.length; i++) {
			APIVersionDTO apiVersionDTO = apiVersionDTOList[i];
			if (apiVersionDTO.getStatus().equals(statusFilter)) {
				filteredAPIVersionDTOArray[returnIndex++] = apiVersionDTO;
			}
		}

		context.put(ContextKey.API_VERSION_LIST, filteredAPIVersionDTOArray);
		return true;
	}

}
