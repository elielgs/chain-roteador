package roteador.core.constants;

public enum SupplierStatus {

	ACTIVE("A"),
    INACTIVE("I"),
    SUSPENSE("S");
    
    private String status;

    private SupplierStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
