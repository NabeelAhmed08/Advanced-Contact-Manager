package com.org.app.exception;


public class ContactNotFoundException extends Exception {

	public ContactNotFoundException() {
		super("Contact Not Found");
	}
	public ContactNotFoundException(String msg) {
		super(msg);
	}
}
