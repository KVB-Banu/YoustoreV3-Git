package productextras;

import java.util.HashMap; 
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test; 

public class productTags extends BaseClass {
	
	static String searchKey = "skirt" ;
	static String name = "test11";
	
	@Test(priority=12, description="clicking on the product", groups="product tags")
	public void clickPro() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Product Extras']")).click();
		driver.findElement(By.xpath("//label[normalize-space()='Product Tags']")).click();
		Thread.sleep(3000);
	}
	
	  @Test(priority=13, description="Adding the product tags", groups="product tags")
		public void addProdTags() throws InterruptedException
		{
			
		Actions ac = new Actions(driver);
		try {
			
		 WebElement add = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-tags/div/div[2]/div/div[2]/button[2]/span"));
		ac.click(add).build().perform();
		
		
		}catch(Exception e)
		{
			System.out.println("not accessable");
		}
		
		
		driver.findElement(By.name("name")).sendKeys(name);
		  
		driver.findElement(By.id("name")).sendKeys("bangle1");
		try {
		driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
		String error = driver.findElement(By.cssSelector("body > ngb-modal-window > div > div > form > div > div.modal-body.ng-tns-c91-2.ng-star-inserted > div.ng-tns-c91-2.ng-star-inserted > p")).getText();
		System.out.println(error);
		if(error.contains("Tag name already exists"))
		{
			driver.findElement(By.xpath("//*[@id=\"closeModal\"]/span")).click();	
		}
			}catch(Exception e)
		{
				driver.findElement(By.xpath("//*[@id=\"closeModal\"]/span")).click();
		}
		}
		
		
	    @Test(priority=15, description="searching the product tags", groups="product tags")
		public void search() throws InterruptedException
		{
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(searchKey);
		
		List<WebElement> tagNames = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-product-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of TagName : " + tagNames.size());
    	Thread.sleep(4000);
		
		}
		
		
	    @Test(priority=14, description="comparing the product tags", groups="product tags")
		public void tagCompare() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);	
		
	    HashMap<String, String> tagNameAndOption = new HashMap<String, String>();	
		
		List<WebElement> tagNames = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-product-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of TagName : " + tagNames.size());
    	Thread.sleep(4000);
				
		List<WebElement> optionCount = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-product-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]"));
		System.out.println("size of option : " + optionCount.size());
		
		System.out.println("TagName : " + tagNames.size() + " = > count : " + optionCount.size());
		
		int count = 0;
		
		for(int i = 0; i<tagNames.size(); i++)
		{
			
			count++;
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")));
			WebElement tagNames1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")).get(i);
			String text1 = tagNames1.getText();
		//	System.out.println("Tag Name in Product Tags : " + text1);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-product-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")));
			WebElement optionCount1 = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-product-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[2]")).get(i);
			System.out.println(text1 + " => " + optionCount1.getText());
				
			tagNameAndOption.put(text1, optionCount1.getText());
			
			Thread.sleep(3000);
			// back
			
			driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-tags/div/div[1]/div/div/div/span")).click();
			
			// catalog and products
			driver.findElement(By.xpath("//a[normalize-space()='Catalog & Products']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]")));
			WebElement addpro = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]"));
			ac.click(addpro).build().perform();
			
			//driver.findElement(By.xpath("//div[@class='top-filter-sec list-button mt-2 ng-tns-c90-2']//button[3]")).click();
			
			driver.findElement(By.xpath("//span[normalize-space()='Apply Tags']")).click();
			
			Thread.sleep(2000);
			
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("window.scrollBy(0,810)");
			
			List<WebElement> proTags = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[4]/descendant::div[2]/following-sibling::div/child::div/descendant::b"));
			System.out.println("size of tags in product page: " + proTags.size());
			
		
			for(int j =0; j< proTags.size(); j++)
			{
				String text = proTags.get(j).getText();
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
		
		
//		 Set s=tagNameAndOption.entrySet();
//	     Iterator is =(Iterator) s.iterator();
//	    
//	    while(is.hasNext())
//	    {
//	        Map.Entry<String, String> m = (Map.Entry)is.next();
//	        System.out.println(m.getKey()+"  =>  "+ m.getValue());//get values
//	        
//	    }
		

	//	driver.quit();
	}

}
