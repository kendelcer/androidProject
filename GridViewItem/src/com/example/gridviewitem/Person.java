package com.example.gridviewitem;

public class Person {
	
	private int image;
	private String name, couse ;
	public Person(int image, String name, String couse) {
		super();
		this.image = image;
		this.name = name;
		this.couse = couse;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return couse;
	}
	public void setCouse(String couse) {
		this.couse = couse;
	}

}
