package roteador.core.constants.member;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade Created in: - Date: 5/20/13 - Time:
 * 3:53 PM
 */
public enum AddressType {

	DELIVERY, CHARGING, MOBILE, EMAIL, PHYSICAL;
	
	public static AddressType getByValue(final String value) {
        for(final AddressType retorno : AddressType.values()) {
            if(retorno.toString().equals(value)) {
                return retorno;
            }
        }
        return null;
    }
}
