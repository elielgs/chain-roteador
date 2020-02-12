package roteador.chain.processo;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class Sucesso {

    private String tipoRetorno;

    private String nomeRetorno;

    private Sequencia sequencia;

    private Transacao transacao;

    public String getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(final String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }

    public String getNomeRetorno() {
        return nomeRetorno;
    }

    public void setNomeRetorno(final String nomeRetorno) {
        this.nomeRetorno = nomeRetorno;
    }

    public Sequencia getSequencia() {
        return sequencia;
    }

    public void setSequencia(final Sequencia sequencia) {
        this.sequencia = sequencia;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(final Transacao transacao) {
        this.transacao = transacao;
    }

}