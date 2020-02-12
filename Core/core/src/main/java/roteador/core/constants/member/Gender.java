package roteador.core.constants.member;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 5/20/13
 * - Time: 5:04 PM
 */
public enum Gender {

	MALE("M", "Masculino"), FEMALE("F", "Feminino");

	private String value;
	private String htmlValue;

	private Gender(String value, String htmlValue) {
		this.value = value;
		this.htmlValue = htmlValue;
	}

	public String getValue() {
		return value;
	}
	
	public String getHtmlValue() {
		return htmlValue;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static Gender getByValue(final String value) {
        for(final Gender retorno : Gender.values()) {
            if(retorno.getValue().equals(value)) {
                return retorno;
            }
        }
        return null;
    }
	
	public static Gender getByHtmlInfo(String value)
	{
        for(final Gender retorno : Gender.values()) {
            if(retorno.getHtmlValue().equals(value)) {
                return retorno;
            }
        }
        return null;
	}
	
}
