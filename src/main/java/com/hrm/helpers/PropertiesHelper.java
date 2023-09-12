package com.hrm.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

	Properties properties = new Properties();
	FileInputStream inputStream;

	public PropertiesHelper(String propertyFilePath) {

		loadPropertyFile(propertyFilePath);
	}

	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

	private void loadPropertyFile(String filePath) {
		try {
			// 1. get the FileInputStream by providing the path of config.properties file
			String dir = System.getProperty("user.dir");
			inputStream = new FileInputStream(dir + filePath);
			properties.load(inputStream);

		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading the File");
			e.printStackTrace();
		}
	}

}
