package roteador.entities;

import java.io.Serializable;

public class APIVersionDTO implements Serializable {
	
	private static final long serialVersionUID = -2962800075145369937L;
	private String version;
	private String deploy;
	private String status;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDeploy() {
		return deploy;
	}
	public void setDeploy(String deploy) {
		this.deploy = deploy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
