package com.kenandy.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.kenandy.pages.HomePage;
import com.kenandy.utils.CommonUtils;

/**
 * BaseTest Class : is the main class which drives the entire framework. 
 * All Test Classes should be extending this BaseTest Class.
 *
 */
public class BaseTest {

	private static Logger LOG = Logger.getLogger(BaseTest.class);
	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		try {
			LOG.info("--- Entering BeforeTest Method ---");
			driver = new FirefoxDriver();
			driver.get(CommonUtils.readFromConfig("appURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000l, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			PageFactory.initElements(driver, HomePage.class);
		} catch (Exception e) {
			LOG.error("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			LOG.info("--- Exiting BeforeTest Method ---");
		}
	}
	
	@AfterTest
	public void tearDown() {
		LOG.info("--- Entering AfterTest Method ---");
		driver.quit();
		LOG.info("--- Exiting AfterTest Method ---");
	}

}
