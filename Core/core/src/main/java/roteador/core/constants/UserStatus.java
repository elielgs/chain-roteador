package roteador.core.constants;



/**
 * @author Marcos Pestana
 *
 */
public enum UserStatus {

	ACTIVE("A"),
    INACTIVE("I"),
    EXPIRED("E")
    ;
    
    private String status;

    private UserStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
   

}
