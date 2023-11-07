package com.hrm.framework.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.hrm.framework.reporting.Reporter;

public class PropertiesHelper {

	Properties properties = new Properties();
	FileInputStream inputStream;

	public PropertiesHelper(String propertyFilePath) {
		System.out.println("Reading " + propertyFilePath);
		
		loadPropertyFile(propertyFilePath);
		System.out.println("Property File " + propertyFilePath + " Loaded Successfully");
		
	}

	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

	private void loadPropertyFile(String filePath) {
		try {
			// 1. get the FileInputStream by providing the path of config.properties file
			String dir = System.getProperty("user.dir");
			
			inputStream = new FileInputStream(dir + filePath);
			//String name = new Object(){}.getClass().getEnclosingMethod().getName();
			//System.out.println("Current Class is " + name);
			properties.load(inputStream);
			
		} catch (FileNotFoundException e) {
			Reporter.info("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			Reporter.info("Error while reading the File");
			e.printStackTrace();
		} catch (Exception e) {
			Reporter.info("Exception Occurred while loading property File " + filePath);
			e.printStackTrace();
		}
	}
	private void loadProperty(String filePath) {
		try {
			// 1. get the FileInputStream by providing the path of config.properties file
			String dir = System.getProperty("user.dir");
			inputStream = new FileInputStream(dir + filePath);
			properties.load(inputStream);

		} catch (FileNotFoundException e) {
			Reporter.info("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			Reporter.info("Error while reading the File");
			e.printStackTrace();
		} catch (Exception e) {
			Reporter.info("Exception Occurred while loading property File " + filePath);
			e.printStackTrace();
		}
	}

}
