package roteador.service.mongo.model;

public class MembroOrganizacao {

	private String id;
	private String name;
	private String organizationName;
	private String[] apis;

	public MembroOrganizacao(String id, String name, String organizationName) {
		this.id = id;
		this.name = name;
		this.organizationName = organizationName;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String[] getApis() {
		return apis;
	}

	public void setApis(String[] apis) {
		this.apis = apis;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", organizationName=" + organizationName + "]";
	}

}
