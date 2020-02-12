package roteador.core.constants;



/**
 * @author Marcos Pestana
 *
 */
public enum Status {

	ACTIVE("A"),
    INACTIVE("I"),
    EXPIRED("E")
    ;
    
    private String status;

    private Status(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
   

}
