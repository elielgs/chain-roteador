package roteador.core.exception.dao;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class SynchronizeException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public SynchronizeException() {
        super();
    }

    public SynchronizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SynchronizeException(String message) {
        super(message);
    }

    public SynchronizeException(Throwable cause) {
        super(cause);
    }
    
}
