package roteador.core.exception.command;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class TransactionNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TransactionNotFoundException(String mensagemRetorno){
		super(mensagemRetorno);
	}
	
	public TransactionNotFoundException(Exception e) {
		super(e);
	}

}
