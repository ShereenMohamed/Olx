package com.olx.controller;

import java.util.Set;

import com.olx.model.Product;
import com.olx.model.ProductDtoReq;
import com.olx.model.ProductDtoRes;
import com.olx.model.User;
import com.olx.model.UserDtoReq;
import com.olx.model.UserDtoRes;
import com.olx.view.Login;


public class ProductController  {
	public ProductController(){
		this.productDao=new ProductDao();
	}
	private ProductDao productDao;
	private UserDao userDao;
   

    User userr;
    public boolean addproduct(Product product) {
    	
    	
    	
    	
    	Set<ProductDtoRes> ProductRes =  productDao.findAllProducts(new UserDtoReq(userr.getName(),userr.getPassword()));
    			
        if(((ProductDtoRes) ProductRes).isResult()){
            //if product already exists
            return false;
        }else{
        	
			productDao.create1(product);
            return true;
          
      
        }}
    
    
        
        

        
        public void close(){
        	
        	userDao.close();
        }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
    
   
    

}











