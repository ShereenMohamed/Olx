package com.olx.controller;

import java.util.Set;

import com.olx.model.CategoryDtoReq;
import com.olx.model.Product;
import com.olx.model.ProductDtoReq;
import com.olx.model.ProductDtoRes;
import com.olx.model.User;
import com.olx.model.UserDtoReq;


public interface IProductDao {
	Set<ProductDtoRes> findAll();
	Set<ProductDtoRes> findAllProducts(CategoryDtoReq category);
	Set<ProductDtoRes> findAllProducts(UserDtoReq user);
    ProductDtoRes create(Product product);
    ProductDtoRes create1(Product product);
    boolean delete(String name);
    Product update(ProductDtoReq user);
	ProductDtoRes find(int id);
	ProductDtoRes updateProductStatus(int id);
}
