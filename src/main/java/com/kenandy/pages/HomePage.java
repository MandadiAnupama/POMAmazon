package com.kenandy.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kenandy.base.BaseTest;

/**
 * HomePage Class: Contains page objects and actions on Amazon HomePage.
 *
 */
public class HomePage {
	
	private static Logger LOG = Logger.getLogger(HomePage.class);
	private static WebDriver driver = BaseTest.driver;

	@FindBy(css = "#twotabsearchtextbox")
	private static WebElement searchBox;

	@FindBy(css = ".nav-input[value='Go']")
	private static WebElement searchButton;
	
	public static void search(String searchFor) {
		LOG.info("--- Entering search method ---");
		searchBox.sendKeys(searchFor);
		searchButton.click();
		PageFactory.initElements(driver, ResultsPage.class);
		LOG.info("--- Exiting search method ---");
	}
	
}
