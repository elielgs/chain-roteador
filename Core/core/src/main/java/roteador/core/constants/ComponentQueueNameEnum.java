package roteador.core.constants;

/**
 * 
 * @author Mauricio Santos
 *
 */
public enum ComponentQueueNameEnum {

	SUPPLIER_COMPRAFACIL("ECATALOGUE_SUPPLIER_COMPRAFACIL", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	SUPPLIER_COMPRAFACIL_SERVICE("ECATALOGUE_SUPPLIER_COMPRAFACIL_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	
	SUPPLIER_NOVAPONTOCOM("ECATALOGUE_SUPPLIER_NOVAPONTOCOM", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	SUPPLIER_NOVAPONTOCOM_SERVICE("ECATALOGUE_SUPPLIER_NOVAPONTOCOM_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	
	SUPPLIER_WALMART("ECATALOGUE_SUPPLIER_WALMART", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	SUPPLIER_WALMART_SERVICE("ECATALOGUE_SUPPLIER_WALMART_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    SUPPLIER_CENTAURO("ECATALOGUE_SUPPLIER_CENTAURO", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    SUPPLIER_CENTAURO_SERVICE("ECATALOGUE_SUPPLIER_CENTAURO_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    
    SUPPLIER_MAGAZINE_LUIZA("ECATALOGUE_SUPPLIER_MAGAZINE_LUIZA", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    SUPPLIER_MAGAZINE_LUIZA_SERVICE("ECATALOGUE_SUPPLIER_MAGAZINE_LUIZA_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    SUPPLIER_MULTIPLUS_SERVICE("ECATALOGUE_SUPPLIER_MULTIPLUS_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    
    SUPPLIER_POLISHOP("ECATALOGUE_SUPPLIER_POLISHOP", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    SUPPLIER_POLISHOP_SERVICE("ECATALOGUE_SUPPLIER_POLISHOP_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    SUPPLIER_FASTSHOP("ECATALOGUE_SUPPLIER_FASTSHOP", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    SUPPLIER_FASTSHOP_SERVICE("ECATALOGUE_SUPPLIER_FASTSHOP_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    SUPPLIER_INTEGRATION("ECATALOGUE_SUPPLIER_INTEGRATION", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    SUPPLIER_SERVICE("ECATALOGUE_SUPPLIER_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),


    MEMBER_WEB_CONFIGURATION("MEMBER_WEB_CONFIGURATION", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	CLIENT_SERVICE("ECATALOGUE_CLIENT_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	CATALOG_SERVICE("ECATALOGUE_CATALOG_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	PROGRAM_SERVICE("ECATALOGUE_PROGRAM_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	PRODUCT_SERVICE("ECATALOGUE_PRODUCT_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	PRICING_SERVICE("ECATALOGUE_PRICING_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    PROMOTION_SERVICE("ECATALOGUE_PROMOTION_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    IMAGE_SERVICE("ECATALOGUE_IMAGE_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	LOYALTY_ENGINE("LOYALTY_ENGINE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	ACCESS_MANAGER("ECATALOGUE_ACCESS_MANAGER", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	CATEGORY_SERVICE("ECATALOGUE_CATEGORY_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	
	ACCOUNT_MEMBER_SERVICE("ECATALOGUE_ACCOUNT_MEMBER_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    ORDER_SERVICE("ECATALOGUE_ORDER_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    WISHLIST_SERVICE("ECATALOGUE_WISHLIST_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
    
    MOSAIC_SERVICE("ECATALOGUE_MOSAIC_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    SCHEDULER_SERVICE("ECATALOGUE_SCHEDULER_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    LOYALTY_ENGINE_ROUTER_SERVICE("LOYALTY_ENGINE_ROUTER_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	
	ASLP_LOYALTY_ENGINE("ASLP_LOYALTY_ENGINE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	ASLP_LOYALTY_ENGINE_3_8("ASLP_LOYALTY_ENGINE_3_8", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	PLE_LOYALTY_ENGINE("PLE_LOYALTY_ENGINE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	SALES_FORCE_LOYALTY_ENGINE("SALES_FORCE_LOYALTY_ENGINE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),
	
	BUSINESS_LOGIC_SERVICE("BUSINESS_LOGIC_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

	CEP_SERVICE("CEP_SERVICE", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50"),

    INTEGRATION_BRASPAG("ECATALOGUE_INTEGRATION_BRASPAG", "?maxConcurrentConsumers=200&idleConsumerLimit=10&maxMessagesPerTask=50");



	private ComponentQueueNameEnum(final String queueName, final String defaultConcurrentConsumers) {
		this.queueName = queueName;
		this.defaultConcurrentConsumers = defaultConcurrentConsumers;
	}
	
	private String queueName;
	private String defaultConcurrentConsumers;

	public String getQueueName() {
		return queueName + defaultConcurrentConsumers;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getDefaultConcurrentConsumers() {
		return defaultConcurrentConsumers;
	}

	public void setDefaultConcurrentConsumers(String defaultConcurrentConsumers) {
		this.defaultConcurrentConsumers = defaultConcurrentConsumers;
	}
	
}