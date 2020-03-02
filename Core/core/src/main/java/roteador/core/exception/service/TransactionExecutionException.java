package roteador.core.exception.service;

import roteador.core.constants.Transaction;

/**
 * 
 * @author Mauricio Santos
 *
 */
public class TransactionExecutionException extends Exception {

	private static final long serialVersionUID = 7202376282989866821L;

	public TransactionExecutionException() {
		// TODO Auto-generated constructor stub
	}
	
    private Transaction transaction = null;

    public TransactionExecutionException(Transaction transaction) {
        super();
        this.transaction = transaction;
    }

    /**
     * 
     * @return
     */
    public Transaction getTransactionEcatalogue(){
        return this.transaction;
    }

}
