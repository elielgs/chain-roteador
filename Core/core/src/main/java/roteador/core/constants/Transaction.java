package roteador.core.constants;

import java.util.ArrayList;
import java.util.List;

public enum Transaction {

    FIND_APIS_BY_USER("findAPIsByUser"),
    FIND_APIS_VERSION_BY_ID("findAPIsVersionById"),
    SALVAR_ORGANIZACOES("salvarOrganizacoes")
    ;

    private String chave;

	private Transaction(final String chave) {
		this.chave = chave;
	}

	public String getChave() {
		return chave;
	}

    public static Transaction getPorNome(final String nomeTransacao) {
        for(final Transaction transacao : Transaction.values()) {
            if(transacao.getChave().equals(nomeTransacao)) {
                return transacao;
            }
        }
        return null;
    }


    public static List<Transaction> getTransacoesPorNome(final String nomeTransacao) {
        final List<Transaction> transacoes = new ArrayList<Transaction>();
        for(final Transaction transacao : Transaction.values()) {
            if(transacao.getChave().equals(nomeTransacao)) {
                transacoes.add(transacao);
            }
        }
        return transacoes;
    }

}
