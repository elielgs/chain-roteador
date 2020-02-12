package roteador.core.constants;

public enum FraudeKey
{
	REGISTER_LOG("registerLog"),
	TRANSACTION_CHECKOUT("transactionCheckout"),
	
	VALUE("VALUE"),
	
	// Caso esteja somente registrando ações (REGISTER_LOG), deve ser especificado o tipo abaixo:
	LOG_TYPE("LOG_TYPE"),
	LOG_ADDRESS_CHANGED("addressChanged"),
	LOG_CHECKOUT("checkout"),

	;

	private String chave;

	private FraudeKey(final String chave)
	{
		this.chave = chave;
	}

	public String getChave()
	{
		return chave;
	}

}
