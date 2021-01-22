package com.email.model;

public class EmailRequest {

 private String to;
 private String subject;
 private String message;
 
public EmailRequest(String to, String subject, String message) {
	super();
	this.to = to;
	this.subject = subject;
	this.message = message;
}

public EmailRequest() {
	super();
}

public String getto() {
	return to;
}

public void setto(String to) {
	this.to = to;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

@Override
public String toString() {
	return "EmailRequest [to=" + to + ", subject=" + subject + ", message=" + message + "]";
}
 
 
	
}
