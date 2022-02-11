package com.learning.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class ProductDetailsPage extends TestBase {

	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	// Labels
	@FindBy(id = "productTitle")
	WebElement lblProductDescription;

	@FindBy(xpath = "//div[@id='averageCustomerReviews']//parent::td")
	WebElement lblReviewRating;

	@FindBy(xpath = "//div[@id='apex_desktop']//span[@class='a-price aok-align-center priceToPay']//span[@class='a-price-whole']")
	WebElement lblWholePriceDetails;

	@FindBy(xpath = "//div[@id='apex_desktop']//span[@class='a-price aok-align-center priceToPay']//span[@class='a-price-fraction']")
	WebElement lblFractionPriceDetails;

	//// div[@id='corePrice_feature_div']//span[@class='a-offscreen']")//"//div[@id='apex_desktop']//span[@class='a-price
	//// aok-align-center priceToPay']//span[@class='a-offscreen']")

	public String getProductDescription() {
		return lblProductDescription.getText();
	}

	public String getReviewRating() {
		return lblReviewRating.getText();
	}

	public String getPriceDetails() {

		String FinalPrice;
		try {
			FinalPrice = "$" + lblWholePriceDetails.getText() + "." + lblFractionPriceDetails.getText();
			System.out.println(FinalPrice);
		} catch (Exception e) {
			return "Currently unavailable.";
		}
		return FinalPrice;
	}

	public Map<String, List<String>> getProductDetails(int iteration) throws Exception {
		By mySelector = By.xpath("//div[@class='a-section']//h2//span");
		List<WebElement> ele = driver.findElements(mySelector);
		int i = 0;

		Map<String, List<String>> list = new HashMap<String, List<String>>();
		List<String> lis = new ArrayList<String>();
		for (WebElement e : ele) {
			if (i < 1) {
				e.click();
				Thread.sleep(2000);
				System.out.println(getProductDescription());
				System.out.println(getReviewRating());
				System.out.println(getPriceDetails());
				lis.add(getProductDescription());
				lis.add(getReviewRating());
				lis.add(getPriceDetails());
			}
			i++;
		}

		list.put(String.valueOf(iteration), lis);
		return (Map<String, List<String>>) list;
	}

	public void hm(Map<String, List<String>> list) {
		for (Map.Entry<String, List<String>> me : list.entrySet()) {
			String key = me.getKey();
			List<String> valueList = me.getValue();
			System.out.println("Key: " + key);
			System.out.print("Values: ");
			for (String s : valueList) {
				System.out.print(s + " ");
			}
		}
	}

}
