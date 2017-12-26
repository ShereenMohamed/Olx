package com.olx.model;



public class Product {
	private int id;
	private String name;
	private String date;
	private double price;
	private Category category;
	private String descreption;
	private User user;
	private String image;
	private String status;
	public Product( String name, String date, double price,Category category, String descreption,User user,
			String image) {
		this.name = name;
		this.date = date;
		this.price = price;
		this.category=category;
		this.descreption = descreption;
		this.user =user;
		this.image = image;
		
	}
	public Product( ){}
	
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
	public String  getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
