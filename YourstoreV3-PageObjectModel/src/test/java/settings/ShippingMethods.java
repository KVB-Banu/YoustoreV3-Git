package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ShippingMethods extends BaseClass{
	
	

	@Test(priority=0, description="clicking on Settings")
	public void clickPro()
	{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		Actions ac = new Actions(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
		driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion-collapse collapse show']/descendant::a[contains(text(),' Shipping Methods ')]")));
		driver.findElement(By.xpath("//div[@class='accordion-collapse collapse show']/descendant::a[contains(text(),' Shipping Methods ')]")).click();
		
		
	}
	
	@Test(priority=1, description = "Adding the shipping Methods")
	public void addShippingMethod() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-shipping-methods/child::div/child::div[2]/child::div/child::div[2]/child::button[contains(text(),' Add New')]")));
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-shipping-methods/child::div/child::div[2]/child::div/child::div[2]/child::button[contains(text(),' Add New')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::select[@name='shipping_type']")));
		Select s = new Select(driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::select[@name='shipping_type']")));
		s.selectByIndex(1);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Carrier Name')]/following-sibling::input")));
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Carrier Name')]/following-sibling::input")).sendKeys("");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Tracking Link')]/following-sibling::input")));
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Tracking Link')]/following-sibling::input")).sendKeys("123456789");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Delivery Time')]/following-sibling::select")));
		Select s1 = new Select(driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Delivery Time')]/following-sibling::select")));
		s1.selectByIndex(2);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Shipping Charge')]/following-sibling::input")));
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Shipping Charge')]/following-sibling::input")).sendKeys("30");
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::span[contains(text(),'Free Shipping')]/following-sibling::span")));
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::span[contains(text(),'Free Shipping')]/following-sibling::span")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::span[contains(text(),'Enable Alert')]/following-sibling::span")));
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::span[contains(text(),'Enable Alert')]/following-sibling::span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Order above')]/following-sibling::input")));
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[2]/descendant::label[contains(text(),'Order above')]/following-sibling::input")).sendKeys("2000");
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[3]/descendant::span[contains(text(),'Cancel')]")));
			System.out.println("Cancel button is Clickable");
			
		}catch(Exception e)
		{
			System.err.println("Cancel button is not Clickable");
		}
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[3]/descendant::span[contains(text(),'Add')]")));
			System.out.println("Add button is Clickable");
			
		}catch(Exception e)
		{
			System.err.println("Add button is not Clickable");
		}
		
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-dialog-scrollable modal-xl']/descendant::form/child::div/child::div[3]/descendant::span[contains(text(),'Cancel')]")).click();
	
		Thread.sleep(5000);
	}
	
	
	@Test(priority=2, description="searching the Shipping methods")
	public void search()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		Actions ac = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-shipping-methods/child::div/descendant::input[@name='search_bar']")));
		WebElement search = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-shipping-methods/child::div/descendant::input[@name='search_bar']"));
		ac.click(search).sendKeys("Delhivery").sendKeys(Keys.ENTER).build().perform();
		
	}	
	
	
	@Test(priority=3, description="Shipping integration")
	public void shippingIntegration()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-shipping-methods/child::div/child::div[2]/child::div/child::div[2]/child::button[contains(text(),' Shipping Integration')]")));
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-shipping-methods/child::div/child::div[2]/child::div/child::div[2]/child::button[contains(text(),' Shipping Integration')]")).click();
		
		try {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-courier-partners/child::div/child::div[2]/descendant::button[contains(text(),'Add New ')]")));
		System.out.println("Add New button is Clickable");
		
		}catch(Exception e)
		{
			System.err.println("Add New button is not Clickable");
		}
	   driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-courier-partners/child::div/child::div[2]/descendant::button[contains(text(),'Add New ')]")).click();
		
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div/descendant::label[contains(text(),'Type')]/following-sibling::select")));
	   Select s1 = new Select(driver.findElement(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div/descendant::label[contains(text(),'Type')]/following-sibling::select")));
	   s1.selectByIndex(1);
	   
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div/descendant::label[contains(text(),'Mode')]/following-sibling::select")));
	   Select s2 = new Select(driver.findElement(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div/descendant::label[contains(text(),'Mode')]/following-sibling::select")));
	// s2.selectByIndex(0);
	   
	   driver.findElement(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div/descendant::label[contains(text(),'Token')]/following-sibling::input")).sendKeys("234543435454");
	   try {
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div[2]/descendant::span[contains(text(),'Cancel')]")));
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div[2]/descendant::span[contains(text(),' Add ')]")));
	   System.out.println("Shipping Integration Add new Cancel button is clickable");
	   System.out.println("Shipping Integration Add new Add button is clickable");
		   
	   }catch(Exception e)
	   {
		   System.err.println("Shipping Integration Add new Cancel button is not clickable");
		   System.err.println("Shipping Integration Add new Add button is not clickable"); 
	   }
	   
	   driver.findElement(By.xpath("//div[@role='document']/descendant::form/descendant::div[2]/following-sibling::div[2]/descendant::span[contains(text(),' Add ')]")).click();
	   
	}

}
