package roteador.entities;

import java.io.Serializable;

public class APIVersionDTO implements Serializable {
	
	private static final long serialVersionUID = -2962800075145369937L;
	private String version;
	private String deployDate;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDate() {
		return deployDate;
	}
	public void setDate(String date) {
		this.deployDate = date;
	}
	
	

}
