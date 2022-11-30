package Authentication;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProSignup extends BaseClass{
	
	@Test(description =" signp on pro account", groups="pro")
	public void proSignupPage() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);		
		
			
		System.out.println("Current Url:" + driver.getTitle());
		
//		String parent=driver.getWindowHandle();
//
//		Set<String>s=driver.getWindowHandles();
//		
//		Iterator<String> I1= s.iterator();
//
//		while(I1.hasNext())
//		{
//
//		String child_window=I1.next();
//
//
//		if(!parent.equals(child_window))
//		{
//		driver.switchTo().window(child_window);
//
//		System.out.println(driver.switchTo().window(child_window).getTitle());
//		public void email()
		
			Random rand = new Random();
			int random = rand.nextInt(1000);
			String email = "test@"+ random + "gmail.com";
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Your full name']")));
		driver.findElement(By.xpath("//input[@placeholder='Your full name']")).sendKeys(name);
		driver.findElement(By.name("mobile")).sendKeys(mobile_num);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	
		//
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='signup-card']/child::app-signup/descendant::form/descendant::input[@name='store_name']")));
    	driver.findElement(By.xpath("//div[@class='signup-card']/child::app-signup/descendant::form/descendant::input[@name='store_name']")).sendKeys(store_name);
    	Select s1 = new Select(driver.findElement(By.name("country")));
    	s1.selectByVisibleText("India");
    	
    	Select s2 = new Select(driver.findElement(By.name("currency_code")));
    	s2.selectByVisibleText("INR");
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	Thread.sleep(5000);
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.name("address")));
    	driver.findElement(By.name("address")).sendKeys(address);
    	
    	driver.findElement(By.name("city")).sendKeys(city);
    	Select s4 = new Select(driver.findElement(By.name("state")));
    	s4.selectByVisibleText("Tamil Nadu");
    	
    	driver.findElement(By.name("pincode")).sendKeys(pincode);
    	
    	driver.findElement(By.name("gst_no")).sendKeys(GST);
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	Thread.sleep(5000);
    	
    	Select s5 = new Select(driver.findElement(By.name("service_type")));
    	s5.selectByIndex(1);
    	
    	Select s6 = new Select(driver.findElement(By.name("category")));
    	s6.selectByVisibleText("Clothing");
    	
//    	driver.findElement(By.xpath("//button[@type='submit']")).click();
//    	Thread.sleep(3000);
    	
//    	Select s6 = new Select(driver.findElement(By.id("project-category")));
//    	s6.selectByIndex(2);

    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='signup-card']/child::app-signup/descendant::form/child::div/child::div[2]/descendant::textarea")));
    	
    	driver.findElement(By.xpath("//div[@class='signup-card']/child::app-signup/descendant::form/child::div/child::div[2]/descendant::textarea")).sendKeys(description);
    	
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
    	Thread.sleep(3000);
    	
//    	driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
//    	
//    	driver.findElement(By.name("email")).sendKeys(email);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/div/div/app-signin/div/div/div/div/form/div[3]/div[3]/btn-loading/button")).click();
//		
//		 WebElement error = driver.findElement(By.xpath("//div[@class='auth-content']/descendant::form/child::div/following-sibling::div[2]/child::p"));
//		 if(error.isEnabled()) {
//			 System.out.println("error should come if store is not activated" + error.getText());
//		 }else {
//			 System.out.println("No error found");
//		 }
    	
    	   	
    	}
	//}
//}		


}
