package orders;

import org.openqa.selenium.By; 
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class CancelledOrders extends BaseClass {
	
	@Test(priority=0, description="Cancel order's ", groups="cancelorders" )
	public void liveorders() throws Exception {
	Actions ac = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Orders']")));
		driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Live Orders']")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		System.out.println("Total Price shows in menu :" + driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-orders/app-product-orders/div/div[4]/div[1]/div/div[2]/div[1]/p[4]")).getText());
		
//		//Search bar - have to enable When we run along with front end
//		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
//		ac.click(search).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.HOME).sendKeys(Keys.DELETE).sendKeys(Keys.ENTER).build().perform();
	
	   // String orderStatusMenu = driver.findElement(By.xpath("//body//app-root//div[2]//div[2]//p[2]//span[1]")).getText();
		
		// click on View
        driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-orders[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/p[3]")).click();
		// driver.findElement(By.xpath("//div[11]//div[2]//p[3]//a[1]")).click();
        Thread.sleep(6000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".font-16.dark-font.m-b-0")));
		WebElement order = driver.findElement(By.cssSelector(".font-16.dark-font.m-b-0"));
		String orderNum = order.getText();
		ac.doubleClick(order).doubleClick(order).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		System.out.println("Order:" + orderNum);
		
		Thread.sleep(2000);
	}
	
	@Test(priority=1, description="clicking on cancel order in liveorder section", groups="cancelorders" )
	public void cancelOrder() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		// click more options
		driver.findElement(By.xpath("//span[@class='material-symbols-rounded mr-1']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Cancel Order')]")).click();
		Thread.sleep(2000);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']")));
			System.out.println("Yes button is clickable");
			}catch(Exception e) {
				System.out.println("Yes button isn't clickable");
			}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'black-outline-txt')]")));
			System.out.println("No button is clickable");
			}catch(Exception e) {
				System.out.println("No button isn't clickable");
			}
		    driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		  
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[1]")));
			System.out.println("The products will revert back to stock : " + "Cancel Button is clickable");
		    }catch(Exception e)
		    {
			System.out.println("The products will revert back to stock : " + "Cancel Button isn't clickable");
		    }
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[2]")));
			System.out.println("The products will revert back to stock : " + "Ok Button is clickable");
			
		    }catch(Exception e)
		    {
			System.out.println("The products will revert back to stock : " + "Ok Button isn't clickable");
		    }
		try {
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[2]")));
		   driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
		   }catch(Exception e)
		   {
			   driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
		   }
		    Thread.sleep(3000);
	}
	
	
	
	@Test(priority=2, description="Cancelled order section", groups="cancelorders" )
		    public void cancelledOrder() throws Exception {
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, 20);
		    	Actions ac = new Actions(driver);
		    	try {
		    		String title = driver.findElement(By.xpath("//h1[normalize-space()='Cancelled Orders']")).getText();
		    		System.out.println("Order moved to " + title);
		    		Thread.sleep(3000);
		    		}catch(Exception e) {
		    			String title = driver.findElement(By.xpath("//h1[normalize-space()='Cancelled Orders']")).getText();
		    			System.out.println("catch Order moved to " + title);
		    			
		    		}
		    	
		    	WebElement search = driver.findElement(By.name("search_bar"));
				ac.click(search).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.HOME).sendKeys(Keys.DELETE).sendKeys(Keys.ENTER).build().perform();	
				Thread.sleep(3000);
				try {
					 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-orders/app-product-orders/div/div[3]/div[1]/div/div[2]/div[2]/p[2]/a")));
					 WebElement view = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-orders/app-product-orders/div/div[3]/div[1]/div/div[2]/div[2]/p[2]/a"));
					 ac.click(view).build().perform();
					}catch(Exception e)
					{
						driver.findElement(By.cssSelector("body app-root div:nth-child(2) div:nth-child(2) p:nth-child(2) a:nth-child(1)")).click();
					}
					
					System.out.println("Order# is: " + driver.findElement(By.cssSelector(".font-16.dark-font.m-b-0")).getText() );
					Thread.sleep(3000);
		    	
					
					String status = driver.findElement(By.xpath("//button[@class='dropdown-toggle ml-3 white-button-right-icon'][1]/child::span[1]")).getText();
					System.out.println("Status is" + status);
					
					if(status.equals(status)) {
						    System.out.println("status is :" + status);
							WebElement cancel = wait.until(ExpectedConditions
									.presenceOfElementLocated(By.cssSelector("div[class='d-flex align-items-center ng-star-inserted'] span[class='font-12 medium-font']")));

							if (cancel.isEnabled()) {

								System.out.println("Cancelled");
							}
							else {
                             
							System.out.println("not Cancelled");
						}
					}
		    
		
	}
}



