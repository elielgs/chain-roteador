package roteador.service.mongo.model;

import java.util.List;

public class MembroOrganizacao {

	private String id;
	private String name;
	private String organizationName;
	private List<String> apis;

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

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public List<String> getApis() {
		return apis;
	}

	public void setApis(List<String> apis) {
		this.apis = apis;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", organizationName=" + organizationName + "]";
	}

}
