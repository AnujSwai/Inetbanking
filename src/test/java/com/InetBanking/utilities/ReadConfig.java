package com.InetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
	import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig(){
		
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is"+e.getLocalizedMessage());
		}
		
		
	}
	public String getapplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getname() {
		String name=pro.getProperty("userName");
		return name;
	}
	
	public String getpassword() {
		String pass=pro.getProperty("password");
		return pass;
	}
	
	public String getChromepath() {
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getfirefox() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getmsEdge() {
		String msEdge=pro.getProperty("msEdge");
		return msEdge;
	}
	
	

}
