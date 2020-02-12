package roteador.core.constants.member;

/**
 * 
 * @author Mauricio
 *
 */
public class TokenTypeTO {


	private String tokenTypeName;
	private Integer id;

	public TokenTypeTO(Integer id) {
		this.id = id;
	}
	
	public String getTokenTypeName() {
		return tokenTypeName;
	}

	public void setTokenTypeName(String tokenTypeName) {
		this.tokenTypeName = tokenTypeName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
