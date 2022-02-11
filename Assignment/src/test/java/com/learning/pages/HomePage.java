package com.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.TestBase;

public class HomePage extends TestBase{
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Text boxes
	@FindBy(id="twotabsearchtextbox")
	WebElement txtSearchBox;
	
	// Buttons
	@FindBy(id="nav-search-submit-button")
	WebElement btnSearchButton;
	
	// Dropdown
	@FindBy(id="a-autoid-0-announce")
	WebElement lstSortBy;
	
	// Labels
	@FindBy(id="s-result-sort-select_2")
	WebElement lblHighToLow;
	
	public void enterSearchText(String value)
	{
		txtSearchBox.clear();
		txtSearchBox.sendKeys(value);
//		return new HomePage();
	}
	
	public void clickSearchButton()
	{
		btnSearchButton.click();
		//	return new HomePage();
	}
	
	public void clickSortByButton()
	{
		lstSortBy.click();
		//	return new HomePage();
	}
	
	public void clickHighToLow()
	{
		lblHighToLow.click();
		//	return new HomePage();
	}
}
