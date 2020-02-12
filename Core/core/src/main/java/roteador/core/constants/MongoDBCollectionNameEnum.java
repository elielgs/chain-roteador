package roteador.core.constants;

/**
 * 
 * @author Mauricio Santos
 *
 */
public enum MongoDBCollectionNameEnum {

    COLLECTION_IMPORTACAO_COMPRAFACIL("importacao_produto_comprafacil"),
    COLLECTION_CATALOGO_COMPRAFACIL("catalogo_comprafacil"),
    COLLECTION_AUTH_WS_COMPRAFACIL("auth_ws_comprafacil"),
    COLLECTION_PROTOCOL_COMPRAFACIL("protocol_comprafacil"),
	
	COLLECTION_IMPORTACAO_PRODUTO_NOVAPONTOCOM_CASAS_BAHIA("importacao_produto_novapontocom_casas_bahia"),
    COLLECTION_IMPORTACAO_PRODUTO_NOVAPONTOCOM_PONTO_FRIO("importacao_produto_novapontocom_ponto_frio"),
    COLLECTION_IMPORTACAO_PRODUTO_NOVAPONTOCOM_EXTRA("importacao_produto_novapontocom_extra"),
	COLLECTION_IMPORTACAO_DISPONIBILIDADE_NOVAPONTOCOM_CASAS_BAHIA("importacao_disponibilidade_novapontocom_casas_bahia"),
    COLLECTION_IMPORTACAO_DISPONIBILIDADE_NOVAPONTOCOM_PONTO_FRIO("importacao_disponibilidade_novapontocom_ponto_frio"),
    COLLECTION_IMPORTACAO_DISPONIBILIDADE_NOVAPONTOCOM_EXTRA("importacao_disponibilidade_novapontocom_extra"),
	COLLECTION_IMPORTACAO_CATEGORIA_NOVAPONTOCOM_CASAS_BAHIA("importacao_categoria_novapontocom_casas_bahia"),
    COLLECTION_IMPORTACAO_CATEGORIA_NOVAPONTOCOM_PONTO_FRIO("importacao_categoria_novapontocom_ponto_frio"),
    COLLECTION_IMPORTACAO_CATEGORIA_NOVAPONTOCOM_EXTRA("importacao_categoria_novapontocom_extra"),
	COLLECTION_IMPORTACAO_FRETE_PONDERADO_NOVAPONTOCOM("importacao_frete_ponderado_novapontocom"),
    COLLECTION_IMPORTACAO_PRODUTO_POLISHOP("importacao_produto_polishop"),

    COLLECTION_IMPORTACAO_PRODUTO_CATALOGO_FASTSHOP("importacao_produto_catalogo_fastshop"),
	
	COLLECTION_IMPORTACAO_PEDIDO_WALMART("importacao_pedido_walmart"),
	COLLECTION_IMPORTACAO_PRODUTO_WALMART("importacao_produto_walmart"),

    COLLECTION_IMPORTACAO_PRODUTO_CENTAURO("importacao_produto_centauro"),
    COLLECTION_IMPORTACAO_DISPONIBILIDADE_CENTAURO("importacao_disponibilidade_centauro"),
    COLLECTION_AUTH_WS_CENTAURO("auth_ws_centauro"),
    
    COLLECTION_IMPORTACAO_DISPONIBILIDADE_MAGAZINE_LUIZA("importacao_disponibilidade_magazineluiza"),
    COLLECTION_IMPORTACAO_PRODUTO_MAGAZINE_LUIZA("importacao_produto_magazineluiza"),
    COLLECTION_AUTH_WS_MAGAZINE_LUIZA("auth_ws_magazineluiza"),
	
	COLLECTION_SUPPLIERS("suppliers"),
	COLLECTION_CLIENTS("clients"),
	COLLECTION_PROGRAMS("programs"),
	COLLECTION_CATEGORIES("categories"),
	COLLECTION_PRODUCT_INDEX("products"),

    COLLECTION_PROGRAM_ADJUST_FACTOR_LOG("program_adjust_factor_log"),
    COLLECTION_PRICING_LOG("pricing_log"),
    COLLECTION_PRODUCT_IMPORT_LOG("product_import_log"),
    COLLECTION_AVAILABILITY_LOG("product_availability_log"),
	
    COLLECTION_CATEGORIES_PRISMAH("catalogo_categories_prismah"),

	COLLECTION_CATALOGO_PRISMAH("catalogo_produto_prismah"),
	
	COLLECTION_BUSINESS_LOGIC_LOG("business_logic_log"),
	COLLECTION_BUSINESS_LOGIC_NOTIFICATION("business_logic_notification");



    private MongoDBCollectionNameEnum(String name) {
		this.name = name;
	}
	
	private String name;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
