package com.evasoftwareautomation.framework;

public enum Urls {

	GOOGLE_HOME("https://www.google.com"), 
	WIKI_HOME("https://en.wikipedia.org"),
	GRID_HOME("http://hub:4444/wd/hub");

	private String url;

	private Urls(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}
