package roteador.core.exception.service;


/**
 * Marcos
*/
public class RecoveryLinkException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1569498769233605965L;
	
	private String message;

	
	public RecoveryLinkException(String message){
		super(message);
		this.message = message;
	}
	@Override
	public String getMessage(){
		return message;
	}


}