package roteador.core.exception.service;

/**
 * User: eliel
 * Date: 05/07/13
 * Time: 13:57
 */
public class ProductQuantityException extends Exception {

	private static final long serialVersionUID = 3393912621461301310L;

	private int originalQuantity;

    private int foundQuantity;

    private String idSkuSupplier;

    public ProductQuantityException(String idSkuSupplier, int originalQuantity, int foundQuantity) {
        this.idSkuSupplier = idSkuSupplier;
        this.originalQuantity = originalQuantity;
        this.foundQuantity = foundQuantity;
    }

	public int getOriginalQuantity() {
		return originalQuantity;
	}

	public void setOriginalQuantity(int originalQuantity) {
		this.originalQuantity = originalQuantity;
	}

	public int getFoundQuantity() {
		return foundQuantity;
	}

	public void setFoundQuantity(int foundQuantity) {
		this.foundQuantity = foundQuantity;
	}

	public String getIdSkuSupplier() {
		return idSkuSupplier;
	}

	public void setIdSkuSupplier(String idSkuSupplier) {
		this.idSkuSupplier = idSkuSupplier;
	}
    
    
}
