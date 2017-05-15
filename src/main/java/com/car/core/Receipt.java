package com.car.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Receipt {
	@Override
	public String toString() {
		return "Receipt [date=" + date + ", message=" + message + "]";
	}
	private String date;
	private String message;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
