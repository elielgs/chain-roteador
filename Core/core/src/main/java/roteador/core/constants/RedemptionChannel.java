package roteador.core.constants;


public enum RedemptionChannel
{
	SMS(1),
	WEBSITE(2),
	CALL_CENTER(3);
    
    private Integer id;

    private RedemptionChannel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static RedemptionChannel getById(Integer id) {
        for (RedemptionChannel rc : RedemptionChannel.values()) {
            if (rc.getId().intValue() == id.intValue()) {
                return rc;
            }
        }
        return null;
    }
}
