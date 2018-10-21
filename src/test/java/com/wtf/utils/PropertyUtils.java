package com.wtf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	
   public  Properties property;
   public Properties readProperty(){
	   try {  
		   String baseDir = System.getProperty("environment");
		   String rootDir = System.getProperty("user.dir");
		   FileInputStream inputStrem = new  FileInputStream(new File(rootDir+"/resources/"+baseDir+"/environment.properties"));
		   property = new Properties();
		   property.load(inputStrem);		   
		} catch (IOException e) {			
				e.printStackTrace();
		}
	return property;
	
	}
}
