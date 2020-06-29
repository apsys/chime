package com.test.chime.framewok.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;

public enum Config {

	INSTANCE;
	
	Properties prop = new Properties();
	
	@BeforeMethod
	public void init() throws FileNotFoundException, IOException {
        try  {

        	String configFile = new File(".").getCanonicalPath() + File.separator + "config/qa/test.properties";
        	System.out.println("properties loading.. " + configFile);
			prop.load(new FileInputStream(configFile));
    		RestAssured.baseURI = prop.getProperty("host");

        } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Problem loading configurations : " + this.getClass().getName());
		}
	}	
}
