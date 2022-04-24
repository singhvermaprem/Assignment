package com.UpKeep.Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public String property(String Key)
	{
		
		  try
		  {
			  FileReader reader=new FileReader(System.getProperty("user.dir")+"/PropertyFile/UpKeep.properties");  
			  Properties prop =new Properties();  
			  prop.load(reader); 
			  return prop.get(Key).toString();
		  }
		  catch (IOException io)
		  {
			  System.err.println(io);
		  }
		return null;
		    
		      
	}
	      

}
