package productextras;

import java.io.IOException; 
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class MeasurementSets extends BaseClass{
	
	static String name = "bangle" ;
	static String value = "70000";
	static String msvalue ="50";
	
	@Test(priority=0, description="clicking on the product", groups="Measure")
	public void clickProd() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")));
		driver.findElement(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::ul/descendant::a[contains(text(),'Product Extras')]")));	
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::ul/descendant::a[contains(text(),'Product Extras')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-product-extras/descendant::label[contains(text(),'Measurement Sets')]")));
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-product-extras/descendant::label[contains(text(),'Measurement Sets')]")).click();
	}
	
		
	@Test(priority=1, description="adding measurement sets", groups="Measure")
	public void measure() throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[1]")));
		       System.out.println("Element is clickable");
		     }
		catch(TimeoutException e) {
		       System.out.println("Element isn't clickable");
		    }
				
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
		 List<WebElement> chatbox = driver.findElements(By.xpath("//div[@class='win_close sqico-larrow']")); 
		 
		 if(chatbox.size()>0)
		 {
			 chatbox.get(0).click();
		 }
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='material-icons add-img']")));
		       System.out.println("Image Element is clickable");
		     }
		catch(TimeoutException e) {
		       System.out.println("Image Element isn't clickable");
		    }
		
		driver.findElement(By.xpath("//i[@class='material-icons add-img']")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		Thread.sleep(5000);
		
		Select s = new Select(driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-measurement-events/div/form/div[1]/div[2]/div[3]/div/div[1]/div/select")));
		s.selectByIndex(0);
		
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(value);
		
		Thread.sleep(2000);
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ml-1 col-md-12 mt-3 ng-star-inserted']//button[@type='button']")));
		       System.out.println("Add unit button is clickable");
		     }
		catch(TimeoutException e) {
		       System.out.println("Add unit button isn't clickable");
		    }
		
		driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-measurement-events/div/form/div[1]/div[2]/div[4]/div[1]/div/div/div/div/input")).sendKeys(msvalue);
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-12 form-group mt-2']//button[@type='button']")));
		       System.out.println("Add Measurement button is clickable");
		     }
		catch(TimeoutException e) {
		       System.out.println("Add Measurement button isn't clickable");
		    }
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ladda-label'])[1]")));
		       System.out.println("Add button is clickable");
		     }
		catch(TimeoutException e) {
		       System.out.println("Add button isn't clickable");
		    }
		driver.findElement(By.xpath("(//span[@class='ladda-label'])[1]")).click();
		Thread.sleep(5000);
		
		WebElement error = driver.findElement(By.xpath("//form[@class='ng-dirty ng-touched ng-valid ng-submitted']/descendant::p[contains(text(),'Name already exists')]"));
		
		if(error.isDisplayed()) {
			
			System.out.println(error.getText());
			try {
			       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page_fixedfooter']/descendant::span[contains(text(),'Cancel')]")));
			       System.out.println("Cancel button is clickable");
			     }
			catch(TimeoutException e) {
			       System.out.println("Cancel button isn't clickable");
			    }
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page_fixedfooter']/descendant::span[contains(text(),'Cancel')]")));
			driver.findElement(By.xpath("//div[@class='page_fixedfooter']/descendant::span[contains(text(),'Cancel')]")).click();
		}
		
		try {
			
			 Actions ac= new Actions(driver);
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
				
			 System.out.println("frame found and switched ");
				
			 WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
				
			 ac.moveToElement(close).click().build().perform();
			 System.out.println("closing the frame ");
			 
		}catch(Exception e)
		{
			System.out.println("No chat box opened");
		}
		driver.switchTo().defaultContent();
		
	}
	
	
	@Test(priority=2, description="searching the measurement sets", groups="Measure")
	public void search() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions ac = new Actions(driver);
		
		WebElement search = driver.findElement(By.name("search_bar"));
		ac.click(search).sendKeys(name).build().perform();
		
		driver.findElement(By.xpath("//span[normalize-space()='search']")).click();
	}
	
	
	
	@Test(priority=3, description="clicking on editview", groups="Measure")
	public void editView() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-measurements[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/button[2]")));
		       System.out.println("View button is clickable");
		     }
		catch(TimeoutException e) {
		       System.out.println("View button isn't clickable");
		    }
		driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-measurements[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/button[2]")).click();
		
//		JavascriptExecutor obj = (JavascriptExecutor) driver;
//		obj.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//span[@class='material-icons round-img-icon ab-item-close']")).click();
		
		driver.findElement(By.xpath("//i[@class='material-icons add-img']")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe");
		Thread.sleep(3000);
		
		WebElement mname = driver.findElement(By.xpath("//input[@name='name']"));
		ac.doubleClick(mname).sendKeys(name).build().perform();
		Thread.sleep(5000);
		
//		Select s = new Select(driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-measurement-events/div/form/div[1]/div[2]/div[3]/div/div[1]/div/select")));
//		s.selectByIndex(1);
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		        System.out.println("Update button is clickable");
	     }
	      catch(TimeoutException e) {
	       System.out.println("Update button isn't clickable");
	    }
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		
     }
	 
	
	@Test(priority=4, description="removing the measurement sets", groups="Measure")
	public void remove() throws Exception {
		Actions ac = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]//div[3]//div[1]//button[1]")));
		System.out.println("Remove button is Clickable");
		}catch(Exception e) {
			System.out.println("Remove button isn't Clickable");
		
		}
		driver.findElement(By.xpath("//div[2]//div[3]//div[1]//button[1]")).click();
		Thread.sleep(4000);
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//div[@class='modal-footer']/descendant::span[contains(text(),'Yes')]")));
		        System.out.println("Yes button is clickable");
		        
		        
	     }
	      catch(TimeoutException e) {
	       System.out.println("yes button isn't clickable");
	    }
		
	//	 WebElement yes = driver.findElement(By.cssSelector("//div[@class='modal-footer']/descendant::span[contains(text(),'Yes')]"));
	//	 ac.click(yes).build().perform();
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/descendant::span[contains(text(),'No')]")));
		        System.out.println("No button is clickable");
	     }
	      catch(TimeoutException e) {
	       System.out.println("No button isn't clickable");
	    }
	
		
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
			
		 System.out.println("frame found and switched ");
			
		 WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
			
		 ac.moveToElement(close).click().build().perform();
		 System.out.println("closing the frame ");
		 driver.switchTo().defaultContent();
		 
		driver.findElement(By.xpath("//div[@class='modal-footer']/descendant::span[contains(text(),'No')]")).click();
	}

	

}
