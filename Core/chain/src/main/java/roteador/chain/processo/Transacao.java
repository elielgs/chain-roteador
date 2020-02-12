package roteador.chain.processo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class Transacao {

    private String nome;

    private Sucesso sucesso;

    private Map<String, Sequencia> mapSequencias = new LinkedHashMap<String, Sequencia>();

    public Transacao() {
        super();
    }

    public Transacao(final String nomeTransacao) {
        this.nome = nomeTransacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Map<String, Sequencia> getMapSequencias() {
        return mapSequencias;
    }

    public void setMapSequencias(final Map<String, Sequencia> mapSequencias) {
        this.mapSequencias = mapSequencias;
    }

    public Sucesso getSucesso() {
        return sucesso;
    }

    public void setSucesso(final Sucesso sucesso) {
        this.sucesso = sucesso;
    }

}