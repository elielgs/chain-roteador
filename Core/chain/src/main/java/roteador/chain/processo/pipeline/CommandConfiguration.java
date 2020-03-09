package roteador.chain.processo.pipeline;

import java.util.LinkedHashMap;
import java.util.Map;

import roteador.chain.processo.Resultado;

public class CommandConfiguration {

	private String componentJSONFilename;
	private String id;
    private String executeComponent;
    private Map<String, String> params;
    private Map<String, String> forwardParams;
    private String proximo;
    private Map<Boolean, Resultado> resultados = new LinkedHashMap<Boolean, Resultado>();

    public CommandConfiguration() {
        //Construtor
    }

    public CommandConfiguration(final String executa) {
        this.executeComponent = executa;
    }

    public CommandConfiguration(final String executa, final String proximo) {
        this(executa);
        this.proximo = proximo;
    }

    public void setResultado(final Boolean tipo, final Resultado resultado) {
        if(resultados.containsKey(tipo)){
            throw new IllegalArgumentException("Uma sequencia não pode ter dois resultados " + resultado.getTipo() + ".");
        }else{
            resultados.put(tipo, resultado);
        }
    }

    public String getExecuteComponent() {
        return executeComponent;
    }

    public String getProximo() {
        return proximo;
    }

    public void setProximo(final String proximo) {
        this.proximo = proximo;
    }


    public void setExecuteComponent(final String executa) {
        this.executeComponent = executa;
    }

    public Map<Boolean, Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(final Map<Boolean, Resultado> mapResultados) {
        this.resultados = mapResultados;
    }

	public String getComponentJSONFilename() {
		return componentJSONFilename;
	}

	public void setComponentJSONFilename(String jsonFilename) {
		this.componentJSONFilename = jsonFilename;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getForwardParams() {
		return forwardParams;
	}

	public void setForwardParams(Map<String, String> forwardParameters) {
		this.forwardParams = forwardParameters;
	}
}
