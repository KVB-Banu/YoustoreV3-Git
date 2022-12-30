package AbandonedCart;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AbandonedCart extends BaseClass {

	@Test(priority=0, description =" abandoned cart")
	public void clickPro()
	{	
		WebDriverWait wait = new WebDriverWait(driver,50);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Orders']")));
		driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='collapse2']/descendant::a[contains(text(),' Abandoned Cart ')]")));
		driver.findElement(By.xpath("//div[@id='collapse2']/descendant::a[contains(text(),' Abandoned Cart ')]")).click();
		

	}
	
	@Test(priority=1, description="checking on contct's in abandoned cart", enabled=false)
	public void contact() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,50); 
		Actions ac = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-abandoned/child::app-abandoned-customers/child::div/child::div[3]/descendant::button[contains(text(),'Contact')][1]")));
	    
	//	driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-abandoned/child::app-abandoned-customers/child::div/child::div[3]/descendant::button[contains(text(),'Contact')][1]")).click();
		
		for(int i=0; i<3; i++)
		{
			
			driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-abandoned/child::app-abandoned-customers/child::div/child::div[3]/descendant::button[contains(text(),'Contact')][1]")).click();
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='app-admin-wrap layout-sidebar-large']/child::div[3]/descendant::app-abandoned-customers/child::div/child::div[3]/descendant::div[5]/child::div/descendant::div[3]/child::button/following-sibling::div/child::a")));
			List<WebElement> dropdown = driver.findElements(By.xpath("//div[@class='app-admin-wrap layout-sidebar-large']/child::div[3]/descendant::app-abandoned-customers/child::div/child::div[3]/descendant::div[5]/child::div/descendant::div[3]/child::button/following-sibling::div/child::a"));
			ac.moveToElement(dropdown.get(i)).click().build().perform();
			
			Thread.sleep(3000);
			
			String parent = driver.getWindowHandle();

			Set<String> s = driver.getWindowHandles();

			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {

				String child_window = I1.next();

				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);

					System.out.println(driver.switchTo().window(child_window).getTitle());
					driver.close();
				}
		
				driver.switchTo().window(parent);
				
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
			
				
		}
	}
}
	
	@Test(priority=2, description="clicking on view")
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,50); 
		Actions ac = new Actions(driver);
		int count=0;
		
		for(int i=0; i<3; i++)
		{
			count++;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-abandoned/child::app-abandoned-customers/child::div/child::div[3]/descendant::button[contains(text(),'View')]")));
		List<WebElement> view = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/descendant::app-abandoned/child::app-abandoned-customers/child::div/child::div[3]/descendant::button[contains(text(),'View')]"));
		ac.click(view.get(i)).build().perform();
		
		System.out.println("clicked on view");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-abandoned-details/descendant::span[contains(text(),'arrow_back')]")));
		WebElement backArrow = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-abandoned-details/descendant::span[contains(text(),'arrow_back')]"));
		ac.click(backArrow).build().perform();
		 
		System.out.println(count);
		Thread.sleep(3000);
		}
		
	}
	
}
