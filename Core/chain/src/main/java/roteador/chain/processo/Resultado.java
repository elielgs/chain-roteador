package roteador.chain.processo;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class Resultado {

	private Boolean tipo;

	private String proximo;

	private String incluir;

	private Excecao excecao;

	public Resultado(final Boolean tipo) {
		this.tipo = tipo;
	}

	public Resultado(final Boolean tipo, final String proximo) {
		this.tipo = tipo;
		this.proximo = proximo;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(final Boolean tipo) {
		this.tipo = tipo;
	}

	public String getProximo() {
		return proximo;
	}

	public void setProximo(final String proximo) {
		this.proximo = proximo;
	}

	public String getIncluir() {
		return incluir;
	}

	public void setIncluir(final String incluir) {
		this.incluir = incluir;
	}

	public Excecao getExcecao() {
		return excecao;
	}

	public void setExcecao(final Excecao excecao) {
		this.excecao = excecao;
	}

}
