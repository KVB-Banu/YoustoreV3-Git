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
import org.testng.annotations.Test;

public class Edit extends BaseClass {
	
	static String name = "Sarees";
	static String description = "test 01";
	
	@Test(priority=0, description="clicking on the product", groups="edit")
	public void clickPro() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")));
		driver.findElement(By.xpath(
				"//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]"))
				.click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::div[2]/descendant::a[contains(text(),'Catalogs')]")));
		driver.findElement(By.xpath(
				"//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/descendant::div[2]/descendant::a[contains(text(),'Catalogs')]"))
				.click();
		Thread.sleep(3000);
		
	   }

	@Test(priority=1, description="edit the catalog", groups="edit")
	public void edit() throws Exception
	{
	//	driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();	
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);
		
	    //catalog Name
		List<WebElement> catalogN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]"));
	      
	    //Product count
	    List<WebElement> prodN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[2]"));
		
	    //Edit
	    List<WebElement> edit = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div[2]/child::div[2]/descendant::button[contains(text(),'Edit')]"));
		System.out.println("size of edit:" + edit.size());
		
		
			WebElement edit1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div[2]/child::div[2]/descendant::button[contains(text(),'Edit')]")).get(0);
			edit1.click();
			
			try {
				driver.findElement(By.xpath("//span[@class='material-icons float-right round-img-icon ab-item-close top5']")).click();
			} catch(Exception e)
			{
			    System.out.println("Image is not uploaded");
			}
			
			driver.findElement(By.xpath("//i[@class='material-icons add-img']")).click();
			
			Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image4.exe");
			Thread.sleep(4000);
			
	//		driver.findElement(By.name("name")).clear();
			
			driver.findElement(By.name("name")).sendKeys("");
			
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("window.scrollBy(0,100)");
			Thread.sleep(4000);
			driver.findElements(By.xpath("//div[@class='ql-container ql-snow'][1]/child::div[1]")).get(0).clear();
			driver.findElement(By.xpath("//div[@class='ql-container ql-snow'][1]/child::div[1]")).sendKeys(description);
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-12 form-group mb-3 ng-star-inserted']/descendant::span[text()='Enable Page Content']/following-sibling::span")));
			WebElement enablePageContent = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalog-event/div/form/div[1]/div[3]/div[1]/div[3]/label/span[2]"));
			System.out.println("Enable Page content check box is selected:" + enablePageContent.isSelected());
			
			if(!enablePageContent.isSelected()) {
			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-12 form-group mb-3 ng-star-inserted']/descendant::span[text()='Enable Page Content']")));
				driver.findElement(By.xpath("//div[@class='col-md-12 form-group mb-3 ng-star-inserted']/descendant::span[text()='Enable Page Content']")).click();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				obj.executeScript("window.scrollBy(0,100)");
				Thread.sleep(4000);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.name("title")));
				try {
				driver.findElement(By.name("title")).clear();
				}catch(Exception e) {
				driver.findElement(By.name("title")).sendKeys("hfdshgf");
				}
				try {
				driver.findElements(By.xpath("//div[@class='ql-container ql-snow'][1]/child::div[1]")).get(1).clear();
				}catch(Exception e) {
				
				driver.findElements(By.xpath("//div[@class='ql-container ql-snow'][1]/child::div[1]")).get(1).sendKeys("yourstore description");
				}
			}
			else
			{
				System.out.println("unable to check");
			}
			
			
			
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-12 form-group mb-3 ng-star-inserted']/descendant::span[text()='Enable Social Media Links']/following-sibling::span")));
//			WebElement socialMediaCheckBox = driver.findElement(By.xpath("//div[@class='col-md-12 form-group mb-3 ng-star-inserted']/descendant::span[text()='Enable Social Media Links']/following-sibling::span"));
//			System.out.println("Enable Social Media Link check box is selected:" + socialMediaCheckBox.isSelected());
//			
//			if(socialMediaCheckBox.isSelected()==false)
//			{
//				try {
//				       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='light-button']")));
//				       System.out.println("Element is clickable");
//				     }
//				catch(Exception e) {
//				       System.out.println("Element isn't clickable");
//				    }
//				
//				obj.executeScript("window.scrollBy(0,400)");
//				
//				Select s = new Select(driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalog-event/div/form/div[1]/div[2]/div[1]/div[7]/div/div/div/div/div[1]/select")));
//				s.selectByIndex(0);
//						
//			    List<WebElement> op = s.getOptions();
//				 		
//				for(int i=0; i<op.size();i++)
//				{
//					
//					String options = op.get(i).getText();
//					System.out.println("options are : " + options);
//					
//				}
//				Thread.sleep(1000);
//				try {
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")));
//				String slink = driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")).getText();
//				System.out.println("slink : " + slink);
//				}catch(Exception e) {
//				driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div/app-product-sections/app-catalog-event/div/form/div[1]/div[2]/div[1]/div[7]/div/div/div/div/div[2]/input")).sendKeys("/facebook");
//				}
//				
//				Thread.sleep(3000);
//				
//				String link = driver.findElement(By.xpath("//p[@class='light-font font-10 mb-1 ng-star-inserted']")).getText();
//				System.out.println(link);
//				
//				
//				driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
//				
//			}
			
		
					
			
			
			Thread.sleep(3000);
			

		
			
		
		
	}
}
