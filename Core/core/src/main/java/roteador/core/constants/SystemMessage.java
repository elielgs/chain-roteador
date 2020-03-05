package roteador.core.constants;

public enum SystemMessage {
	
	MN000("API n�o encontrada..."),
	MN001("Organiza��o N�o encontrada..."),
	MN002("OK"),
	MN003("Vers�es para essa API n�o encontrada"),
    MN004("Documentação não encontrada")
    ;

    private String chave;

    private SystemMessage(final String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

}
