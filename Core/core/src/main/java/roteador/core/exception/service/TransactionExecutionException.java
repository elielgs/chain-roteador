package roteador.core.exception.service;

import roteador.core.constants.ECatalogueTransaction;

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
	
    private ECatalogueTransaction transaction = null;

    public TransactionExecutionException(ECatalogueTransaction transaction) {
        super();
        this.transaction = transaction;
    }

    /**
     * 
     * @return
     */
    public ECatalogueTransaction getTransactionEcatalogue(){
        return this.transaction;
    }

}
