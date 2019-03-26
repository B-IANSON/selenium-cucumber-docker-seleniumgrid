package com.evasoftwareautomation.utils;

public enum Translator {

	PAGE_TITLE("Wikipédia, l'encyclopédie libre", "Wikipedia, la enciclopedia libre",
			"Wikipedia – Die freie Enzyklopädie"),	
	FINANCE("La finance", "Financiar", "Finanzen"),
	TRAVEL("Voyage", "Viaje", "Reise"),
	LAW("Loi", "Ley", "Recht");

	private String french;
	private String spanish;
	private String german;

	private Translator(String french, String spanish, String german) {
		this.french = french;
		this.spanish = spanish;
		this.german = german;
	}

	public String getTranslation(String language) {
		switch (language) {
		case "French":
			return this.french;
		case "Spanish":
			return this.spanish;
		case "German":
			return this.german;
		default:
			return "";
		}
	}
}
