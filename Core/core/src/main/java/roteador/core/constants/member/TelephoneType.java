package roteador.core.constants.member;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 5/17/13
 * - Time: 11:52 AM
 */
public enum TelephoneType {

	RESIDENTIAL,
	COMMERCIAL,
	CELL,
	FAX, MESSAGE, OTHER;

	public static TelephoneType getByValue(final String value) {
        for(final TelephoneType retorno : TelephoneType.values()) {
            if(retorno.toString().equals(value)) {
                return retorno;
            }
        }
        return null;
    }
}
