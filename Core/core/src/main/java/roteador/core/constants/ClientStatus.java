package roteador.core.constants;

public enum ClientStatus {

	ACTIVE("A"),
    INACTIVE("I");
    
    private String status;

    private ClientStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
   

}
