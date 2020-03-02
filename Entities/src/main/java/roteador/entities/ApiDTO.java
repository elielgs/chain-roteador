package roteador.entities;

import java.io.Serializable;

public class ApiDTO implements Serializable {
	
	private static final long serialVersionUID = 90762244672918597L;
	private String id;
	private String endpoint;
	private String title;
	private String description;
	private boolean active;
	private APIVersionDTO[] apiVersionDTO;
	
	
	public APIVersionDTO[] getApiVersionDTO() {
		return apiVersionDTO;
	}
	public void setApiVersionDTO(APIVersionDTO[] apiVersionDTO) {
		this.apiVersionDTO = apiVersionDTO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
