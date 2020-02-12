package roteador.core.constants;



/**
 * @author Marcos Pestana
 *
 */
public enum TokenStatus {

	ACTIVE("A"),
    INACTIVE("I"),
    EXPIRED("E")
    ;
    
    private String status;

    private TokenStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
   

}
