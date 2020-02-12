package roteador.core.exception.dao;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class RefreshException extends Exception {
	
    private static final long serialVersionUID = 1L;

    public RefreshException() {
        super();
    }

    public RefreshException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefreshException(String message) {
        super(message);
    }

    public RefreshException(Throwable cause) {
        super(cause);
    }

}
