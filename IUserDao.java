package com.olx.controller;

import java.util.Set;

import com.olx.model.ProductDtoRes;
import com.olx.model.User;
import com.olx.model.UserDtoReq;
import com.olx.model.UserDtoRes;

public interface IUserDao {
	 Set<UserDtoRes> findAll();

	    UserDtoRes create(User user);

	    boolean delete(String name);

	    UserDtoRes find(String name);

	    User update(UserDtoReq user);


		Set<ProductDtoRes> findAllProducts(UserDtoReq user);  
}
