package productextras;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*
 * Negative Test Cases:
 * in Add Foot Note
 * 1. Making empty both name and desc and submit.
 * 2. Enter the Space in the name and desc and submit
 * 3. enter the existing name in name field and Submit.
 * 4. case sensitive letter with existing name and submit
 * 5. clicking on option and do not enter any value and submit it
 * 6. in option clicking on space button and submit it. 
 */

public class FootNote extends BaseClass{
	
	static String footName = "Wash Care";
	static String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
			+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
			+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor "
			+ "in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
			+ "sunt in culpa qui officia deserunt mollit anim id est laborum.";
	
	@Test(priority=0, description="clicking on the product", groups="FootNote")
	public void clickPro() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Product Extras']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Footnote')]")).click();
    }

	@Test(priority=1, description="Adding the Foot note", groups="FootNote")
	public void AddFN() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add Footnote')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Add Footnote')]")).click();
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(footName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='With textarea']")));
		driver.findElement(By.xpath("//textarea[@aria-label='With textarea']")).sendKeys(description);
		
		try {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'ADD OPTION')]")));
		 System.out.println("Add Option button is clickable");
		}catch(Exception e)
		{
			System.out.println("Element is not clickable");
		}
		 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
        WebElement error = driver.findElement(By.xpath("//form[@class='ng-dirty ng-touched ng-valid ng-submitted']/child::div/child::div[2]/descendant::p"));
		
		if(error.isDisplayed()) {
			
			System.out.println(error.getText());
			try {
			       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Cancel')]")));
			       System.out.println("Cancel button is clickable");
			     }
			catch(TimeoutException e) {
			       System.out.println("Cancel button isn't clickable");
			    }
			driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
		
		}
	}
	
	
	@Test(priority=2, description="searching the footnote", groups="FootNote")
	public void search() throws InterruptedException
	{
	 driver.findElement(By.name("search_bar")).sendKeys(footName);
	 
	  List<WebElement> footNote = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
	  System.out.println("size of Foot Note Name : " + footNote.size());
  	  Thread.sleep(4000);
	}
	
	
	@Test(priority=3, description="comparing options", groups="FootNote")
	public void compareOptions() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);
		
		List<WebElement> footNoteName = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of Foot Note Name : " + footNoteName.size());
    	Thread.sleep(4000);
				
		List<WebElement> optionCount = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]"));
		System.out.println("size of option : " + optionCount.size());
		
		System.out.println("Foot Note Name : " + footNoteName.size() + " = > count : " + optionCount.size());
		
		 int count = 0;
			
			for(int i = 0; i<footNoteName.size(); i++)
			{
				
				count++;
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")));
				WebElement footNoteName1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")).get(i);
				String text1 = footNoteName1.getText();
			
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")));
				WebElement optionCount1 = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")).get(i);
				String optionC = optionCount1.getText();
				char optionCun = optionC.charAt(0);
				
				
				System.out.println(text1 + " => " + optionCun);
				
				//click on view
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[2]")));
				driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[2]")).get(i).click();
				
				//popup description
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role ='document']/descendant::form/descendant::div[3]/child::div/child::div[2]/descendant::label")));
				List<WebElement> popupDiscOptions = driver.findElements(By.xpath("//div[@role ='document']/descendant::form/descendant::div[3]/child::div/child::div[2]/descendant::label"));
				int popupDiscOptionsSize = popupDiscOptions.size();
				System.out.println("Option count : " +  "Desc count " );
				System.out.println( optionCun + ":" + popupDiscOptionsSize);
				
				Thread.sleep(3000);
								
				driver.findElement(By.xpath("//div[@role ='document']/descendant::form/descendant::div[3]/following-sibling::div/child::button[@id='closeModal']")).click();
				
			}
		
	}
	
	
	
	@Test(priority=4, description="comparing foot note", groups="FootNote")
	public void compareFootNote() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);	
		
	    HashMap<String, String> footNoteNameAndOption = new HashMap<String, String>();	
		
		List<WebElement> footNoteName = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of Foot Note Name : " + footNoteName.size());
    	Thread.sleep(4000);
				
		List<WebElement> optionCount = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]"));
		System.out.println("size of option : " + optionCount.size());
		
		System.out.println("Foot Note Name : " + footNoteName.size() + " = > count : " + optionCount.size());
		
        int count = 0;
		
		for(int i = 0; i<footNoteName.size(); i++)
		{
			
			count++;
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")));
			WebElement footNoteName1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")).get(i);
			String text1 = footNoteName1.getText();
		
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")));
			WebElement optionCount1 = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-foot-note/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")).get(i);
			System.out.println(text1 + " => " + optionCount1.getText());
				
			footNoteNameAndOption.put(text1, optionCount1.getText());
			
			Thread.sleep(3000);
			// back
			
			driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/descendant::span[1]")).click();
			
			// catalog and products
			driver.findElement(By.xpath("//a[normalize-space()='Catalog & Products']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]")));
			WebElement addpro = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]"));
			ac.click(addpro).build().perform();
			
			//driver.findElement(By.xpath("//div[@class='top-filter-sec list-button mt-2 ng-tns-c90-2']//button[3]")).click();
			
			driver.findElement(By.xpath("//span[normalize-space()='Apply Foot Note']")).click();
			
			Thread.sleep(2000);
			
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("window.scrollBy(0,810)");
			
			List<WebElement> proFootNote = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[5]//descendant::div[1]/following-sibling::div/descendant::b"));
			System.out.println("size of FootNote in product page: " + proFootNote.size());
			
		
			for(int j =0; j< proFootNote.size(); j++)
			{
				String text = proFootNote.get(j).getText();
				if(text1.contains(text))
				{
					System.out.println(text1 + " => Present");
					break;
				
				}
				
				
			}
			System.out.println(count);
			clickPro();

			Thread.sleep(4000);
			
		}
	}
	
	@Test(priority=5, description="removing the foot note", groups="FootNote")
	public void remove()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//clicking on remove button
		driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-foot-note/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[1]")).get(4).click();
		
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
		
	}
	
	
	
	
}