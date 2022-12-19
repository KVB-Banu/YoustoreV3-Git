package Authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Signup extends BaseClass {
	
	@Test( description="signup on genie", enabled=true, groups="genie")
	public void genieSignup() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,200)");
		Thread.sleep(5000);
		
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(0).click(); // start button=> genie sign up
		System.out.println("Clicked on Genie- Sign UP");
		
//		obj.executeScript("window.scrollBy(0,800)");
//		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(2).click(); // start button=> multi vendor sign up
//		System.out.println("Clicked on MultiVendor- Sign UP");
		
//		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(3).click(); // start button=> B2B sign up
//		System.out.println("Clicked on B2B- Sign UP");
		
//		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(4).click(); // start button=> service sign up
//		System.out.println("Clicked on Service- Sign UP");
		
		Thread.sleep(5000);
	
	}
}
