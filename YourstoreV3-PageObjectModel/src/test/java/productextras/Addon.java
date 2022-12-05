package productextras;

import java.io.IOException;  
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;





public class Addon extends BaseClass{
	
	
	/*
	 * Negative Test Cases:
	 * in Add Addon
	 * 1. Making empty both name and desc and submit.
	 * 2. Enter the Space in the name and desc and submit
	 * 3. enter the existing name in name field and Submit.
	 * 4. case sensitive letter with existing name and submit
	 * 5. clicking on option and do not enter any value and submit it
	 * 6. in option clicking on space button and submit it. 
	 */
	
	static String addOnName = "123";
	static String addOnPrice = "2000";
	static String stock = "1";
	static String title = " additional ";
	static String option1 = " option1 ";
	static String option2 = " option2 ";
	
	
	@Test(priority=5, description="clicking on the product", groups="addon")
	public void clickPro() throws IOException, Exception 
	    {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")));
		driver.findElement(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::ul/descendant::a[contains(text(),'Product Extras')]")));	
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::ul/descendant::a[contains(text(),'Product Extras')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-product-extras/descendant::label[contains(text(),'Addons')]")));
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-product-extras/descendant::label[contains(text(),'Addons')]")).click();
	    }
	
	
	@Test(priority=6, description="Adding addon", groups="addon")
    public void addAddOn() throws IOException, Exception {
			
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-addons/div/div[2]/div/div[2]/button[3]")));
		WebElement add = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-addons/div/div[2]/div/div[2]/button[3]"));
		 if(add.isDisplayed())
		 {
			 try {
			 driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-addons/div/div[2]/div/div[2]/button[3]"));
			 System.out.println("Add Add-On button is clickable");
			 }catch(Exception e)
			 {
				 System.out.println("Add Add-On button is not clickable"); 
			 }
		 }
		 
		
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-addons/child::div/child::div[2]/descendant::button[contains(text(),'Add Add-On')]")).click();
		 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/descendant::i")));
		driver.findElement(By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/descendant::i")).click();
		Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image7.exe");
		Thread.sleep(3000);
		
		driver.findElement(By.name("addon_name")).sendKeys(addOnName);
		
		driver.findElement(By.name("addon_price")).sendKeys(addOnPrice);
		
		driver.findElement(By.name("min_stock")).sendKeys(stock);
		
		driver.findElement(By.xpath("//span[normalize-space()='Include Customization Notes']")).click();
		
		driver.findElement(By.name("notes_title")).sendKeys(title);
		
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(option1);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@class='checkbox checkbox-primary mt-3']//span[@class='checkmark']")).click();
		
		
		for(int i = 0; i<1; i++) {
		
		try {	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-12 col-12 d-flex align-items-center']//button[@type='button']")));
		System.out.println("Option button is clickable");
			}catch(Exception e)
		{
				System.out.println("Option button is not clickable");	
		}
		
		driver.findElement(By.xpath("//div[@class='col-md-12 col-12 d-flex align-items-center']//button[@type='button']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(option2);
		driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-modify-addons[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/label[1]/span[1]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Include Measurements']")));
		driver.findElement(By.xpath("//span[normalize-space()='Include Measurements']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select All']")));
		driver.findElement(By.xpath("//span[normalize-space()='Select All']")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		
        WebElement error = driver.findElement(By.xpath("//div[@class='page_fixedfooter']/descendant::p[contains(text(),'Addon name already exists')]"));
		
		
		if(error.isDisplayed()) {
			
			System.out.println(error.getText());
			try {
			       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page_fixedfooter']/descendant::span[contains(text(),'Cancel')]")));
			       System.out.println("Cancel button is clickable");
			     }
			catch(TimeoutException e) {
			       System.out.println("Cancel button isn't clickable");
			    }
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page_fixedfooter']/descendant::span[contains(text(),'Cancel')]")));
			driver.findElement(By.xpath("//div[@class='page_fixedfooter']/descendant::span[contains(text(),'Cancel')]")).click();
		}
		
		
		}
				
	}
    
	@Test(priority=7, description="edit the addon", groups="addon",enabled=false)
    public void edit()
    {
    	WebDriverWait wait = new WebDriverWait(driver, 50);
    	WebElement view = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-addons/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[2]")).get(0);
    	view.click();
    	
       	
    }
    
    
	@Test(priority=8, description="search the addon", groups="addon")
    public void search() throws InterruptedException
		{
		 driver.findElement(By.name("search_bar")).sendKeys(addOnName);
		 
		 List<WebElement> addOnNames = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']//child::app-addons/descendant::div/child::div[3]/descendant::div[3]/following-sibling::div/descendant::p[1]"));
		 System.out.println("size of AddonNames: " +addOnNames.size());
	  	 Thread.sleep(4000);
		}
		
	@Test(priority=9, description="comparing the addon", groups="addon")
    public void addOnCompare() throws Exception
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']//child::app-addons/descendant::div/child::div[3]/descendant::div[3]/following-sibling::div/descendant::p[1]")));
			List<WebElement> addOnNames = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']//child::app-addons/descendant::div/child::div[3]/descendant::div[3]/following-sibling::div/descendant::p[1]"));
			System.out.println("size of AddonNames: " +addOnNames.size());
			
			int count=0;
			for(int i = 0; i<addOnNames.size(); i++)
			{
				    count++;
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']//child::app-addons/descendant::div/child::div[3]/descendant::div[3]/following-sibling::div/descendant::p[1]")));
					List<WebElement> addOnNames1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']//child::app-addons/descendant::div/child::div[3]/descendant::div[3]/following-sibling::div/descendant::p[1]"));
					System.out.println(addOnNames1.get(i).getText());
									
				        String a = addOnNames1.get(i).getText();
										
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
				Thread.sleep(3000);
				try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/descendant::div[2]/descendant::div[5]/child::button[contains(text(),'Add Product')]")));
				driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/descendant::div[2]/descendant::div[5]/child::button[contains(text(),'Add Product')]")).click();
				Thread.sleep(3000);
				}catch(Exception e)
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/descendant::div[2]/descendant::div[5]/child::button[contains(text(),'Add Product')]")));
					driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/descendant::div[2]/descendant::div[5]/child::button[contains(text(),'Add Product')]")).click();
					Thread.sleep(3000);
				}
				JavascriptExecutor obj = (JavascriptExecutor) driver;
				obj.executeScript("window.scrollBy(0,1500)");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Apply Add-Ons']")));
				driver.findElement(By.xpath("//span[normalize-space()='Apply Add-Ons']")).click();
			//	System.out.println("clicked on Addon");
				Thread.sleep(4000);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div/child::div[3]/child::div[2]/descendant::div[3]/following-sibling::div/descendant::span/child::span")));
				List<WebElement> addOnElements = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div/child::div[3]/child::div[2]/descendant::div[3]/following-sibling::div/descendant::span/child::span"));
			//	System.out.println("size of addon Elements : " + addOnElements.size());
				
				for(WebElement x : addOnElements)
				{
					String text = x.getText();
				//	System.out.println("Add on Names in Add product : " + text);
					Thread.sleep(4000);
					if(a.contains(text))
					{
						System.out.println(text + " Addon option is present"  );
	
					break;
					}
				}
				
				System.out.println(count);
				clickPro();
				
				Thread.sleep(4000);
				
			}
			
			
		}
    
	@Test(priority=10, description="removing the addon", groups="addon")
	public void remove()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		//clicking on remove button
		driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-addons/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[1]")).get(4).click();
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[2]")));
			System.out.println("Remove Yes button is clickable");
		}catch(Exception e)
		{
			System.out.println("Remove Yes button is not clickable");
		}
		
	//	driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[1]")));
			System.out.println("Remove No button is clickable");
		}catch(Exception e)
		{
			System.out.println("Remove No button is not clickable");
		}
		
		driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[1]")).click();
	}
	
	@Test(priority=11, description="buttonsettings", groups="addon")
	public void buttonSettings() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		Actions ac = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']//child::app-addons/descendant::div/child::div[2]/descendant::div[2]/following-sibling::div/child::button[2]")));
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']//child::app-addons/descendant::div/child::div[2]/descendant::div[2]/following-sibling::div/child::button[2]")).click();
		Thread.sleep(3000);
		
		List<WebElement> buttonOpt = driver.findElements(By.xpath("//div[@role='document']/descendant::form/descendant::label"));
		
		for(int i=0; i<buttonOpt.size(); i++)
		{
		
			WebElement buttonOpt1 = driver.findElements(By.xpath("//div[@role='document']/descendant::form/descendant::label")).get(i);
		    String buttonOptText = buttonOpt1.getText();
		    System.out.println("name: " + buttonOptText);
		    
		    WebElement buttonInput = driver.findElements(By.xpath("//div[@role='document']/descendant::form/descendant::input")).get(i);
		   
		    
		}
		
		 try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::form/child::div[2]/child::button[2]")));
				System.out.println("Button Settings Update button is clickable");
			}catch(Exception e)
			{
				System.out.println("Button Settings Update button is not clickable");
			}
			
		//	driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::form/child::div[2]/child::button[1]")));
				System.out.println("Button Settings Cancel button is clickable");
			}catch(Exception e)
			{
				System.out.println("Button Settings Cancel button is not clickable");
			}
		
	}
	

}
