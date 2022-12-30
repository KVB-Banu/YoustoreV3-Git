package settings;

import java.util.HashMap;   
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	
	public final static String driver_Path= "C:\\Users\\white\\OneDrive\\Desktop\\Driver Path\\chromedriver.exe";
    public final static String url = "https://yourstore.io/login/session/signin";
	public final static String email ="demo302@yourstore.io";
	public final static String password ="admin747@Yourstore2";
	public static WebDriver driver;	
	
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", driver_Path);
		//Create a map to store  preferences 
				Map<String, Object> prefs = new HashMap<String, Object>();
				    
				//add key and value to map as follow to switch off browser notification
				//Pass the argument 1 to allow and 2 to block
				prefs.put("profile.default_content_setting_values.notifications", 2);
				    
				//Create an instance of ChromeOptions 
				ChromeOptions options = new ChromeOptions();
				    
				// set ExperimentalOption - prefs 
				options.setExperimentalOption("prefs", prefs);
				
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
	}
	
	@BeforeTest
	public void openUrl()
	{
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='auth-content']/child::app-signin/descendant::form/descendant::input[@name='email']")));
		driver.findElement(By.xpath("//div[@class='auth-content']/child::app-signin/descendant::form/descendant::input[@name='email']")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/div/div/app-signin/div/div/div/div/form/div[3]/div[3]/btn-loading/button")).click();
		
	}

	
	
	
	

}
