package com.olx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;  
public class Datee {
 
public static  String currentDate(){
 
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
	    String s= formatter.format(date);  
	    return(s); 
	}  
}