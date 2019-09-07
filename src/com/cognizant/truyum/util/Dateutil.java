package com.cognizant.truyum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateutil {
public static Date convertToDate(String date) 
{
	try
	{
	Date d;
  
	 d = new SimpleDateFormat("dd/MM/YY").parse(date);
	return d;
	}
	catch(Exception e){
      
	}
	return null;
}
}