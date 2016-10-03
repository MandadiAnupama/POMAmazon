package com.kenandy.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.kenandy.base.BaseTest;
import com.kenandy.pages.HomePage;
import com.kenandy.pages.ResultsPage;

public class SearchTests extends BaseTest {

	private static Logger LOG = Logger.getLogger(SearchTests.class);
	
	@Test(description = "Test to verfiy iPhone 6 SearchResults & Ratings")
	public void testAmazonSearch() {
		LOG.info("--- Entering testAmazonSearch Test ---");
		HomePage.search("iPhone 6");
		ResultsPage.verifyFirstResult("iPhone 6", 3.0);
		LOG.info("--- Exiting testAmazonSearch Test ---");
	}
}

