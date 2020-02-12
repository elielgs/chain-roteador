package roteador.chain.processo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class ProcessoParser extends DefaultHandler {

    private Processo processo;

    private Boolean ultimoTipoResultado;

    private Boolean innerTransacao = Boolean.FALSE;

    private String ultimaSequencia;

    private String ultimaTransacao;

    
    @Override
    public void startElement(final String uri, final String localName, final String name, final Attributes attributes) throws SAXException {
        processarTagProcesso(name, attributes);
        processarTagTransacao(name, attributes);
        processarTagSequencia(name, attributes);
        processarTagResultado(name, attributes);
        processarTagSucesso(name, attributes);
        processarTagExcecao(name, attributes);
    }

   
    @Override
    public void endElement(final String uri, final String localName, final String name) throws SAXException {
        if(name.equalsIgnoreCase("transacao")){
            this.innerTransacao = Boolean.FALSE;
        }
    }

    private void processarTagProcesso(final String name, final Attributes attributes) {
        if (name.equalsIgnoreCase("processo")) {
            this.processo = new Processo(attributes.getValue("nome"), attributes.getValue("inicio"));
        }
    }

    private void processarTagTransacao(final String name, final Attributes attributes) {
        if (name.equalsIgnoreCase("transacao")) {
            this.innerTransacao = Boolean.TRUE;
            final String nomeTransacao = attributes.getValue("nome");
            this.ultimaTransacao = nomeTransacao;
            this.processo.getMapTransacoes().put(nomeTransacao, new Transacao(nomeTransacao));
        }
    }

    private void processarTagSequencia(final String name, final Attributes attributes) {
        String sequenciaNome = null;
        if (name.equalsIgnoreCase("sequencia")) {
            final String executa = attributes.getValue("executa");
            final String proximo = attributes.getValue("proximo");
            final String incluir = attributes.getValue("incluir");
            final String transacao = attributes.getValue("transacao");
            final Sequencia sequencia = new Sequencia();

            if (executa != null) {
                sequenciaNome = executa;
                sequencia.setExecuta(executa);
            }
            if (proximo != null) {
                sequencia.setProximo(proximo);
            }
            if (incluir != null) {
                if (executa == null) {
                    sequenciaNome = incluir;
                }
                sequencia.setIncluir(incluir);
            }
            if (transacao != null) {
                sequencia.setTransacao(transacao);
            }

            if(innerTransacao){
                this.processo.getMapTransacoes().get(ultimaTransacao).getMapSequencias().put(sequenciaNome, sequencia);
            }else{
                this.processo.getMapSequencias().put(sequenciaNome, sequencia);
            }
            this.ultimaSequencia = sequenciaNome;
        }
    }

   
    private void processarTagResultado(final String name, final Attributes attributes) {
        if (name.equalsIgnoreCase("resultado")) {
            final String tipo = attributes.getValue("tipo");
            final String proximo = attributes.getValue("proximo");
            final String incluir = attributes.getValue("incluir");
            final Resultado resultado = new Resultado(Boolean.valueOf(tipo));
            this.ultimoTipoResultado = Boolean.valueOf(tipo);
            if (proximo != null) {
                resultado.setProximo(proximo);
            }
            if (incluir != null) {
                resultado.setIncluir(incluir);
            }

            if(innerTransacao){
                this.processo.getMapTransacoes().get(ultimaTransacao).getMapSequencias().get(this.ultimaSequencia).setResultado(this.ultimoTipoResultado, resultado);
            }else{
                this.processo.getMapSequencias().get(this.ultimaSequencia).setResultado(this.ultimoTipoResultado, resultado);
            }
        }
    }

  
    private void processarTagSucesso(final String name, final Attributes attributes) {
        if (name.equalsIgnoreCase("sucesso")) {
            final String tipoRetorno = attributes.getValue("tipoRetorno");
            final String nomeRetorno = attributes.getValue("nomeRetorno");
            final  Sucesso sucesso = new Sucesso();

            if (tipoRetorno != null) {
                sucesso.setTipoRetorno(tipoRetorno);
            }
            if (nomeRetorno != null) {
                sucesso.setNomeRetorno(nomeRetorno);
            }
            this.processo.getMapTransacoes().get(ultimaTransacao).setSucesso(sucesso);
        }
    }

   
    private void processarTagExcecao(final String name, final Attributes attributes) {
        if (name.equalsIgnoreCase("excecao")) {
            final Excecao excecao = new Excecao(attributes.getValue("tipo"), attributes.getValue("construcao"));
            if(innerTransacao){
                this.processo.getMapTransacoes().get(this.ultimaTransacao).getMapSequencias().get(this.ultimaSequencia).getMapResultados().get(this.ultimoTipoResultado).setExcecao(excecao);
            }else{
                this.processo.getMapSequencias().get(this.ultimaSequencia).getMapResultados().get(this.ultimoTipoResultado).setExcecao(excecao);
            }
        }
    }

   
    public Processo getProcesso() {
        return this.processo;
    }

}
