package catalog;

import java.io.IOException; 

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;






public class ACatalog extends BaseClass{
	
	static String name = "YourStore2";
	static String description = "kjfhg jdbgkjf  jnbdkjfdg kjkdjgkjd";
	
   @BeforeClass	
   public void clickPro() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
		
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::div[2]/descendant::a[contains(text(),'Catalogs')]")).click();
		
		
	   }
	   
	@Test(priority=0, description="adding catalog", groups="adding")	
   public void addCat() throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Actions ac = new Actions(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-catalogs/child::div/descendant::button[contains(text(),'Add Catalog ')]")));
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-catalogs/child::div/descendant::button[contains(text(),'Add Catalog ')]")).click();
		driver.findElement(By.xpath("//i[@class='material-icons add-img']")).click();
		
		Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image4.exe");
		Thread.sleep(4000);
		driver.findElement(By.name("name")).sendKeys(name);
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys(description);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Enable Header Content']")));
		driver.findElement(By.xpath("//span[normalize-space()='Enable Header Content']")).click();
		
		
		obj.executeScript("window.scrollBy(0,600)");
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.name("title")));
//		driver.findElement(By.name("title")).sendKeys("yourstr");
		
		driver.findElement(By.xpath("//quill-editor[@class='rounded ng-untouched ng-pristine ng-valid']//div[@class='ql-editor ql-blank']")).sendKeys(description);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Enable Social Media Links']")));
		driver.findElement(By.xpath("//span[normalize-space()='Enable Social Media Links']")).click();
		
		
//		try {
//		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='light-button']")));
//		       System.out.println("Element is clickable");
//		     }
//		catch(TimeoutException e) {
//		       System.out.println("Element isn't clickable");
//		    }
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='light-button']")));
//		driver.findElement(By.xpath("//button[@class='light-button']")).click();
//		Thread.sleep(4000);
		
	//	obj.executeScript("window.scrollBy(0,300)");
	//	driver.switchTo().frame(0);
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::form/child::div/child::div[2]/child::div/child::div[6]/following-sibling::div[1]/descendant::div[3]/descendant::div[2]/child::select")));
//		Select s = new Select(driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::form/child::div/child::div[2]/child::div/child::div[6]/following-sibling::div[1]/descendant::div[3]/descendant::div[2]/child::select")));
//		s.selectByIndex(0);
//				
//	    List<WebElement> op = s.getOptions();
//		 		
//		for(int i=0; i<op.size();i++)
//		{
//			
//			String options = op.get(i).getText();
//			System.out.println("options are : " + options);
//			
//		}
//		Thread.sleep(1000);
//		try {
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")));
//		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")).sendKeys("/facebook");
//		}catch(Exception e) {
//		driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div/app-product-sections/app-catalog-event/div/form/div[1]/div[2]/div[1]/div[7]/div/div/div/div/div[2]/input")).sendKeys("/facebook");
//		}
//		
		Thread.sleep(3000);
				
		String link = driver.findElement(By.xpath("//p[@class='light-font font-10 mb-1 ng-star-inserted']")).getText();
		System.out.println(link);
		
		 try {	
			  
		     WebElement chatframe = driver.findElement(By.xpath("//iframe"));
		     
		     if(chatframe.isEnabled()) {
		    	 
		     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
			
			 System.out.println("frame found and switched ");
		     WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
			
			 ac.moveToElement(close).click().build().perform();
			 System.out.println("closing the frame in the after clickpro ");
		     }
			 
         }catch(Exception e)
         {
         	System.out.println("chat box is not popped up");
         }
	  driver.switchTo().defaultContent(); 
		
		
		driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
		
		Thread.sleep(3000);
		
		  try {	
			  
			     WebElement chatframe = driver.findElement(By.xpath("//iframe"));
			     
			     if(chatframe.isEnabled()) {
			    	 
			     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
				
				 System.out.println("frame found and switched ");
			     WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
				
				 ac.moveToElement(close).click().build().perform();
				 System.out.println("closing the frame in the after clickpro ");
			     }
				 
             }catch(Exception e)
             {
             	System.out.println("chat box is not popped up");
             }
		  driver.switchTo().defaultContent(); 
		
		WebElement error = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div/app-product-sections/app-catalog-event/div/form/div[3]/div[1]/p"));
		
		
		if(error.isDisplayed())
		{
			System.out.println("Error Message is:" + error.getText());
			try {
		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='black-outline-txt']")));
			System.out.println("Cancel button is clickable");
			}catch(Exception e)
			{
				System.out.println("Cancel button is not clickable");
			}
			
		}
		 driver.findElement(By.xpath("//span[@class='black-outline-txt']")).click();
		 System.out.println("cancelled");
		
		
	}
	
	@Test(priority=1, description="comparing catalog", groups="compare", enabled=false)
	public void catalogCompare() throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver, 50);
		  Actions ac = new Actions(driver);
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")));
		  List<WebElement> catalogNames = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]"));
		 
		  System.out.println("catalognames size: " + catalogNames.size());
		 for(int j =0; j<1; j++)
		 {
			  
		  for(int i =0; i<(catalogNames.size()-1); i++)
		  {
			
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")));
			  WebElement catalogNames1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")).get(i+1);
			  String a = catalogNames1.getText();
			  System.out.println(a);
			  
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")));
			  driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")).click();
			  Thread.sleep(3000);
			  
			  JavascriptExecutor obj = (JavascriptExecutor) driver;
			  obj.executeScript("window.scrollBy(0,610)");
			  			  
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/child::div[8]/descendant::div[2]/following-sibling::div/descendant::label/child::span")));
			  List<WebElement> catalogElementsNameInProduct = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/child::div[8]/descendant::div[2]/following-sibling::div/descendant::label/child::span"));
			 
			  for(WebElement x : catalogElementsNameInProduct)
				{
					String text = x.getText();
								
					//	System.out.println("Add on Names in Add product : " + text);
					Thread.sleep(4000);
					
					if(a.contains(text))
					{
						System.out.println(text + " Catalog option is present"  );
	
					break;
					}
					
					
				}
			  
			            
			  clickPro();
			  System.out.println("clicking on the clickpro");
			  
			  try {	
				  
				     WebElement chatframe = driver.findElement(By.xpath("//iframe"));
				     
				     if(chatframe.isEnabled()) {
				    	 
				     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
					
					 System.out.println("frame found and switched ");
				     WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
					
					 ac.moveToElement(close).click().build().perform();
					 System.out.println("closing the frame in the after clickpro ");
				     }
					 
	                }catch(Exception e)
	                {
	                	System.out.println("chat box is not popped up");
	                }
			  driver.switchTo().defaultContent(); 
			  
			  Thread.sleep(4000);
			  
			  
		  }
		  
		  driver.findElement(By.xpath("//pagination-controls[@responsive='true']/descendant::ul/child::li[5]/child::a")).click();
		  
		 }
	}
		 
		
		
	
	@Test(priority=2, description="search the catalog", groups="search")
	public void SearchCatalog() throws InterruptedException {
		
	driver.navigate().refresh();	
	
    driver.findElement(By.name("search_bar")).sendKeys(name);
	
	System.out.println("Search name: " + name);
	
	List<WebElement> catalogN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]"));
	System.out.println("number of Products: " + catalogN.size());
	List<WebElement> prodN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[2]"));
	
	Thread.sleep(2000);
	for(int i =0; i< catalogN.size(); i++)
	{
		//driver.findElement(By.name("search_bar")).sendKeys(catalog_name);
		System.out.println("Catalog Name : " + catalogN.get(i).getText());
		System.out.println("Product Count : " + prodN.get(i).getText());
	}
	}
	
	@Test(priority=3, description="comparing search item catalog", groups="compare", enabled=true)
	public void catalogSearchCompare() throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver, 50);
		  Actions ac = new Actions(driver);
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")));
		  List<WebElement> catalogNames = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]"));
		 
		  System.out.println("catalognames size: " + catalogNames.size());
		  Thread.sleep(3000);
		  
		  
			  String a = catalogNames.get(0).getText();
			  System.out.println(a);
			  
			  driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::a[normalize-space()='Products']")).click();
			  
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")));
			  driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")).click();
			  Thread.sleep(3000);
			  
			  JavascriptExecutor obj = (JavascriptExecutor) driver;
			  obj.executeScript("window.scrollBy(0,610)");
			  
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/child::div[8]/descendant::div[2]/following-sibling::div/descendant::label/child::span")));
			  List<WebElement> catalogElementsNameInProduct = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/child::div[8]/descendant::div[2]/following-sibling::div/descendant::label/child::span"));
			 
			  for(WebElement x : catalogElementsNameInProduct)
				{
					String text = x.getText();
								
					//	System.out.println("Add on Names in Add product : " + text);
					Thread.sleep(4000);
					
					if(a.contains(text))
					{
						System.out.println(text + " Catalog option is present"  );
	
					break;
					}
					
					
				}
		  }
	
}

