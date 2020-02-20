package roteador.core.constants;


public enum ECatalogueContextKey {
	

	CONTEXT("CONTEXT"),
    COMMAND_EXCEPTION("COMMAND_EXCEPTION"),
    SERVICE_EXCEPTION("SERVICE_EXCEPTION"),
    EXCEPTION("EXCEPTION"),
    TRANSACTION("TRANSACTION"),
    TRANSACTION_UUID("TRANSACTION_UUID"),
    APPLICATION_PATH("APPLICATION_PATH"),
    RESPONSE("RESPONSE"),
    REQUEST_JSON("REQUEST_JSON"),

   
    
    USER_TO("USER_TO"),
    API_LIST("API_LIST"),
    API_DTO("API_DTO"),
    API_ID("API_ID"),
    JSON_PARSE_FROM_OBJECT("JSON_PARSE_FROM_OBJECT"),
    JSON_OBJECT("JSON_OBJECT"),
    MESSAGE("MESSAGE"),

    
    ;

    private String chave;

    private ECatalogueContextKey(final String chave) {
        this.chave = chave;
    }

    public String getChave() {
    	return chave;
    }

}

