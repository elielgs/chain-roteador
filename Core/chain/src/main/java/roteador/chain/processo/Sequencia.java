package roteador.chain.processo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class Sequencia {

    private String executa;
    private String proximo;
    private Map<Boolean, Resultado> mapResultados = new LinkedHashMap<Boolean, Resultado>();
    private String incluir;
    private String transacao;

    public Sequencia() {
        //Construtor
    }

    public Sequencia(final String executa) {
        this.executa = executa;
    }

    public Sequencia(final String executa, final String proximo) {
        this(executa);
        this.proximo = proximo;
    }

    public void setResultado(final Boolean tipo, final Resultado resultado) {
        if(mapResultados.containsKey(tipo)){
            throw new IllegalArgumentException("Uma sequencia não pode ter dois resultados " + resultado.getTipo() + ".");
        }else{
            mapResultados.put(tipo, resultado);
        }
    }

    public String getExecuta() {
        return executa;
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

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(final String transacao) {
        this.transacao = transacao;
    }

    public void setExecuta(final String executa) {
        this.executa = executa;
    }

    public Map<Boolean, Resultado> getMapResultados() {
        return mapResultados;
    }

    public void setMapResultados(final Map<Boolean, Resultado> mapResultados) {
        this.mapResultados = mapResultados;
    }

}
