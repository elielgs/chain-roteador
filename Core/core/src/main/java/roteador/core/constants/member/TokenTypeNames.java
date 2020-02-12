package roteador.core.constants.member;

public enum TokenTypeNames {
	EMAIL, CPF, FACEBOOK, USERNAME, CURRENT_ACCOUNT, RG, MULTIPLUS;
	
	public static TokenTypeNames getByValue(final String value) {
        for(final TokenTypeNames retorno : TokenTypeNames.values()) {
            if(retorno.toString().equals(value)) {
                return retorno;
            }
        }
        return null;
    }
}
