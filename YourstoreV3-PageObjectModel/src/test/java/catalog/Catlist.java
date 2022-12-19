package catalog;

import java.util.HashMap; 
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(priority=0, description="Catalog List", groups="Catlist")
public class Catlist extends BaseClass{
	
	public void catListInOut() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")));
		driver.findElement(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")).click();
		Thread.sleep(3000);
	
	Actions ac = new Actions(driver);
		
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Catalog Name']")));
	
    driver.navigate().refresh();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Catalog Name']")));
	
    WebElement catalog_Name = driver.findElement(By.xpath("//p[normalize-space()='Catalog Name']"));
    String cat_Name = catalog_Name.getText();
    String expectedTitle = "Catalog Name";
    Assert.assertEquals(cat_Name, expectedTitle);
    
    HashMap<String, String> CatalogNameAndProduct = new HashMap<String, String>();
    
      // catalog Name
      List<WebElement> catalogN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]"));
      
      //Product count
      List<WebElement> prodN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[2]"));
     
      //clicking on view
      List<WebElement> view = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/descendant::div[2]/descendant::button[contains(text(),'View')]"));
      
    System.out.println("count: " + catalogN.size() +" & " + prodN.size());
   
    
    int count=0;
  
    
    for(int i =0; i<catalogN.size(); i++)
    {
    
    	count++;
    	Thread.sleep(2000);

    		WebElement catN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")).get(i);
    		System.out.println("catalog Name: " + catN.getText());
    		Thread.sleep(2000);
    		WebElement ProdN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[2]")).get(i);
    		System.out.println("prodN : "+ProdN.getText());
    		
    		 
    		//click on view
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/descendant::div[2]/descendant::button[contains(text(),'View')]")));
    	    driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/descendant::div[2]/descendant::button[contains(text(),'View')]")).get(i).click();

    	Thread.sleep(3000);
        
    	// inside product count
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div[3]/following-sibling::div/child::p")));//div[@class='col-md-6 d-flex justify-content-end ng-tns-c87-1']/child::p
    	String insidePCount = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div[3]/following-sibling::div/child::p")).getText();
    	System.out.println("inside Product  : " + insidePCount.substring(6));
    	
    	System.out.println(count);
    	
   // 	insidePCount.codePointCount(6,16);

    	Thread.sleep(2000);
        
    	//clicking on back arrow
    	driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div/descendant::div[2]/descendant::span[contains(text(),'arrow_back')]")).click();
    	try {
    	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
		
		 System.out.println("frame found and switched ");
			
		 WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
			
		 ac.moveToElement(close).click().build().perform();
		 System.out.println("closing the frame ");
    	}catch(Exception e)
    	{
    		System.out.println("No frame available");
    	}
		 driver.switchTo().defaultContent();
    	
    	
    	Thread.sleep(2000);
    	
    	
  
    }    
    
    driver.findElement(By.xpath("//pagination-controls[@responsive='true']/descendant::ul/child::li[5]/child::a")).click();
    Thread.sleep(3000);
    System.out.println("count: " + catalogN.size() +" & " + prodN.size());
    for(int i =0; i<catalogN.size(); i++)
    {
    
    	count++;
    	Thread.sleep(2000);

    		WebElement catN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")).get(i);
    		System.out.println("catalog Name: " + catN.getText());
    		Thread.sleep(2000);
    		WebElement ProdN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[2]")).get(i);
    		System.out.println("prodN : "+ProdN.getText());
    		
    		
    		//click on view
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/descendant::div[2]/descendant::button[contains(text(),'View')]")));
    	    driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/descendant::div[2]/descendant::button[contains(text(),'View')]")).get(i).click();

    	Thread.sleep(3000);
        
    	// inside product count
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div[3]/following-sibling::div/child::p")));//div[@class='col-md-6 d-flex justify-content-end ng-tns-c87-1']/child::p
    	String insidePCount = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div[3]/following-sibling::div/child::p")).getText();
    	System.out.println("inside Product  : " + insidePCount.substring(6));
    	
    	System.out.println(count);
    	
   // 	insidePCount.codePointCount(6,16);

    	Thread.sleep(2000);
        
    	//clicking on back arrow
    	driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div/descendant::div[2]/descendant::span[contains(text(),'arrow_back')]")).click();
    	
    	
    	Thread.sleep(2000);
    	
    	
  
    }    
   
//    for(int i =0; i<catalogN.size();i++)
//    {
//    	
//    	CatalogNameAndProduct.put(catalogN.get(i).getText(), prodN.get(i).getText());
//   }
//    Thread.sleep(3000);
//
//    
//    Set s=CatalogNameAndProduct.entrySet();
//    Iterator is =(Iterator) s.iterator();
//    
//    while(is.hasNext())
//    {
//        Map.Entry<String, String> m = (Map.Entry)is.next();
//        System.out.println(m.getKey()+"  =>  "+ m.getValue());//get values
//        
//    }
    Thread.sleep(3000);
    System.out.println("Completed");
//    driver.quit();
//	
}
	
	

}