package roteador.core.constants;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Santos
 *
 */
public enum ECatalogueTransaction {

    EXECUTE_LOGIN("executeLogin"),
    CHECK_RETRY_LOGIN("checkRetryLogin"),

    // AIMIA SYSTEMS LOYALTY PLATFORM -  ASLP (endeavour transactions)
    LOYALTY_ENGINE_GET_MEMBER_ID("loyaltyEngineGetMemberId"),
    LOYALTY_ENGINE_GET_MEMBER("loyaltyEngineGetMember"),
    LOYALTY_ENGINE_GET_MEMBER_BALANCE("loyaltyEngineGetMemberBalance"),
	LOYALTY_ENGINE_BASKET_REDEEM("loyaltyEngineRedeem"),
	LOYALTY_ENGINE_BASKET_MULTI_CURRENCIES_REDEEM("loyaltyEngineMultiCurrenciesRedeem"),
	LOYALTY_ENGINE_GET_MEMBER_INTERACTIONS("loyaltyEngineGetMemberInteractions"),
	LOYALTY_ENGINE_ENROL_MEMBER("loyaltyEngineEnrolMember"),
	LOYALTY_ENGINE_ENROL_MEMBER_PART2("loyaltyEngineEnrolMemberPart2"),
	LOYALTY_ENGINE_UPDATE_MEMBER("loyaltyEngineUpdateMember"),
	LOYALTY_ENGINE_UPDATE_MEMBER_ADDRESSES("loyaltyEngineUpdateMemberAddresses"),
	LOYALTY_ENGINE_GET_PROGRAM_TIER("loyaltyEngineGetProgramTier"),
	LOYALTY_ENGINE_GET_PROGRAM_SEGMENT("loyaltyEngineGetProgramSegment"),
	LOYALTY_ENGINE_GET_PROGRAM_CURRENCY("loyaltyEngineGetProgramCurrency"),
	
	FIND_LOYALTY_ENGINE_CONFIGURATION("findLoyaltyEngineConfiguration"),
    
	LOYALTY_ENGINE_FIND_AVAILABLE_POINTS("loaltyEngine_findAvailablePoints"),
    LOYALTY_ENGINE_FIND_AVAILABLE_EXPIRY_DATE_POINTS("loaltyEngine_findAvailableExpiryDatePoints"),
    LOYALTY_ENGINE_ACCRUAL("loaltyEngine_memberAccrual"),
    LOYALTY_ENGINE_ADJUSTUP("loaltyEngine_memberAdjustUp"),
    LOYALTY_ENGINE_REDEMPTION("loyaltyEngineRedeem"),
    LOYALTY_ENGINE_ADJUSTDOWN_N("loaltyEngine_memberAdjustDown_N"),
    LOYALTY_ENGINE_ADJUSTDOWN_DATE("loaltyEngine_memberAdjustDown_Date"),
    LOYALTY_ENGINE_VOID("loyaltyEngine_void"),
    LOYALTY_ENGINE_TRANSACTION_BY_ID("loaltyEngine_findTransactionById"),
    LOYALTY_ENGINE_REVERSION("loaltyEngine_reversion"),
    LOYALTY_ENGINE_REVERSION_NSU("loaltyEngine_reversionNSU"),

    ACCESS_VALIDATE("accessValidate"),

    SAVE_SUPPLIER("saveSupplier") ,
    DELETE_SUPPLIER("deleteSupplier") ,
    UPDATE_SUPPLIER("updateSupplier") ,
    FIND_SUPPLIERS("findSuppliers"),
    FIND_SUPPLIERS_ACTIVE("findSuppliersActive"),
    FIND_REMAINING_SUPPLIERS("findRemainingSuppliers"),
    FIND_REMAINING_SUPPLIERS_ACTIVE("findRemainingSuppliersActive"),
    DELETE_SUPPLIER_CONTACT("deleteSupplierContact"),
    FIND_SUPPLIER_CONTACT("findSupplierContact"),
    DELETE_SUPPLIER_CONTACT_ATTRIBUTE("deleteSupplierContactAttribute"),
    LIST_SUPPLIERS_REDEMPTION_DESCRIPTION("listSuppliersRedemptionDescription"),
    LIST_SUPPLIER_BY_ID_REDEMPTION_CHANNEL("listSupplierByIdRedemptionChannel"),

    FIND_SUPPLIER_BY_KEY("findSupplierByKey"),
    SAVE_SUPPLIER_CONTACT_ATTRIBUTE("saveSupplierContactAttribute"),
    SAVE_SUPPLIER_CONTACT("saveSupplierContact"),

    SAVE_USER("saveUser") ,
    DELETE_USER("deleteUser") ,
    UPDATE_USER("updateUser") ,
    UPDATE_USER_STATUS("updateUserStatus"),
    LIST_USERS("listUsers"),
    UPDATE_LOGGED("updateLogged"),
    SAVE_USER_CLIENT("saveUserClientCommand"),
    INSERT_USER_CLIENT("insertUserClient"),
    FIND_USER_BY_KEY("findUserByKey"),
    SAVE_USER_IMAGE("saveUserImage"),

    LIST_PROFILES("listProfiles"),
    SAVE_PROFILE("saveProfile"),
    UPDATE_PROFILE("updateProfile"),
    UPDATE_PROFILE_STATUS("updateProfileStatus"),
    DELETE_PROFILE("deleteProfile"),
    FIND_PROFILE("findProfileByKey"),
    LIST_ACCESS_RULE("listAccessRule"),
    SAVE_ACCESS_RULES("saveRules"),

    SAVE_CLIENT("saveClient") ,
    DELETE_CLIENT("deleteClient") ,
    LIST_CLIENTS("listClients"),
    FIND_CLIENT("findClient"),
    FIND_FULL_CLIENT("findFullClient"),
    UPDATE_CLIENT("updateClient"),
    UPDATE_CLIENT_STATUS("updateClientStatus"),
    SAVE_CLIENT_CONTACT_ATTRIBUTE("saveClientContactAttribute"),
    SAVE_CLIENT_CONTACT("saveClientContact"),
    DELETE_CLIENT_CONTACT("deleteClientContact"),
    FIND_CLIENT_CONTACT("findClientContact"),
    DELETE_CLIENT_CONTACT_ATTRIBUTE("deleteClientContactAttribute"),

    SAVE_MEMBER("saveMember"),
    LIST_MEMBER("listMember"),
    DELETE_MEMBER("deleteMember"),
    UPDATE_MEMBER("updateMember"),
    FIND_MEMBERS("findMembers"),
    SAVE_MEMBER_ACCESS("saveMemberAccess"),
    UPDATE_MEMBER_ACCESS("updateMemberAccess"),
    REMOVE_MEMBER_ACCESS_BY_PROGRAM("removeMemberAccessByProgram"),
    FIND_MEMBER_ACCESS("findMemberAccess"),
    FIND_MEMBER_BY_KEY("findMemberByKey"),
    SAVE_MEMBER_TOKEN("saveMemberToken"),
    UPDATE_MEMBER_TOKEN("updateMemberToken"),
    VALIDATE_MEMBER_TOKEN("validateMemberToken"),
    FIND_ADDRESS_TEMPLATE("FindAddressTemplate"),
    FIND_MEMBER_TOKEN("findMemberToken"),
    FIND_DELIVERY_ADDRESS("findDeliveryAddress"),
    FIND_ALL_MEMBER_DELIVERY_ADDRESS("findAllMemberDeliveryAddress"),
    LIST_DELIVERY_ADDRESS_BY_MEMBER("listDeliveryAddressByMember"),
    COPY_DELIVERY_ADDRESS_TO_ORDER_ITEM("copyDeliveryAddressToOrderItem"),
    RECOVERY_TOKEN("recoveryToken"),
    
    /**
     * Usado somente na API, pois retorna os dados (PRP) do participante sem o secondaryValue (password).
     */
    FIND_MEMBER_BY_TOKEN("findMemberByToken"),
    FIND_MEMBER_BY_PROPERTIES("findMemberByProperties"),
    
    VERIFY_RECOVERY_TOKEN_LINK("verifyRecoveryTokenLink"),

    
    RECOVERY_PASSWORD("recoveryPassword"),

    SAVE_PROGRAM("saveProgram") ,
    DELETE_PROGRAM("deleteProgram") ,
    LIST_PROGRAMS("listPrograms"),
    FIND_PROGRAM("findProgram"),
    UPDATE_PROGRAM("updateProgram"),
    LIST_ACTIVE_PROGRAMS("listActivePrograms"),
    SAVE_PROGRAM_SUPPLIER("saveProgramSupplier"),
    DELETE_PROGRAM_SUPPLIER("deleteProgramSupplier"),
    
    SAVE_PROGRAM_UI_PROPERTY("saveProgramUIProperty") ,
    DELETE_PROGRAM_UI_PROPERTY("deleteProgramUIProperty") ,
    LIST_PROGRAMS_UI_PROPERTIES("listProgramUIProperties"),
    FIND_PROGRAM_UI_PROPERTY("findProgramUIProperty"),
    UPDATE_PROGRAM_UI_PROPERTY("updateProgramUIProperty"),

    RUN_PROMOTION_BY_PRODUCT("runPromotionByProduct"),
    FIND_PROMOTIONS_BY_MEMBER("findPromotionsByMember"),
    FIND_PROMOTION_LOG_BY_PROMOTION_ID("findPromotionLogByPromotionId"),
    FIND_MEMBERS_BY_PROMOTION("findMembersByPromotion"),
    FIND_ACTIVE_PROMOTIONS("findActivePromotions"),
    SAVE_PROMOTION("savePromotion"),
    UPDATE_PROMOTION("updatePromotion"),
    FIND_PROMOTION("findPromotion"),
    FIND_INACTIVE_PROMOTIONS("findInactivePromotions"),
    UPDATE_STATUS_PROMOTION("updateStatusPromotion"),
    UPDATE_PRIORITY_PROMOTION("updatePriorityPromotion"),

    LOYALTY_ENGINE_CONNECTOR_LIST("listLoyaltyEngineConnector"),

    SAVE_SEGMENT("saveSegment") ,
    DELETE_SEGMENT("deleteSegment") ,
    LIST_SEGMENTS("listSegments"),
    FIND_SEGMENT("findSegment"),
    LIST_SEGMENTS_BY_SOURCE_ID("listSegmentsBySourceId"),
    UPDATE_SEGMENT("updateSegment"),
    IMPORT_SEGMENT("importSegment"),
    
    IMPORT_CURRECY("importCurrency"),

    SAVE_DEPARTMENT("saveDepartment") ,
    DELETE_DEPARTMENT("deleteDepartment") ,
    LIST_DEPARTMENTS("listDepartments"),
    FIND_DEPARTMENT("findDepartment"),
    UPDATE_DEPARTMENT("updateDepartment"),
    SAVE_CATALOG("saveCatalog") ,
    DELETE_CATALOG("deleteCatalog") ,
    LIST_CATALOGS("listCatalogs"),
    FIND_CATALOG("findCatalog"),
    UPDATE_CATALOG("updateCatalog"),
    FIND_ACTIVE_CATALOGS("findActiveCatalogs"),

    SAVE_PRODUCT("saveProduct"),
    NEW_PRODUCT("newProduct"),
    LIST_PRODUCTS("listProducts"),
    LIST_PRODUCTS_PARAMETER("listProductsParameter"),
    DELETE_PRODUCT("deleteProduct"),
    UPDATE_PRODUCT("updateProduct"),
    FIND_PRODUCTS("findProducts"),
    FIND_PRODUCT("findProduct"),
    INSERT_PRODUCT_CATEGORY("insertProductCategory"),
    LIST_CATALOG_PRODUCTS("listCatalogProducts"),
    FIND_CATALOG_PRODUCT("findCatalogProduct"),
    DELETE_CATALOG_PRODUCT("deleteCatalogProduct"),
    PUBLISH_PRODUCT("publish_product"),
    UPDATE_ALL_CATALOG_PRODUCT("updateAllCatalogProduct"),
    UPDATE_ALL_CATALOG_CHECKING_PRODUCT_CATALOGUES("updateAllCatalogCheckingProductCatalogues"),
    SAVE_SUPPLIERS_CATEGORY_PRODUCTS("saveSuppliersCategoryProducts"),
    SAVE_SUPPLIERS_CATEGORY("saveSuppliersCategory"),



    FIND_SKU("findSku"),
    CALCULATE_CART("calculateCart"),
    INSERT_CART_ITEM("insertCartItem"),
    AUTENTICATE_MEMBER_CART("autenticateMemberCart"),
    CREATE_ORDER("createOrder"),
    SEARCH_ORDER_STATUS("searchOrderStatus"),
    REMOVE_CART_ITEM("removeCartItem"),
    CHECK_ORDER_STATUS_IN_CART("checkOrderStatusInCart"),
    FIND_ORDER("findOrder"),
    FIND_ORDER_BY_ID("findOrderById"),
    FIND_ORDERS_BY_IDS("findOrdersByIds"),
    RESUME_ORDER("resumeOrder"),
    FIND_ORDER_BY_PERIOD("findOrderByPeriod"),
    FIND_ORDER_BY_PERIOD_AND_MEMBER("findOrderByPeriodAndMember"),
    FIND_ORDER_BY_PROGRAM_MEMBER("findOrderByProgramMember"),
    FIND_ORDER_BY_KEY("findOrderByKey"),
    COUNT_ORDER("countOrder"),
    COUNT_ORDER_BY_MEMBER("countOrderByMember"),
    COUNT_CART_ITENS("countCartItens"),
    FIND_ORDER_AUTOCOMPLETE("findOrderAutocomplete"),

    ADD_WISHLIST_ITEM("addWishlistItem"),
    IS_ITEM_IN_WISHLIST("isItemInWishList"),
    FIND_ORDER_ITEM_BY_ORDER_ID("findOrderItemByOrderId"),
    FIND_ORDER_ITEM_BY_ORDER_IDS("findOrderItemByOrderIds"),
    FIND_CATALOG_SKU_BY_ORDER_SKU("findCatalogueSkuByOrderSku"),
    FIND_LOG_BY_ORDER_ITEM_ID("findLogByOrderItemId"),
    FIND_LOG_BY_ORDER_ITEM_IDS("findLogByOrderItemIds"),
    REMOVE_ORDER_ITEM("removeOrderItem"),

    REMOVE_WISHLIST_ITEM("removeWishlistItem"),
    SEARCH_WISHLIST("searchWishlist"),


    SAVE_REDEMPTION_CHANNEL("saveRedemptionChannel") ,
    DELETE_REDEMPTION_CHANNEL("deleteRedemptionChannel") ,
    LIST_REDEMPTION_CHANNEL("listRedemptionChannel"),
    FIND_REDEMPTION_CHANNEL("findRedemptionChannel"),
    UPDATE_REDEMPTION_CHANNEL("updateRedemptionChannel"),

    SAVE_PRICING_OFFER("savePricingOffer") ,
    DELETE_PRICING_OFFER("deletePricingOffer") ,
    LIST_PRICING_OFFERS("listPricingOffers"),
    FIND_PRICING_OFFER("findPricingOffer"),
    UPDATE_PRICING_OFFER("updatePricingOffer"),
    UPDATE_PRICING_OFFER_PRIORITY("updatePricingOfferPriority"),

    SAVE_PRICING_RULE("savePricingRule") ,
    DELETE_PRICING_RULE("deletePricingRule") ,
    LIST_PRICING_RULES("listPricingRules"),
    FIND_PRICING_RULE("findPricingRule"),
    UPDATE_PRICING_RULE("updatePricingRule"),
    UPDATE_PRICING_RULE_PRIORITY("updatePricingRulePriority"),

    RUN_PRICING_RULES("runPricingRules"),
        
    LIST_CURRENCY_BY_PROGRAM("listCurrencyByProgram"),
    LIST_CURRENCY_BY_PROGRAM_WITHOUT_MAIN("listCurrencyByProgramWithoutMain"),
    UPDATE_MAIN_CURRENCY("updateMainCurrency"),
    UPDATE_CURRENCY("updateCurrency"),
    SAVE_CURRENCY("saveCurrency"),
    FIND_CURRENCY("findCurrency"),

    SAVE_PROGRAM_ADJUST_FACTOR_RULE("saveProgramAdjustFactorRule"),
    UPDATE_PROGRAM_ADJUST_FACTOR_RULE("updateProgramAdjustFactorRule"),
    UPDATE_PROGRAM_ADJUST_FACTOR_RULE_PRIORITY("updateProgramAdjustFactorRulePriority"),
    DELETE_PROGRAM_ADJUST_FACTOR_RULE("deleteProgramAdjustmentFactorRule"),
    FIND_ADJUST_FACTOR_BY_STATUS("findAdjustFactorByStatus"),
    FIND_ADJUST_FACTOR_BY_ID("findAdjustFactorById"),
    FIND_ADJUST_FACTOR_LOG("findAdjustFactorLog"),
    LIST_PROGRAM_AUTOCOMPLETE("listProgramAutocomplete"),


    PRODUCTS_IMPORT("productsImport"),
    SAVE_SKU("saveSku"),

    UPDATE_SKUS_SUPPLIER("updateSkusSupplier"),

    IMAGES_IMPORT("imagesImport"),

    LIST_CATEGORIES("listCategories"),
    LIST_CATEGORIES_ACTIVE("listCategoriesActive"),
    LIST_SUPPLIER_CATEGORIES("listSupplierCategories"),
    FIND_CATEGORY("findCategory"),
    SAVE_CATEGORY("saveCategory"),
    SAVE_CATEGORY_PRIORITY("saveCategoryPriority"),
    DELETE_CATEGORY("deleteCategory"),
    UPDATE_CATEGORY("updateCategory"),
    UPDATE_CATEGORY_STATUS("updateCategoryStatus"),

    LIST_STATIC_PAGES("listStaticPages"),
    FIND_STATIC_PAGE("findStaticPage"),
    FIND_STATIC_PAGES_LOG("findStaticPagesLog"),
    SAVE_STATIC_PAGE("saveStaticPage"),
    UPDATE_STATIC_PAGE("updateStaticPage"),

    SAVE_SCHEDULER("saveScheduler") ,
    DELETE_SCHEDULER("deleteScheduler") ,
    LIST_SCHEDULERS("listSchedulers"),
    FIND_SCHEDULER("findScheduler"),
    LIST_ALL_SCHEDULER_RUNNING("listAllSchedulerRunning"),
    UPDATE_SCHEDULER("updateScheduler"),
    FIND_SCHEDULER_LOG("findSchedulerLog"),

    AUTHENTICATE_MEMBER("authenticateMember"),
    AUTHENTICATE_MEMBER_CART("autenticateMemberCart"),
    
    ACCRUAL_OF_POINTS("accrualOfPoints"),
    SAVE_CATALOG_ANNOUNCEMENT("saveCatalogAnnouncement"),
    FIND_CATALOG_ANNOUNCEMENT("findCatalogAnnouncement"),
    DELETE_CATALOG_ANNOUNCEMENT("deleteCatalogAnnouncement"),
    UPDATE_CATALOG_ANNOUNCEMENT("updateCatalogAnnouncement"),

    @Deprecated
    RUN_MOSAIC_BY_PROGRAM_ID("runMosaicByProgramId"),
    LOAD_MOSAIC_LIVE("loadMosaicLive"),
    BUILD_MOSAIC_LIVE("buildMosaicLive"),

    SAVE_PROGRAM_MOSAIC("saveProgramMosaic"),
    SAVE_PROGRAM_MOSAIC_MODEL("saveProgramMosaicModel"),
    SAVE_PROGRAM_MOSAIC_HIGHLIGHT("saveProgramMosaicHighlight"),
    SAVE_PROGRAM_MOSAIC_MODEL_HIGHLIGHTS("saveProgramMosaicModelHighlights"),

    FIND_PROGRAM_MOSAIC_BY_PROGRAM_ID("findProgramMosaicByProgramId"),
    FIND_MOSAIC_MODEL_HIGHLIGHTS_BY_MOSAIC_MODEL_ID("findMosaicModelHighlightsByMosaicModelId"),
    FIND_PROGRAM_MOSAIC_MODELS_BY_MOSAIC_ID("findProgramMosaicModelByMosaicId"),
    FIND_MOSAIC_HIGHLIGHTS_BY_MOSAIC_ID("findMosaicHighlightsByMosaicId"),
    FIND_MOSAIC_HIGHLIGHTS_ACTIVE_BY_MOSAIC_ID("findMosaicHighlightsActiveByMosaicId"),
    FIND_MOSAIC_HIGHLIGHT_BY_ID("findMosaicHighlightById"),

    UPDATE_PROGRAM_MOSAIC("updateProgramMosaic"),
    UPDATE_PROGRAM_MOSAIC_MODEL("updateProgramMosaicModel"),
    UPDATE_PROGRAM_MOSAIC_HIGHLIGHT("updateProgramMosaicHighlight"),
    UPDATE_PROGRAM_MOSAIC_FULL("updateProgramMosaicFull"),

    AUTHENTICATE_REWARD_PROVIDER_USER("authenticateRewardProviderUser"),

    SEND_CURRENT_ACCOUNT_MESSAGE("sendCurrentAccountMessage"),
    
    SEND_MEMBER_ORDER_VALIDATION("sendMemberOrderValidation"),
    VERIFY_MEMBER_ORDER_VALIDATION("verifyMemberOrderValidation"),
    
    FIND_CROSS_SELL("findCrossSell"),
    UPDATE_CROSS_SELL_PRIORITY("updateCrossSellPriority"),
    UPDATE_CROSS_SELL_STATUS("updateCrossSellStatus"),
    UPDATE_CROSS_SELL_DESCRIPTION("updateCrossSellDescription"),
    FIND_CROSS_SELL_LOG("findCrossSellLog"),
    
	SCHEDULER_UPDATE_STATUS("updateStatusImportScheduler"),
	UPDATE_PRIORITY_CROSS_SELL("updatePriorityCrossSell"),
	ENROLL_MEMBER("enrollMember"),
	VALIDATE_UNIQUE_TOKENS("validateUniqueTokens"),
	FIND_SUPPLIER_TRACKING_BY_SUPPLIER_AND_CODE("findSupplierTrackingBySupplierAndCode"),
	UPDATE_MEMBER_MESSAGE_READ_STATUS("updateMemberMessageReadStatus"),
	FIND_MESSAGES_NOT_READ_BY_MEMBER("findMessagesNotReadByMember"),
	SAVE_DELIVERY_ADDRESS("saveDeliveryAddress"),


    ACCOUNTING_RECONCILIATION("accountingReconciliation"),

    ACCOUNTING_VALIDATE_NOVAPONTOCOM("accountingValidateNovaPontoCom"),
    ACCOUNTING_VALIDATE_CENTAURO("accountingValidateCentauro"),
    ACCOUNTING_VALIDATE_WALMART("accountingValidateWalmart"),
    
    // Business Logic - Jboss Drools
    BUSINESS_SERVICE("businessService"),
    FIND_CEP("findCep"),


    VALIDATE_FILE("validateFile"),

    //INTEGRATION BRASPAG
    AUTHORIZE_TRANSACTION_BRASPAG("authorizeTransactionBraspag"),
    CAPTURE_CREDIT_CARD_BRASPAG("captureCreditCardBraspag"),
    VOID_CREDIT_CARD_BRASPAG("voidCreditCardBraspag"),
    REFUND_CREDIT_CARD_BRASPAG("refundCreditCardBraspag"),
    
    // FAQ
    FAQ_LIST("listFaq"),
    FAQ_LIST_BY_FILTER("listFaqByFilter"),
    FAQ_FIND("findFaq"),
    FAQ_INSERT("insertFaq"),
    FAQ_UPDATE("updateFaq"),
    FAQ_DELETE("deleteFaq"),
    FAQ_LIST_CATEGORIES("listFaqCategories"),
    UPDATE_PRIORITY_FAQ("updatePriorityFaq"),
    
    // TIERs of the dragon
    TIER_LIST_ALL("listAllTier"),
    TIER_FIND("findTier"),
    TIER_FIND_BY_SOURCE_ID("findTierBySourceId"),
    TIER_SAVE("saveTier"),
    TIER_UPDATE("updateTier"),
    TIER_IMPORT("importTier"),
    TIER_UPDATE_STATUS("updateTierStatus"),
    
    POST_ID_ORDER_SALES_FORCE("postIdOrder"),
    
    FIND_CLIENT_SUPPLIER_CONFIGURATION_BY_ID("findClientSupplierConfigurationById"),
    SAVE_CLIENT_SUPPLIER_CONFIGURATIONS("saveClientSupplierConfigurations"),
    UPDATE_CLIENT_SUPPLIER_CONFIGURATIONS("updateClientSupplierConfigurations"),
    CHANGE_PROPERTIE_CENTAURO("changePropertiesCentauro"),
    
    LIST_MAIN_CURRENCIES("listMainCurrencies"),
    LIST_NOT_MAIN_CURRENCIES("listNotMainCurrencies"),
    LIST_PROGRAM_CURRENCIES("listProgramCurrencies"),
    ;

    private String chave;

	private ECatalogueTransaction(final String chave) {
		this.chave = chave;
	}

	public String getChave() {
		return chave;
	}

    public static ECatalogueTransaction getPorNome(final String nomeTransacao) {
        for(final ECatalogueTransaction transacao : ECatalogueTransaction.values()) {
            if(transacao.getChave().equals(nomeTransacao)) {
                return transacao;
            }
        }
        return null;
    }


    public static List<ECatalogueTransaction> getTransacoesPorNome(final String nomeTransacao) {
        final List<ECatalogueTransaction> transacoes = new ArrayList<ECatalogueTransaction>();
        for(final ECatalogueTransaction transacao : ECatalogueTransaction.values()) {
            if(transacao.getChave().equals(nomeTransacao)) {
                transacoes.add(transacao);
            }
        }
        return transacoes;
    }

}
