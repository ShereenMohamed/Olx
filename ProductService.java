package com.olx.controller;

import com.olx.model.Product;
import com.olx.model.UserDtoReq;
import com.olx.model.UserDtoRes;

public class ProductService {
	public ProductService(){
		this.productController=new ProductController();
		this.result= new Result();
	}
	private ProductController productController;
	private Result result;
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}

	
	
	

	public boolean AddProduct(Product product){

		boolean AddProduct= productController.addproduct(product);
		if(AddProduct == false){
			result.setMessage("Product already exists");
			
		}else
		{
			result.setMessage("Product added successfully");
		}
		result.setResult(AddProduct);
		return AddProduct;}




	 
}
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
