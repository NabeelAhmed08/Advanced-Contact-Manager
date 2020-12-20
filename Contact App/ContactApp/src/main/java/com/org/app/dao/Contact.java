package com.org.app.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name ="pno")
	private  String pno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", pno=" + pno + "]";
	}
	public Contact(int id, String name, String pno) {
		super();
		this.id = id;
		this.name = name;
		this.pno = pno;
	}
	public Contact() {
		super();
	}
	public Contact(String name, String pno) {
		super();
		this.name = name;
		this.pno = pno;
	}
	
	
	
}
