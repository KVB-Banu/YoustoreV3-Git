package marketingTools;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Customer extends BaseClass {
	
	
	String customer = "Sumaiya";
	
	@Test(priority=0, description="clicking on Marketing tool")
	public void clickPro()
	{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		Actions ac = new Actions(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Marketing Tools']")));
		driver.findElement(By.xpath("//span[normalize-space()='Marketing Tools']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion-collapse collapse show']/descendant::a[contains(text(),'Customers')]")));
		driver.findElement(By.xpath("//div[@class='accordion-collapse collapse show']/descendant::a[contains(text(),'Customers')]")).click();
		
		
	}
	
	@Test(priority=1, description="searching the customer")
	public void search()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		Actions ac = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/descendant::input[@name='search_bar']")));
		WebElement search = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/descendant::input[@name='search_bar']"));
		ac.click(search).sendKeys(customer).sendKeys(Keys.ENTER).build().perform();
		
	}
	
	@Test(priority=2, description="Signed up users")
	public void signedupUsers() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		Actions ac = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-customers[@class='ng-star-inserted']/descendant::a[1]")));
		String signupUsers = driver.findElement(By.xpath("//app-customers[@class='ng-star-inserted']/descendant::a[1]")).getText();
		System.out.println("user: " + signupUsers);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/descendant::p[1]")));
		List<WebElement> customerDetails = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println(customerDetails.size());
		int count=0;
		
	    for(int i=0; i<customerDetails.size(); i++)
	    {
	    count++;
	    Thread.sleep(5000);
	    	try {
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/descendant::p[1]")));
	    List<WebElement> customerDetails1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/descendant::p[1]"));	
	    String text = customerDetails1.get(i).getText();
        System.out.println(text);
	    	}catch(Exception e)
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/descendant::p[1]")));
	    		WebElement customerDetails2 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/descendant::p[1]")).get(i);
	    		String text = customerDetails2.getText();
	    		System.out.println(text);
	    	}
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]")));
        driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]")).get(i).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]/following-sibling::div/child::button[contains(text(),' Live')]")));
        List<WebElement> liveOrders = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]/following-sibling::div/child::button[contains(text(),' Live')]"));
        ac.moveToElement(liveOrders.get(i)).click().build().perform();
        
        try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[1]/child::span")));
        String allorders = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[1]/child::span")).getText();
        System.out.println("All Orders Count: " + allorders);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[2]/child::span")));
        String newOrder = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[2]/child::span")).getText();
        System.out.println("New Orders Count: " + newOrder);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[3]/child::span")));
        String confirmedOrders = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[3]/child::span")).getText();
        System.out.println("Confirmed Orders Count: " + confirmedOrders);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[4]/child::span")));
        String dispatchedOrders = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/descendant::p[4]/child::span")).getText();
        System.out.println("Dispatched Orders Count: " + dispatchedOrders);
        }catch(Exception e)
        {
        	System.out.println("Order count Not available");
        }
       // driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[4]/child::div/child::div/child::div/following-sibling::div"));
        
        clickPro();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]")));
        driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]")).get(i).click();
        
        WebElement completedOrders = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]/following-sibling::div/child::button[contains(text(),' Completed')]")).get(i);
        ac.click(completedOrders).build().perform();
        Thread.sleep(3000);
        
        String title = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/descendant::h1")).getText();
		System.out.println(title);
        clickPro();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]")));
        driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]")).get(i).click();
        List<WebElement> compOrderList = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div"));
        System.out.println("Compleated orders count:" + compOrderList.size());
        
        WebElement cancelledOrders = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-signup-users/child::div/child::div[2]/descendant::div[2]/child::div/following-sibling::div/child::div[2]/descendant::button[contains(text(),'View Orders ')]/following-sibling::div/child::button[contains(text(),' Cancelled')]")).get(i);
        ac.click(cancelledOrders).build().perform();
        Thread.sleep(3000);
        String title1 = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/descendant::h1")).getText();
		System.out.println(title1);
		
		List<WebElement> cancelledOrderList = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-product-orders/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div"));
	    System.out.println("Cancelled orders count:" + cancelledOrderList.size());
		
        clickPro();
        System.out.println(count);
        try {
        	
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
				
			 System.out.println("frame found and switched ");
				
			 WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
				
			 ac.moveToElement(close).click().build().perform();
			 System.out.println("closing the frame ");
			 
        }catch(Exception e) {
        
        System.out.println("chatbox not opened");
	 
	    }
	    driver.switchTo().defaultContent();
	
	}
 }

}
