package roteador.core.constants;

public enum SystemMessage {
	
	MN000("API não encontrada..."),
	MN001("Organização Não encontrada..."),
	MN002("OK"),
	MN003("Versões para essa API não encontrada")
    ;

    private String chave;

    private SystemMessage(final String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

}
