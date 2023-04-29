package com.util;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class PropertiesUtil 
{
	private static Properties prop;
	
	private static Properties loadPropertyData()
	{
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
		} catch (IOException e) {
			throw new RuntimeException("Unable to load file!");
		}
		return prop;
	}
	
	public static Properties getPropertyData()
	{
		if(prop!= null) return prop;
		return loadPropertyData();
	}
	
}
