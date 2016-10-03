package com.kenandy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.kenandy.base.BaseTest;

/**
 * CommonUtils Class : Contains all common functions that can be used across the framework.
 *
 */
public class CommonUtils {

	private static final String CONFIG_PROPERTY_FILE_PATH = "src/test/resources/config.properties";
	private static Actions action;
	private static WebDriver driver = BaseTest.driver;

	/**
	 * Method to read application related properties from the config.properties file
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readFromConfig(String key)
			throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(CONFIG_PROPERTY_FILE_PATH));
		return prop.getProperty(key);
	}
	
	public static void mouseHover(WebElement element) {
		if(null == action) {
			action = new Actions(driver);
		}
		action.moveToElement(element).build().perform();
	}
}
