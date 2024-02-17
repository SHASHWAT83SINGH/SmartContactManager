package com.smart.helper;

public class Message {
 
	private String Content;
	private String type;
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Message(String content, String type) {
		super();
		Content = content;
		this.type = type;
	}
}
