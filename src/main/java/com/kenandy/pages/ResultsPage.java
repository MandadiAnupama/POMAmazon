package com.kenandy.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.kenandy.base.BaseTest;
import com.kenandy.utils.CommonUtils;

/**
 * Results Page Class : Contains Page Objects and Actions on Amazon Search Results Page. 
 *
 */
public class ResultsPage {

	private static Logger LOG = Logger.getLogger(ResultsPage.class);
	private static WebDriver driver = BaseTest.driver;
	
	@FindAll(@FindBy(css = "#s-results-list-atf a.s-access-detail-page"))
	private static List<WebElement> searchList;

	@FindAll(@FindBy(css = "#s-results-list-atf i.a-icon-star"))
	private static List<WebElement> ratingsList; 
	
	@FindAll(@FindBy(css = ".a-popover-inner span.a-size-base"))
	private static List<WebElement> ratingsPopOver;
	
	
	public static void verifyFirstResult(String searchName, double expectedRating) {
		
		LOG.info("--- Entering verifyFirstResult method ---");
		boolean searchNameExists = StringUtils.contains(searchList.get(0).getText(), searchName);
		Assert.assertTrue(searchNameExists, searchName+ " doesn't exist in the first result");
		Assert.assertTrue(verifyResultRating(expectedRating));
		LOG.info("--- Exiting verifyFirstResult method ---");
	}
	
	public static boolean verifyResultRating(double expectedRating) {
		LOG.info("--- Entering verifyResultRating method ---");
		boolean isRatingGreater = false;
		CommonUtils.mouseHover(ratingsList.get(0));
		String[] ratings = ratingsPopOver.get(0).getText().trim().split(" ");
		if(Double.valueOf(ratings[0]) > expectedRating) {
			isRatingGreater = true;
		}
		LOG.info("--- Exiting verifyResultRating method ---");
		return isRatingGreater;
		
	}
}
