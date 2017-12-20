package com.olx.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.olx.model.Category;
import com.olx.model.CategoryDtoReq;
import com.olx.model.Product;
import com.olx.model.ProductDtoReq;
import com.olx.model.ProductDtoRes;
import com.olx.model.User;
import com.olx.model.UserDtoReq;

public class ProductDao implements IProductDao{
	public Connection con;
	private Statement stmt;
	
	public ProductDao(){
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
	public Set<ProductDtoRes> findAll() {
		ResultSet rs;
		Set<ProductDtoRes> products = new HashSet<ProductDtoRes>();
		try {
			ProductDtoRes productt = new ProductDtoRes();
			Product product = new Product();
			rs = stmt.executeQuery("select product.id,product.name,product.date,price,descreption,user.name,product.image,product.status,category.name from product,user,category where user.id=product.user_id and product.categ_id=category.id");
			while(rs.next()){
				
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDate(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				product.setDescreption(rs.getString(5));
				product.setUser(new User(rs.getString(6)));
				product.setImage(rs.getString(7));
				product.setStatus(rs.getString(8));
				product.setCategory(new Category(rs.getString(9)));
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
	public Set<ProductDtoRes> findAllProducts(CategoryDtoReq category) {
		ResultSet rs;
		Set<ProductDtoRes> products = new HashSet<ProductDtoRes>();
		try {
			ProductDtoRes productt = new ProductDtoRes();
			Product product = new Product();
			rs = stmt.executeQuery("select product.id,product.name,product.date,price,descreption,user.name,product.image,product.status,category.name from product,user,category where user.id=product.user_id and product.categ_id=category.id and categ_id="+category.getId());
			while(rs.next()){
				
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDate(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				product.setDescreption(rs.getString(5));
				product.setUser(new User(rs.getString(6)));
				product.setImage(rs.getString(7));
				product.setStatus(rs.getString(8));
				product.setCategory(new Category(rs.getString(9)));
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
	public Set<ProductDtoRes> findAllProducts(UserDtoReq user) {
		ResultSet rs;
		Set<ProductDtoRes> products = new HashSet<ProductDtoRes>();
		try {
			ProductDtoRes productt = new ProductDtoRes();
			Product product = new Product();
			rs = stmt.executeQuery("select product.id,product.name,product.date,price,descreption,user.name,product.image,product.status,category.name from product,user,category where user.id=product.user_id and product.categ_id=category.id and user.name='"+user.getName()+"'");
			while(rs.next()){
				
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDate(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				product.setDescreption(rs.getString(5));
				product.setUser(new User(rs.getString(6)));
				product.setImage(rs.getString(7));
				product.setStatus(rs.getString(8));
				product.setCategory(new Category(rs.getString(9)));
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
	public ProductDtoRes create(Product product) {
		// TODO Auto-generated method stub
		ProductDtoRes res= new ProductDtoRes();
		try {
			int ret = stmt.executeUpdate("insert into product (name,price,categ_id,descreption,user_id,image,status) values( '"+product.getName()+"' , "+ product.getPrice()+" , "+ product.getCategory().getId()+" , '"+ product.getDescreption()+"' , "+ product.getUser().getId()+" , '"+ product.getImage()+"' ,  '"+ product.getStatus()+"')");
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
	public ProductDtoRes create1(Product product) {
		// TODO Auto-generated method stub
		ProductDtoRes res= new ProductDtoRes();
		try {
			int ret = stmt.executeUpdate("insert into product (name,price,descreption,image,status) values( '"+product.getName()+"' , '"+ product.getPrice()+"'  , '"+ product.getDescreption()+"'  , '"+ product.getImage()+"' ,  '"+ product.getStatus()+"')");
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
	public ProductDtoRes find(int id) {
		ResultSet rs;
		ProductDtoRes productt = new ProductDtoRes();
		Product product = new Product();
		try{
		rs = stmt.executeQuery("select product.id,product.name,product.date,price,descreption,user.name,product.image,product.status,category.name from product,user,category where user.id=product.user_id and product.categ_id=category.id and product.id="+id);
		while(rs.next()){
			
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setDate(rs.getString(3));
			product.setPrice(rs.getDouble(4));
			product.setDescreption(rs.getString(5));
			product.setUser(new User(rs.getString(6)));
			product.setImage(rs.getString(7));
			product.setStatus(rs.getString(8));
			product.setCategory(new Category(rs.getString(9)));
			productt.setProduct(product);
			productt.setResult(true);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return productt;
	}

	@Override
	public Product update(ProductDtoReq user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDtoRes updateProductStatus(int id) {
		ProductDtoRes res= new ProductDtoRes();
		try {
			int ret = stmt.executeUpdate("update product set status = 'approved' where product id = "+id);
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

}
