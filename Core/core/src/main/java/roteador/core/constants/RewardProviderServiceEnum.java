package roteador.core.constants;

/**
 * 
 * @author Mauricio
 *
 */
public enum RewardProviderServiceEnum {

	LOGIN(1, "LOGIN", "Servico de Login"),
    ;
    
	private Integer id;
    private String name;
    private String description;

    private RewardProviderServiceEnum(final Integer id, final String name, final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
