package com.rest.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class API {
	private String method;
	private String url;
	private String description;
	
	
	public API(String method, String url, String description) {
		super();
		this.method = method;
		this.url = url;
		this.description = description;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "API [method=" + method + ", url=" + url + ", description=" + description + "]";
	}
	
}
