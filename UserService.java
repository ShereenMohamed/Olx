package com.olx.controller;

import com.olx.model.User;
import com.olx.model.UserDtoReq;

public class UserService {
	public UserService(){
		this.userController=new UserController();
		this.result= new Result();
	}
	private UserController userController;
	private Result result;
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public boolean login(String name , String passsword){
		UserDtoReq userReq = new UserDtoReq(name,passsword);
		boolean login= userController.loginUser(userReq);
		if(login == false){
			result.setMessage("Invalid Username or Password");
			
		}else
		{
			result.setMessage("User Logged in successfully");
		}
		result.setResult(login);
		return login;
	}
	public boolean register(User user){

		boolean register= userController.registerUser(user);
		if(register == false){
			result.setMessage("User already exists");
			
		}else
		{
			result.setMessage("User Registered successfully");
		}
		result.setResult(register);
		return register;}
}
	
	
	

