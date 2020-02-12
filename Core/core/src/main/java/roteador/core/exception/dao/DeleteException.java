package roteador.core.exception.dao;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class DeleteException extends Exception {

    private static final long serialVersionUID = 1L;

    public DeleteException() {
        super();
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

}
