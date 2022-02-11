package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import Constants.Constants;

//import com.crm.qa.Constants.Constants;
//import com.crm.qa.Utilities.TestUtility;
//import com.crm.qa.Utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties property;
	public static ChromeOptions chromeOptions;

	public TestBase()
	{
		try {
			property = new Properties();
			FileInputStream inputStream = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/property.properties");
			property.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String broswerName = property.getProperty("Browser");
		if (broswerName.equals("Chrome")) {
			chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			System.out.println( Constants.CHROME_DRIVER_PATH);
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver(chromeOptions);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(property.getProperty("Url"));
	}
}
