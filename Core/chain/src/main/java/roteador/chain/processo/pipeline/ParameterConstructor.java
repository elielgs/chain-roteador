package roteador.chain.processo.pipeline;

import java.util.Iterator;
import java.util.LinkedList;

import org.apache.commons.chain.Context;

import roteador.core.constants.ContextKey;

public class ParameterConstructor {

	private LinkedList<String> attributes;
	
	private String chaveContexto;
	
	@SuppressWarnings("unchecked")
	public void setObject(Context ctx) {
		StringBuffer returnStringBuffer = new StringBuffer();
		Iterator<String> iterator = attributes.iterator();
		while (iterator.hasNext()) {
			String valor = iterator.next();
			if (valor.startsWith("$")) {
				returnStringBuffer.append(ctx.get(ContextKey.valueOf(valor.replace('$', ' ').trim())));
			} else {
				returnStringBuffer.append(valor);
			}
		}
		ctx.put(ContextKey.valueOf(chaveContexto), returnStringBuffer.toString());
	}

	public void setAttributes(LinkedList<String> attributes) {
		this.attributes = attributes;
	}

	public void setChaveContexto(String chaveContexto) {
		this.chaveContexto = chaveContexto;
	}
	
	
}