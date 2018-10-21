package com.wtf.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;

public class JsonUtils {

	private static BufferedReader bufferReader = null;

	public static <T> T readJson(Class<T> T,String data){		
		try {			
			bufferReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/resources/"+data));
						 
		} catch (FileNotFoundException e) {			
			e.printStackTrace();		}
		
		return new Gson().fromJson(bufferReader, T);		
	}
	
	public static <T> T initTestData(Class<T> T){		
		return readJson(T, System.getProperty("data"));
	}
}
