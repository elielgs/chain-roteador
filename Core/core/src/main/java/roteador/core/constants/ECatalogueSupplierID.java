package roteador.core.constants;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 5/29/13
 * - Time: 12:03 PM
 */
public enum ECatalogueSupplierID {

	NOVAPONTOCOM_EXTRA("1", ComponentQueueNameEnum.SUPPLIER_NOVAPONTOCOM_SERVICE),
	WALMART("2", ComponentQueueNameEnum.SUPPLIER_WALMART_SERVICE),
	COMPRAFACIL("3", ComponentQueueNameEnum.SUPPLIER_COMPRAFACIL_SERVICE),
    NOVAPONTOCOM_PONTO_FRIO("4", ComponentQueueNameEnum.SUPPLIER_NOVAPONTOCOM_SERVICE),
    NOVAPONTOCOM_CASAS_BAHIA("5", ComponentQueueNameEnum.SUPPLIER_NOVAPONTOCOM_SERVICE),
    CENTAURO("6", ComponentQueueNameEnum.SUPPLIER_CENTAURO_SERVICE),
//  FASTSHOP("7", ComponentQueueNameEnum.SUPPLIER_FASTSHOP_SERVICE),
    POLISHOP("8", ComponentQueueNameEnum.SUPPLIER_POLISHOP_SERVICE),
	FASTSHOP("9", ComponentQueueNameEnum.SUPPLIER_FASTSHOP_SERVICE),
	MAGAZINE_LUIZA("10", ComponentQueueNameEnum.SUPPLIER_POLISHOP_SERVICE),
	MULTIPLUS("11", ComponentQueueNameEnum.SUPPLIER_MULTIPLUS_SERVICE);

	private String id;

    private ComponentQueueNameEnum componentQueueNameEnum;

	private ECatalogueSupplierID(String id, ComponentQueueNameEnum componentQueueNameEnum) {
		this.id = id;
        this.componentQueueNameEnum = componentQueueNameEnum;
	}

	public String getId() {
		return id;
	}

    public ComponentQueueNameEnum getComponentQueueNameEnum() {
        return componentQueueNameEnum;
    }

    public static ECatalogueSupplierID findByIdSupplier(Integer idSupplier){
        for(ECatalogueSupplierID v : values()){
            if( v.id.equals(String.valueOf(idSupplier))){
                return v;
            }
        }
        return null;
    }



}
