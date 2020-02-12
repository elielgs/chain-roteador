package roteador.chain.processo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class Processo {

	private String nome;

	private String inicio;

	private Map<String, Transacao> mapTransacoes = new LinkedHashMap<String, Transacao>();

	private Map<String, Sequencia> mapSequencias = new LinkedHashMap<String, Sequencia>();

	public Processo() {
		// Construtor
	}

	public Processo(final String nome, final String inicio) {
		this.nome = nome;
		this.inicio = inicio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(final String inicio) {
		this.inicio = inicio;
	}

	public Map<String, Transacao> getMapTransacoes() {
		return mapTransacoes;
	}

	public void setMapTransacoes(final Map<String, Transacao> mapTransacoes) {
		this.mapTransacoes = mapTransacoes;
	}

	public Map<String, Sequencia> getMapSequencias() {
		return mapSequencias;
	}

	public void setMapSequencias(final Map<String, Sequencia> mapSequencias) {
		this.mapSequencias = mapSequencias;
	}

}