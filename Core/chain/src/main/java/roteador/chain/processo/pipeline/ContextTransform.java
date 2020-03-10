package roteador.chain.processo.pipeline;

import java.util.LinkedList;

public class ContextTransform {

	private String sourceContextKey;
	
	private LinkedList<String> transformationObject;
	
	private String destinationContextKey;

	public String getSourceContextKey() {
		return sourceContextKey;
	}

	public void setSourceContextKey(String sourceContextKey) {
		this.sourceContextKey = sourceContextKey;
	}

	public LinkedList<String> getTransformationObject() {
		return transformationObject;
	}

	public void setTransformationObject(LinkedList<String> transformationObject) {
		this.transformationObject = transformationObject;
	}

	public String getDestinationContextKey() {
		return destinationContextKey;
	}

	public void setDestinationContextKey(String destinationContextKey) {
		this.destinationContextKey = destinationContextKey;
	}
	
	
	
}
