package roteador.entities;

import java.io.Serializable;

public class APIVersionDocumentationDTO implements Serializable {

	private static final long serialVersionUID = 7284883852489907370L;
	
	private String id;
	private String revision_id;
	private String version;
	private String title;
	private String headline;
	private String content;
	private String portal;
	private String created_at;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRevision_id() {
		return revision_id;
	}
	public void setRevision_id(String revision_id) {
		this.revision_id = revision_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
