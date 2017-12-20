package com.olx.controller;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import com.olx.model.Product;
import com.olx.model.ProductDtoRes;
import com.olx.model.User;
import com.olx.model.UserDtoReq;
import com.olx.model.UserDtoRes;

public class UserDao implements IUserDao {
	public Connection con;
	private Statement stmt;
public UserDao(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/OLX","root","root");
	
		stmt= con.createStatement();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Error in connection with db");
		e.printStackTrace();
	}
		
}
	@Override
	public Set<UserDtoRes> findAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		Set<UserDtoRes> users = new HashSet<UserDtoRes>();
		try {
			UserDtoRes user = new UserDtoRes();
			User userr = new User();
			rs = stmt.executeQuery("select * from user");
			while(rs.next()){
				userr.setId(rs.getInt(1));
				userr.setName(rs.getString(2));
				userr.setPassword(rs.getString(3));
				userr.setEmail(rs.getString(4));
				userr.setPhone(rs.getInt(5));
				userr.setCity(rs.getString(6));
				userr.setAddress(rs.getString(7));
				user.setUser(userr);
				user.setResult(true);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return users;
	}
	@Override
	public Set<ProductDtoRes> findAllProducts(UserDtoReq user) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Set<ProductDtoRes> products = new HashSet<ProductDtoRes>();
		try {
			
			Product product = new Product();
			ProductDtoRes productt = new ProductDtoRes();
			rs = stmt.executeQuery("select product.id,product.name,price,date,desc from user , product where user.id=product.user_id and user.name = '"+user.getName()+"'");
			while(rs.next()){
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDate(rs.getString(4));
				product.setDescreption(rs.getString(5));
				productt.setProduct(product);
				productt.setResult(true);
				products.add(productt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return products;
	}
	@Override
	public UserDtoRes create(User user) {
		// TODO Auto-generated method stub
		UserDtoRes res= new UserDtoRes();
		try {
			int ret = stmt.executeUpdate("insert into user (name,password,email,city,address,phone) values( '"+user.getName()+"' , '"+ user.getPassword()+"' , '"+ user.getEmail()+"' , '"+ user.getCity()+"' , '"+ user.getAddress()+"' , '"+ user.getPhone() +"'"+")");
			if(ret==1){
				res.setResult(true);
			}else
			{
				res.setResult(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDtoRes find(String name) {
		ResultSet rs;
		UserDtoRes userr = new UserDtoRes();
		try {
			User user = new User();
			rs = stmt.executeQuery("select name,password,city,address,phone,email from user where user.name = '"+name+"'");
			
			while(rs.next()){
				user.setName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setCity(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setPhone(rs.getInt(5));
				user.setEmail(rs.getString(6));
				userr.setUser(user);
				userr.setResult(true);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return userr;
	}

	@Override
	public User update(UserDtoReq user) {
		// TODO Auto-generated method stub
		return null;
	}
public void close(){
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
		
	





	
		
		

			
	




		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

