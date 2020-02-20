package roteador.core.constants;

public enum SystemMessage {
	
	MN000("API não encontrada..."),
    
    ;

    private String chave;

    private SystemMessage(final String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

}
