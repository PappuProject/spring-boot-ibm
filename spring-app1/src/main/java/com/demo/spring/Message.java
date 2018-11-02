package com.demo.spring;

public class Message {
	private String body;
	private String header;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String body, String header) {
		this.body = body;
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

}
