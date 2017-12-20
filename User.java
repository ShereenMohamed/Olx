package com.olx.model;

import java.util.Set;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private int phone;
	private String city;
	private String address;
	private Set<Product> products;

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public User(){
		
	}
	public User(String name, String password,String email,int phone,String city,String address){
		this.name=name;
		this.password=password;
		this.email=email;
		this.phone=phone;
		this.city=city;
		this.address=address;
	}
	public User(String name){
		this.name=name;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
