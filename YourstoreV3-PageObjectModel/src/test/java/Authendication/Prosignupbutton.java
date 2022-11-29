package Authendication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Prosignupbutton extends BaseClass{
	
	@Test(groups="pro")
	public void proSignup()
	{
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,500)");
		
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(1).click(); // start button=> pro sign up
	}

}
