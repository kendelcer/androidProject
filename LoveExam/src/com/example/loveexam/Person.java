package com.example.loveexam;

public class Person {
	
	private int image;
	private String contactName, contactNumber;
	public Person(int image, String contactName, String contactNumber) {
		super();
		this.image = image;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
