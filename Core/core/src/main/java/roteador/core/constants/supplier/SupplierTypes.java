package roteador.core.constants.supplier;

public enum SupplierTypes {
	//MAGAZINE_LUIZA
	// Every Friday 11:45 am
	MAGAZINE_LUIZA_FULL("MAGAZINE_LUIZA_FULL", "quartz://timerMagazineLuizaFull?cron=0+45+11+?+*+FRI+*"),
	
	// Daily
    MAGAZINE_LUIZA_PARTIAL("MAGAZINE_LUIZA_PARTIAL", "quartz://timerMagazineLuizaPartial?cron=0+0+0+1/1+*+?+*"),
    
	//CENTAURO
	// Every Friday 11:45 am
	CENTAURO_FULL("CENTAURO_FULL", "quartz://timerCentauroFull?cron=0+45+11+?+*+FRI+*"),
	
	// Daily
    CENTAURO_PARTIAL("CENTAURO_PARTIAL", "quartz://timerCentauroPartial?cron=0+0+0+1/1+*+?+*"),
    
    //COMPRAFACIL
	// All saturday 2am
    COMPRAFACIL_FULL("COMPRAFACIL_FULL", "quartz://timerComprafacilFull?cron=0+0+2+?+*+SAT"),
    
    // all day 5am
    COMPRAFACIL_LIGHT("COMPRAFACIL_LIGHT", "quartz://timerComprafacilLight?cron=0+0+5+1/1+*+?+*"),
    
    // hourly
    COMPRAFACIL_INCREMENTAL("COMPRAFACIL_INCREMENTAL", "quartz://timerComprafacilIncremental?cron=0+0+0/1+1/1+*+?+*"),
    
    // all day 6am
    COMPRAFACIL_PRODUTO("COMPRAFACIL_PRODUTO", "quartz://timerComprafacilProduto?cron=0+0+6+1/1+*+?+*"),
    
	//NOVAPONTOCOM
    CASAS_BAHIA_FULL("CASAS_BAHIA_FULL", "quartz://timerCasasBahiaFull?cron=0+45+11+?+*+FRI"),
    CASAS_BAHIA_PARTIAL("CASAS_BAHIA_PARTIAL", "quartz://timerCasasBahiaPartial?cron=0+00+05+?+*+?"),
    PONTO_FRIO_FULL("PONTO_FRIO_FULL", "quartz://timerPontoFrioFull?cron=0+45+11+?+*+FRI"),
    PONTO_FRIO_PARTIAL("PONTO_FRIO_PARTIAL", "quartz://timerPontoFrioPartial?cron=0+00+05+?+*+?"),
    EXTRA_FULL("EXTRA_FULL", "quartz://timerExtraFull?cron=0+45+11+?+*+FRI"),
    EXTRA_PARTIAL("EXTRA_PARTIAL", "quartz://timerExtraPartial?cron=0+00+05+?+*+?"),

    CASAS_BAHIA_CATEGORY("CASAS_BAHIA_CATEGORY", "quartz://timerCategoryCasasBahia?cron=0+00+05+?+*+?"),
    PONTO_FRIO_CATEGORY("PONTO_FRIO_CATEGORY", "quartz://timerCategoryPontoFrio?cron=0+00+05+?+*+?"),
    EXTRA_CATEGORY("EXTRA_CATEGORY", "quartz://timerCategoryExtra?cron=0+00+05+?+*+?"),

    CASAS_BAHIA_FREIGHT("CASAS_BAHIA_FREIGHT", "quartz://timerFreightCasasBahia?cron=0+00+05+?+*+?"),
    PONTO_FRIO_FREIGHT("PONTO_FRIO_FREIGHT", "quartz://timerFreightPontoFrio?cron=0+00+05+?+*+?"),
    EXTRA_FREIGHT("EXTRA_FREIGHT", "quartz://timerFreightExtra?cron=0+00+05+?+*+?"),

    CASAS_BAHIA_AVAILABILITY("CASAS_BAHIA_AVAILABILITY", "quartz://timerAvailabilityCasasBahia?cron=0+0/6+00+?+*+?"),
    PONTO_FRIO_AVAILABILITY("PONTO_FRIO_AVAILABILITY", "quartz://timerAvailabilityPontoFrio?cron=0+0/6+00+?+*+?"),
    EXTRA_AVAILABILITY("EXTRA_AVAILABILITY", "quartz://timerAvailabilityExtra?cron=0+0/6+00+?+*+?"),

    //FASTSHOP
    FASTSHOP_FULL("FASTSHOP_FULL", "quartz://timerFullFastshop?cron=0+0+3+?+*+SUN+*"),
    FASTSHOP_AVAILABILITY("FASTSHOP_AVAILABILITY", "quartz://timerAvailabilityFastshop?cron=0+0+3+?+*+SUN+*"),

    //POLISHOP
    POLISHOP_FULL("POLISHOP_FULL", "quartz://timerPolishopFull?cron=0+0+3+?+*+SUN+*"),
    
    //WALMART
    /** Daily 12 a.m. (midnight) */
    WALMART_FULL("WALMART_FULL", "quartz://timerWalmartFull?cron=0+0+2+?+*+SAT+*"),
    
    /** Daily 8 a.m. */
    WALMART_PARTIAL("WALMART_PARTIAL", "quartz://timerWalmartPartial?cron=0+0+1+?+*+WED+*");

    private String typeName;
    private String scheduleTime;

    private SupplierTypes(String typeName, String scheduleTime) {
        this.typeName = typeName;
        this.scheduleTime = scheduleTime;
    }

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

    public static SupplierTypes getByTypeName(String typeName) {
        for (SupplierTypes novapontocomTypes : SupplierTypes.values()) {
            if (novapontocomTypes.typeName.equals(typeName)) {
                return novapontocomTypes;
            }
        }
        return null;
    }
    
}
