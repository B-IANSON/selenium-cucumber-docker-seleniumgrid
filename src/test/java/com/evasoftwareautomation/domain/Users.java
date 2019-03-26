package com.evasoftwareautomation.domain;

public enum Users {
	
	HANS_GRUBER("German", "Finance"),
	NICO_COLLARD("French", "Travel"),
	MIGUEL_SANCHEZ("Spanish", "Law");
	
	private String language;
	private String interest;
	
	private Users(String language, String interest) {
		this.language = language;
		this.interest = interest;
	}
	
	public String getLanguage() {
		return this.language;
	}
	
	public String getInterest() {
		return this.interest;
	}
}
