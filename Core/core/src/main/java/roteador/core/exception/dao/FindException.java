package roteador.core.exception.dao;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class FindException extends Exception {

	private static final long serialVersionUID = 1L;

	public FindException() {
		super();
	}

	public FindException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FindException(String message) {
		super(message);
	}

	public FindException(Throwable cause) {
		super(cause);
	}

}
