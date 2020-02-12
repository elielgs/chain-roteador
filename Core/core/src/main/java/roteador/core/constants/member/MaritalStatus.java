package roteador.core.constants.member;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 5/17/13
 * - Time: 9:58 AM
 */
public enum MaritalStatus {

	SINGLE("S", "Solteiro"),
	MARRIED("M", "Casado"),
	DIVORCED("D", "Divorciado"),
	WIDOWER("W", "Viúvo"),
	OTHER("O", "Outro");

	String value;
	String htmlValue;

	MaritalStatus(String value, String htmlValue) {
		this.value = value;
		this.htmlValue = htmlValue;
	}

	public String getValue() {
		return value;
	}
	
	public String getHtmlValue()
	{
		return htmlValue;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static MaritalStatus getByValue(final String value) {
        for(final MaritalStatus retorno : MaritalStatus.values()) {
            if(retorno.getValue().equals(value)) {
                return retorno;
            }
        }
        return null;
    }
	
	public static MaritalStatus getByOrdinal(int ordinal) {
		for(final MaritalStatus retorno : MaritalStatus.values()) {
			if(retorno.ordinal() == ordinal) {
				return retorno;
			}
		}
		return null;
	}
	
	public static MaritalStatus getByHtmlInfo(String value)
	{
        for(final MaritalStatus retorno : MaritalStatus.values()) {
            if(retorno.getHtmlValue().equals(value)) {
                return retorno;
            }
        }
        return OTHER;
	}


}
