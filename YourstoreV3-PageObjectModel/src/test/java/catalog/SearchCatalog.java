package catalog;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



@Test(priority=0, description="search the catalog", groups="search")
public class SearchCatalog extends BaseClass {
	
	String catalog_name = "yourstore";
	
	public void search() throws InterruptedException {
	driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();	
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Actions ac = new Actions(driver);
	
	driver.findElement(By.name("search_bar")).sendKeys(catalog_name);
	
	System.out.println("Search name: " + catalog_name);
	
	List<WebElement> catalogN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]"));
	System.out.println("number of Products: " + catalogN.size());
	List<WebElement> prodN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[2]"));
	
	Thread.sleep(2000);
	for(int i =0; i< catalogN.size(); i++)
	{
		//driver.findElement(By.name("search_bar")).sendKeys(catalog_name);
		System.out.println("Catalog Name : " + catalogN.get(i).getText());
		System.out.println("Product Count : " + prodN.get(i).getText());
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/descendant::div[2]/descendant::button[contains(text(),'View')]")));
//	    driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/descendant::div[2]/descendant::button[contains(text(),'View')]")).get(i).click();
// 
//         Thread.sleep(3000);
//        
//    	// inside product count
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div[3]/following-sibling::div/child::p")));//div[@class='col-md-6 d-flex justify-content-end ng-tns-c87-1']/child::p
//    	String insidePCount = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div[3]/following-sibling::div/child::p")).getText();
//    	System.out.println("Total Product Count inside the Catalog is : " + insidePCount);
//
//    	Thread.sleep(2000);
//        
//    	//clicking on back arrow
//    	driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-products//div/descendant::div/descendant::div[2]/descendant::span[contains(text(),'arrow_back')]")).click();
//    	

    	Thread.sleep(2000);
	}
	
	
	}

}
