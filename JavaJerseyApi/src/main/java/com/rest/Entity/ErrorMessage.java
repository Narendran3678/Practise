package com.rest.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorStatus;
	private String errorDescription;
	private String documentation;
	public ErrorMessage(String errorStatus, String errorDescription, String documentation) {
		super();
		this.errorStatus = errorStatus;
		this.errorDescription = errorDescription;
		this.documentation = documentation;
	}
	public String getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	@Override
	public String toString() {
		return "ErrorMessage [errorStatus=" + errorStatus + ", errorDescription=" + errorDescription
				+ ", documentation=" + documentation + "]";
	}
	
}
