package roteador.core.constants.supplier;

public enum DeliverySupplierType {

	EMAIL("E"),
    ADRESS("A")     
    ;
    
    private String type;

    private DeliverySupplierType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
   

}
