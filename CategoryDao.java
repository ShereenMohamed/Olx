package com.olx.controller;


import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;

import com.olx.model.Category;
import com.olx.model.CategoryDtoRes;




public class CategoryDao implements ICategoryDao{
	public Connection con;
	private Statement stmt;
	
	public Set<CategoryDtoRes> findAll() {
		ResultSet rs;
		Set<CategoryDtoRes> categories = new HashSet<CategoryDtoRes>();
		try {
			CategoryDtoRes categoryy = new CategoryDtoRes();
			Category category = new Category();
			rs = stmt.executeQuery("select id,name from category");
			while(rs.next()){
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				categoryy.setCategory(category);
				categoryy.setResult(true);
				categories.add(categoryy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
		
		
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
