package com.olx.controller;

import java.util.Set;

import com.olx.model.Category;
import com.olx.model.CategoryDtoReq;
import com.olx.model.Product;
import com.olx.model.ProductDtoRes;
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

	
	
	public Set<Product> ListOfProducts(CategoryDtoReq categ){
		Set<Product> products = productController.ListOfProducts(categ);
		return products;
	}
    public Product getProductById(int id) {
		Product product = new Product();
		product=productController.getProductById(id).getProduct();
		return product;
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
	

	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
