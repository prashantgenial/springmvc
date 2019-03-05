package com.babbyunplugged.example;

public class Rpt {

	private String name ;
	private String content ;
	
	public Rpt() {}
	
	public Rpt(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
