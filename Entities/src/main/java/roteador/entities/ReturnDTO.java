package roteador.entities;

import java.io.Serializable;

public class ReturnDTO <T> implements Serializable {
	
	private String message;
	private T body;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -383045697438389965L;

}
