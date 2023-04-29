package com.util;

import java.util.Properties;

public class ConfigLoader 
{
	private static Properties prop;
	private static ConfigLoader config;
	
	private ConfigLoader()
	{
		prop = PropertiesUtil.getPropertyData();
	}
	
	public static ConfigLoader getInstance()
	{
		if(config==null) config = new ConfigLoader();
		return config;
	}
	
	public String getBrowserName()
	{
		return prop.getProperty("browser");
	}
}
