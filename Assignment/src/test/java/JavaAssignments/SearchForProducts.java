package JavaAssignments;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.pages.HomePage;
import com.learning.pages.ProductDetailsPage;

import BaseTest.TestBase;

public class SearchForProducts extends TestBase {

	HomePage homePage;
	ProductDetailsPage productDetailsPage;
	static int iteration = 0;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		initialization();
		homePage = new HomePage();
		productDetailsPage = new ProductDetailsPage();
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "Bluetooth headset" }, {"34 inch LED monitor"},{"USB c dock"},{"Smart watch"}};
	}

	@Test(priority = 1, enabled = true, dataProvider = "data-provider")
	public void loginPageTitleTest(String val ) throws Exception {

		homePage.enterSearchText(val);
		homePage.clickSearchButton();
		homePage.clickSortByButton();
		homePage.clickHighToLow();
		Thread.sleep(3000);
		Map<String, List<String>> hm =productDetailsPage.getProductDetails(iteration);
		productDetailsPage.hm(hm);
		iteration++;

	}

	private void getDetails() {
		// TODO Auto-generated method stub
		
	}

}
