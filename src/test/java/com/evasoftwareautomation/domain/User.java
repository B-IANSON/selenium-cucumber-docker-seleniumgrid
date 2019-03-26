package com.evasoftwareautomation.domain;

import com.evasoftwareautomation.utils.Translator;

public class User {
	
	private String user;
	
	public User(String user) {
		this.user = user;
	}
	
	public String getCurrentUser() {
		return this.user;
	}
	
	public String getUserInterest() {
		String usersInterest = Users.valueOf(user).getInterest();
		String usersLanguage = Users.valueOf(user).getLanguage();
		return Translator.valueOf(usersInterest.toUpperCase()).getTranslation(usersLanguage);
	}
}
