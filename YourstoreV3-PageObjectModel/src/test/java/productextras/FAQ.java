package productextras;

import java.io.IOException; 
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FAQ extends BaseClass {
	
	static String question ="abc";
	static String answer = "abscdfdg fdgfbgfg ";
	
	@Test(priority=0, description="clicking on the product", groups="FAQ")
	public void clickPro() throws IOException, Exception {
		driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Product Extras']")).click();

		driver.findElement(By.xpath("//label[normalize-space()='FAQ']")).click();
	}

	@Test(priority=1, description="Adding FAQ", groups="FAQ")
	public void AddFAQ() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add FAQ')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Add FAQ')]")).click();
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(question);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='With textarea']")));
		driver.findElement(By.xpath("//textarea[@aria-label='With textarea']")).sendKeys(answer);
		
		try {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'ADD ANSWER')]")));
		 System.out.println("Add Option button is clickable");
		}catch(Exception e)
		{
			System.out.println("Element is not clickable");
		}
		 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModal']")));
			System.out.println("Cancel Button is Clickable");
		}catch(Exception e)
		{
			System.out.println("Cancel Button is not Clickable");
		}
		
		Thread.sleep(3000);
		try {
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
	}catch(Exception e)
		{
		System.out.println("No error Found");
		}
	
	}
	
	
	@Test(priority=2, description="searching the FAQ", groups="FAQ")
	public void search() throws InterruptedException
	{
		
	 driver.findElement(By.name("search_bar")).sendKeys(question);
	 Thread.sleep(3000);
	 
	  List<WebElement> sizeChart = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
	  System.out.println("size of Size Chart Name : " + sizeChart.size());
  	  Thread.sleep(4000);
	}
	
	
	@Test(priority=3, description="Comparing the Answers", groups="FAQ")
	public void compareAnswers() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);
		
		List<WebElement> faqName = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of FAQ Name : " + faqName.size());
    	Thread.sleep(4000);
				
		List<WebElement> answerCount = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]"));
		System.out.println("size of option : " + answerCount.size());
		
		System.out.println("FAQ Name : " + faqName.size() + " = > count : " + answerCount.size());
		
		 int count = 0;
			
			for(int i = 0; i<faqName.size(); i++)
			{
				
				count++;
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")));
				WebElement faqName1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")).get(i);
				String text1 = faqName1.getText();
			
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")));
				WebElement answerCount1 = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")).get(i);
				String answerC = answerCount1.getText();
				char answerCun = answerC.charAt(0);
				
				
				System.out.println(text1 + " => " + answerCun);
				
				//click on view
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[2]")));
				driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[2]")).get(i).click();
				
				//popup Answers
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role ='document']/descendant::form/descendant::div[3]/child::div/child::div[2]/descendant::label")));
				List<WebElement> popupAnswer = driver.findElements(By.xpath("//div[@role ='document']/descendant::form/descendant::div[3]/child::div/child::div[2]/descendant::label"));
				int popupAnswerSize = popupAnswer.size();
				System.out.println("Option count : " +  "Desc count " );
				System.out.println( answerCun + ":" + popupAnswerSize);
				
				Thread.sleep(3000);
								
				driver.findElement(By.xpath("//div[@role ='document']/descendant::form/descendant::div[3]/following-sibling::div/child::button[@id='closeModal']")).click();
				
			}
		
	}
	
	@Test(priority=4, description="FAQ comparision", groups="FAQ")
	 public void faqCompare() throws Exception
		{WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);	
		
	    HashMap<String, String> tagNameAndOption = new HashMap<String, String>();	
		
		List<WebElement> faqNames = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of TagName : " + faqNames.size());
    	Thread.sleep(4000);
				
		List<WebElement> optionCount = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]"));
		System.out.println("size of option : " + optionCount.size());
		
		System.out.println("TagName : " + faqNames.size() + " = > count : " + optionCount.size());
		
		int count = 0;
		
		for(int i = 0; i<faqNames.size(); i++)
		{
			
			count++;
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")));
			WebElement faqNames1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")).get(i);
			String text1 = faqNames1.getText();
		//	System.out.println("Tag Name in Product Tags : " + text1);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")));
			WebElement optionCount1 = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-faq/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")).get(i);
			System.out.println(text1 + " => " + optionCount1.getText());
				
			tagNameAndOption.put(text1, optionCount1.getText());
			
			Thread.sleep(3000);
			// back
			
			driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/descendant::span[1]")).click();
			
			// catalog and products
			driver.findElement(By.xpath("//a[normalize-space()='Catalog & Products']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]")));
			WebElement addpro = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]"));
			ac.click(addpro).build().perform();
			
			//driver.findElement(By.xpath("//div[@class='top-filter-sec list-button mt-2 ng-tns-c90-2']//button[3]")).click();
			
			driver.findElement(By.xpath("//span[normalize-space()='Apply FAQ']")).click();
			
			Thread.sleep(2000);
			
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("window.scrollBy(0,810)");
			
			List<WebElement> profaq = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[6]/descendant::div[1]/following-sibling::div/descendant::b"));
			System.out.println("size of FAQ in product page: " + profaq.size());
			
		
			for(int j =0; j< profaq.size(); j++)
			{
				String text = profaq.get(j).getText();
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
	 
	   @Test(priority=5, description="removing the faq", groups="FAQ")
		public void remove()
		{
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			//clicking on remove button
			driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-faq/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[1]")).get(3).click();
			
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
