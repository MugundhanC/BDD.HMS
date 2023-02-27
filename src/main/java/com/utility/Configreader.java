package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	public Properties prop;
	
	public Properties init_prop()
	{
		prop=new Properties();
		try {
			
		FileInputStream ip=new FileInputStream("./src/test/resource/Config/Appconfig.properties");
		prop.load(ip);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

}
