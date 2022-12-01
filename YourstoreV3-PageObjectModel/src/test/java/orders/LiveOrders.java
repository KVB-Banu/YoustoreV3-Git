package orders;

import java.io.File; 
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class LiveOrders extends BaseClass {
	
	@Test(priority=0, description="liveorders", groups="liveorders" )
	public void liveOrders() throws InterruptedException, IOException {

	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        
        
   /*  //  coping the order number and search it in search bar
        WebElement copyOrder = driver.findElement(By.cssSelector(".font-16.dark-font.m-b-0"));
        ac.doubleClick(copyOrder).doubleClick(copyOrder).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='material-symbols-rounded pr-2 cursor']")).click();
        Thread.sleep(2000);
		  WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		  ac.click(search).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.HOME).sendKeys(Keys.DELETE).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		try {
			WebElement view = driver.findElement(By.cssSelector("body app-root div:nth-child(2) div:nth-child(2) p:nth-child(3) a:nth-child(1)"));
			ac.click(view).build().perform();
			Thread.sleep(2000);
		}catch(Exception e) {
        driver.findElement(By.xpath("body app-root div:nth-child(2) div:nth-child(2) p:nth-child(3) a:nth-child(1)")).click();} */
	
		Thread.sleep(2000);
		
		//Order#
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".font-16.dark-font.m-b-0")));
		WebElement order = driver.findElement(By.cssSelector(".font-16.dark-font.m-b-0"));
		String orderNum = order.getText();
		ac.doubleClick(order).doubleClick(order).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		System.out.println("Order:" + orderNum);
		
		Thread.sleep(2000);
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy, (0,600)");
		
		//printing the billing details of the product
		
		  try {
		        System.out.println("Sub Total : " + driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-orders/app-product-order-details/div/div[2]/div[4]/div/div[3]/div[2]/p")).getText());
		        System.out.println("Shipping Cost : " + driver.findElement(By.cssSelector("div[class='data-list-card type5-card ng-star-inserted'] p[class='m-b-0 font-12 text-light medium-font']")).getText());
		        try {
		        WebElement Discount = driver.findElement(By.xpath("//p[normalize-space()='Discount']")); 
		        if(Discount.isEnabled()) {
		        System.out.println("Discount : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-order-details[1]/div[1]/div[2]/div[4]/div[1]/div[5]/div[2]/p[1]")).getText());
		        Thread.sleep(2000);
		        System.out.println("Grand Total : " + driver.findElement(By.cssSelector("body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open.top_space > app-orders > app-product-order-details > div > div.col-md-9.col-12.mb-3.ng-star-inserted > div:nth-child(4) > div > div:nth-child(6) > div.col-md-2.col-4.px-0.d-flex.justify-content-end > p")).getText());
		        }}catch(Exception e)
		         {
		        	System.out.println("Grand Total : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-order-details[1]/div[1]/div[2]/div[4]/div[1]/div[5]/div[2]/p[1]")).getText());
		        }
		        }catch(Exception e)
		        {
		        	System.out.println(e);
		        }
		  
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenshot, new File("C:\\Users\\white\\OneDrive\\Documents\\ScreenShots\\billing.backend.png"));
		  Thread.sleep(3000);
		  
		  try {
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='order-details-cardinner d-flex justify-content-between ng-star-inserted'] p:nth-child(1)")));
		 // WebElement offerCode = driver.findElement((By.cssSelector("div[class='order-details-cardinner d-flex justify-content-between ng-star-inserted'] p:nth-child(1)"))); 
		  System.out.println("Offer Redeemed, Offer Code is : " + driver.findElement(By.cssSelector("div[class='order-details-cardinner d-flex justify-content-between ng-star-inserted'] p:nth-child(1)")).getText() + ",   Offer Amount is : " + driver.findElement(By.cssSelector("body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open.top_space > app-orders > app-product-order-details > div > div.col-md-3.col-12 > div > div.order-details-cardinner.d-flex.justify-content-between.ng-star-inserted > p:nth-child(2)")).getText());
		  }catch(Exception e) {
			  System.out.println("Offer Code is not used");
		  }
		
	}
	
	
	@Test(priority=1, description="Mark as paid", groups="liveorders" )
	public void markAsPaid() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement payment = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(2) > app-store-layout:nth-child(3) > div:nth-child(1) > div:nth-child(3) > app-orders:nth-child(2) > app-product-order-details:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(2)"));

		String payment_Status = payment.getText();
	//  System.out.println(payment_Status);
		
		

		if (payment_Status.equals("Pending")) {

			System.out.println("Menu Payment Status :" + payment_Status);
            Thread.sleep(4000);
			// click more options
			driver.findElement(By.xpath("//span[@class='material-symbols-rounded mr-1']")).click();
			Thread.sleep(1000);

			// click on mark as paid
			driver.findElement(By.xpath("//div[@class='dropdown-menu show']//button[1]")).click();
			Thread.sleep(1000);

			// click on confirm
			driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/button[2]/span[1]")).click();
			Thread.sleep(1000);
		}

		Thread.sleep(4000);

		WebElement payment1 = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(2) > app-store-layout:nth-child(3) > div:nth-child(1) > div:nth-child(3) > app-orders:nth-child(2) > app-product-order-details:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(2)"));

		String payment_Status1 = payment1.getText();
//		System.out.println(payment_Status1);

		if (payment_Status1.equals("Paid")) {
			System.out.println("Payment status is:" + payment_Status1);
		} else {
			System.out.println("payment status is: " + payment_Status1);

		}
		
		Thread.sleep(2000);
	}
	
	
	
	@Test(priority=2, description="Status Confirmed", groups="liveorders" )
	public void statusConfirmed() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		try {
		//click on customization
		driver.findElement(By.xpath("//p[@class='m-b-0 font-12 color ng-star-inserted']")).click();
		Thread.sleep(1000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\white\\OneDrive\\Documents\\ScreenShots\\cust.backend.png"));
		driver.findElement(By.xpath("//a[normalize-space()='CLOSE']")).click();
		Thread.sleep(4000);
		}catch(Exception e)
		{
			System.out.println("No Customization available");
		}
		
		
			
		String placed = driver.findElement(By.xpath("//button[@class='dropdown-toggle ml-3 white-button-right-icon'][1]")).getText();
		if(placed.equals("Placed")) {
		// click on placed status
		driver.findElement(By.xpath("//button[contains(text(),'Status')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='dropdown-menu ng-star-inserted show']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//click on view
		driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-orders[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/p[3]")).click();
		
		}
			
			
	    
				
		WebDriverWait wait = new WebDriverWait(driver, 5);

		try {

			WebElement confirm = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[@class='font-12 medium-font ng-star-inserted']")));

			if (confirm.isEnabled()) {

				System.out.println("Confirmed");
			}


		} catch (Exception e) {
			System.out.println("not Confirmed");
		}

	}
	
	@Test(priority=3, description="Courier Partner", groups="liveorders" )
	public void courierPartner() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-details-cardcontent ng-star-inserted']/child::span[1]")));
		String shippingDetail = driver.findElement(By.xpath("//div[@class='order-details-cardcontent ng-star-inserted']/child::span[1]")).getText();
		System.out.println("Shipping datail : " + shippingDetail );
		if(shippingDetail.equals("Not Shipped"))
		{
		driver.findElement(By.xpath("//button[contains(text(),'Status')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='dropdown-menu ng-star-inserted show']")).click();
		Thread.sleep(1000);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("selected_cp")));
		Select s = new Select(driver.findElement(By.name("selected_cp")));
//		s.selectByIndex(0);
//		driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'cursor ml-3 font-12 medium-font m-b-0 text-left ng-star-inserted')]")));
				
		s.selectByIndex(1);
			
		driver.findElement(By.xpath("//label[text()='Courier Name']/following-sibling::input")).sendKeys("Blue Dart");
		driver.findElement(By.xpath("//label[text()='Tracking Number']/following-sibling::input")).sendKeys("676767676");
		driver.findElement(By.xpath("//label[text()='Tracking Link']/following-sibling::input")).sendKeys("/blue dart/6767676");
		driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
		Thread.sleep(6000);
		
		}
		
		
	}
	
	
	@Test(priority=4, description="Status Dispatched", groups="liveorders" )
	public void statusDispatched() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//click on view
		try {
		driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-orders[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/p[3]")).click();
		//driver.findElement(By.xpath("//div[11]//div[2]//p[3]//a[1]")).click();
	    Thread.sleep(3000);
		}catch(Exception e)
		{
			System.out.println("***exception : " + e);
		}
		Thread.sleep(3000);
		String shippingDetail = driver.findElement(By.xpath("//div[@class='order-details-cardcontent ng-star-inserted']/child::span[1]")).getText();
		System.out.println("Shipping datail : " + shippingDetail );
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Status')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(
				"//div[@class='dropdown-menu ng-star-inserted show']//button[@class='dropdown-item ng-star-inserted']"))
				.click();
		Thread.sleep(1000);
		try {
		driver.findElement(By.name("tracking_number")).sendKeys("123456789");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		}catch(Exception e)
		{
			driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
		}
		
		//click on view
		//driver.findElement(By.xpath("//div[11]//div[2]//p[3]//a[1]")).click();
		driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-orders[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/p[3]")).click();
		//above one 1st order view
		WebDriverWait wait = new WebDriverWait(driver, 5);

		try {

			WebElement dispatch = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.cssSelector("body > app-root:nth-child(2) > app-store-layout:nth-child(3) > div:nth-child(1) > div:nth-child(3) > app-orders:nth-child(2) > app-product-order-details:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > span:nth-child(2)")));

			if (dispatch.isEnabled()) {

				System.out.println("dispatched");
			}

			
		} catch (Exception e) {
			System.out.println("not dispatched");
		}
		
}
	
	
	
	@Test(priority=5, description="Status Delivered", groups="liveorders" )
	public void statusDelivered() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		Actions ac = new Actions(driver);
//		driver.findElement(By.xpath(
//				"//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-orders[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/p[3]"))
//				.click();
		Thread.sleep(2000);
//		String shipping = driver.findElement(By.cssSelector(".ng-star-inserted[target='_blank']")).getText();
//		System.out.println("Shipping details : " + shipping);
		driver.findElement(By.xpath("//button[contains(text(),'Status')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dropdown-menu ng-star-inserted show']//button[@class='dropdown-item ng-star-inserted']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		try {
		String title = driver.findElement(By.xpath("//h1[normalize-space()='Completed Orders']")).getText();
		System.out.println("Order moved to " + title);
		Thread.sleep(3000);
		}catch(Exception e) {
			String title = driver.findElement(By.xpath("//h1[normalize-space()='Completed Orders']")).getText();
			System.out.println("catch Order moved to " + title);
			
		}
		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.name("search_bar"));
		ac.click(search).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.HOME).sendKeys(Keys.DELETE).sendKeys(Keys.ENTER).build().perform();	
		
		try {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-orders/app-product-orders/div/div[3]/div[1]/div/div[2]/div[2]/p[2]/a")));
		 WebElement view = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-orders/app-product-orders/div/div[3]/div[1]/div/div[2]/div[2]/p[2]/a"));
		 ac.click(view).build().perform();
		}catch(Exception e)
		{
			driver.findElement(By.cssSelector("body app-root div:nth-child(2) div:nth-child(2) p:nth-child(2) a:nth-child(1)")).click();
		}
		
		System.out.println("Order# is: " + driver.findElement(By.cssSelector(".font-16.dark-font.m-b-0")).getText() );
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy, (0,600)");
		
		//printing the billing details of the product
		
		  try {
		        System.out.println("Sub Total : " + driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-orders/app-product-order-details/div/div[2]/div[4]/div/div[3]/div[2]/p")).getText());
		        System.out.println("Shipping Cost : " + driver.findElement(By.cssSelector("div[class='data-list-card type5-card ng-star-inserted'] p[class='m-b-0 font-12 text-light medium-font']")).getText());
		        try {
		        WebElement Discount = driver.findElement(By.xpath("//p[normalize-space()='Discount']")); 
		        if(Discount.isEnabled()) {
		        System.out.println("Discount : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-order-details[1]/div[1]/div[2]/div[4]/div[1]/div[5]/div[2]/p[1]")).getText());
		        Thread.sleep(2000);
		        System.out.println("Grand Total : " + driver.findElement(By.cssSelector("body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open.top_space > app-orders > app-product-order-details > div > div.col-md-9.col-12.mb-3.ng-star-inserted > div:nth-child(4) > div > div:nth-child(6) > div.col-md-2.col-4.px-0.d-flex.justify-content-end > p")).getText());
		        }}catch(Exception e)
		         {
		        	System.out.println("Grand Total : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-orders[1]/app-product-order-details[1]/div[1]/div[2]/div[4]/div[1]/div[5]/div[2]/p[1]")).getText());
		        }
		        }catch(Exception e)
		        {
		        	System.out.println(e);
		        }

		try {

			WebElement delivered = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.cssSelector("body > app-root:nth-child(2) > app-store-layout:nth-child(3) > div:nth-child(1) > div:nth-child(3) > app-orders:nth-child(2) > app-product-order-details:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(3) > span:nth-child(2)")));

			if (delivered.isEnabled()) {

				System.out.println("Delivered");
			}

			
		} catch (Exception e) {
			System.out.println("Not Delivered");
		}
		
		
		

	}
	
	
	
}
