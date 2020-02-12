package roteador.core.constants;

import roteador.core.constants.member.MaritalStatus;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 9/6/13
 * - Time: 8:28 PM
 */
public enum SearchSortEnum {

	SCORE, NONE, POINTS_ASC, POINTS_DESC;
	
	
	public static SearchSortEnum getByValue(final String value) {
        for(final SearchSortEnum retorno : SearchSortEnum.values()) {
            if(retorno.toString().equals(value)) {
                return retorno;
            }
        }
        return null;
    }
}
