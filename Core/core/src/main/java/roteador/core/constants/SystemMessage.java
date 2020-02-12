package roteador.core.constants;

public enum SystemMessage {
	
	MN000("Cep Não informado !!!"),
    MN001("EXECUTANDO LOGIN ON \u00ad LINE, AGUARDE..."),
    MN002("Erro ao remover o fornecedor"),
    MN003("Error when accessing the WebService"),
    MN004("Problems when creating the order"),
    MN005("Problems when confirming the order"),
    MN006("Problems when calculating the cart"),
    MN007("Problems when tracking a order"),
    MN008("Problems when finding product by SKU"),
    MN009("No pricing offer could be found!"),
    MN010("No pricing offer could be found!"),
    MN011("No pricing offers could be found!"),
    MN012("Problems when geet the Active Pricing Offers"),
    MN013("Problems when loading the scheduler"),
    MN014("Order not found"),
    MN015("Product not found in category"),
    MN016("Wishlist not found"),

    MN017("Reward Provider - Client not found."),
    MN018("Reward Provider - Login failed."),
    MN019("Reward Provider - System failure"),

    MN020("No Mosaic registered for this Program"),
    MN021("No Models Found for this Mosaic"),

    MN022("No Loyalty Engine Connector Found for this Client / Program"),
    
    MN023("Problems when removing cart item"),
    MN024("No Cart found for this cookie hash !"),
    MN025("Member could not be found !"),
    
    MN026("Product Sku could not be found !"),
    MN027("Product Sku is not active !"),
    MN028("Product Sku has no points !"),
    MN029("No authentication token found for this member"),
    MN030("Member's points are not sufficient to finalize this order"),
    MN031("Client Supplier Configuration Not Found"),    
    
    MN101("ASLP: Error on 'post item on basket'"),
    MN102("ASLP: Error on redeem or not enough points"),
    MN103("ASLP: Enrol failed"),
    
    
    ;

    private String chave;

    private SystemMessage(final String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

}
