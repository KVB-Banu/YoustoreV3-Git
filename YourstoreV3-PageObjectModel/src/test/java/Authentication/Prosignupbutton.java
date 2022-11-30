package Authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Prosignupbutton extends BaseClass{
	
	@Test(groups="pro")
	public void proSignup()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign up')]")));
		driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(1).click(); // start button=> pro sign up
	}

}
