package roteador.core.constants;



/**
 * @author Marcos Pestana
 *
 */
public enum ProgramStatus {

	ACTIVE("A"),
    INACTIVE("I"),
    SUSPENDED("S")
    ;
    
    private String status;

    private ProgramStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
   

}
