package com.mebcorp.articleApp.models;

public class Response {
	private int status;
	private Object data;
	
	public Response() {
	}

	public Response(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
