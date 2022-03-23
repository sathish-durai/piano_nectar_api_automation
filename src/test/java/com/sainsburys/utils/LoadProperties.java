package com.sainsburys.utils;

import io.cucumber.java.Before;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

	public static Properties props = new Properties();
	public static File resourcesDirectory = new File("src" + File.separator + "test" + File.separator + "resources");
	public static String configFilePath = resourcesDirectory.getAbsolutePath() + File.separator + "config"
			+ File.separator;
	public static String testDataFilePath = resourcesDirectory.getAbsolutePath() + File.separator + "testdata"
			+ File.separator;
	public static String downloadsFilePath = resourcesDirectory.getAbsolutePath() + File.separator + "downloads"
			+ File.separator;
	public static String reportsFilePath = resourcesDirectory.getAbsolutePath() + File.separator + "report"
			+ File.separator;
	public static String logsFilePath = resourcesDirectory.getAbsolutePath() + File.separator + "logs"
			+ File.separator;

	InputStream configInputStream = this.getClass().getResourceAsStream("/config/configuration.properties");

	@Before
	public void setup() {
		props.putAll(loadProperties(configInputStream));
	}

	public static Properties loadProperties(InputStream file) {
		try {
			Properties properties = new Properties();
			properties.load(file);
			return properties;
		} catch (Exception e) {
			throw new RuntimeException("Not able to load properties file");
		}
	}

	public static String getProperty(String propertyKey) {
		try {
			String value = props.getProperty(propertyKey);
			return value;
		} catch (Exception e) {
			throw new RuntimeException("Cannot load property " + propertyKey);
		}
	}

	public static int getIntegerProperty(String propertyKey) {
		try {
			int value = Integer.valueOf(props.getProperty(propertyKey));
			return value;
		} catch (Exception e) {
			throw new RuntimeException("Cannot load property " + propertyKey);
		}
	}
}