package Authendication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Signup extends BaseClass {
	
	@Test( description="signup on genie", enabled=false, groups="genie")
	public void genieSignup()
	{
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,500)");
		
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(0).click(); // start button=> genie sign up
	}
	
	@Test(description="signup on Pro", enabled=true, groups="pro")
	public void proSignup()
	{
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,500)");
		
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(1).click(); // start button=> pro sign up
	}
	
	@Test(description="signup on Multi vendor", enabled=false, groups="multivendor")
	public void multiVendorSignup()
	{
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,500)");
		
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(2).click(); // start button=> multi vendor sign up
	}
	
	@Test(description="signup on B2B", enabled=false, groups="b2b")
	public void b2bSignup()
	{
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,500)");
		
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(3).click(); // start button=> B2B sign up
	}

	@Test(description="signup on service", enabled=false, groups="service")
	public void serviceSignup()
	{
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,500)");
		
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(4).click(); // start button=> service sign up
	}
}
