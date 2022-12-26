package addproduct;
 
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


public class AddProduct extends BaseClass {
	
	
	static String name = "Xyz";
	static String unit = "Pcs";
	static String vendor = "Yourstore";
	static String selling_Price = "35000";
	static String stock = "10";
		
	static String tagtitleName = "test";
	static String tagoptionname="Tops";
	static String imageLabel="Bangle1";
	static String altImageLabel="Bangle1";
	
	
	
	@Test(priority=0, description = "Adding the product",  groups="addproduct")
	public void add() throws Exception  {
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")));
		driver.findElement(By.xpath("//div[@class='accordion menu-scroll']/child::div[2]/descendant::span[contains(text(),'Products')]")).click();
		Actions ac= new Actions(driver);
		Thread.sleep(1000);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")));
			driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")).click();
			Thread.sleep(3000);
			}catch(Exception e)
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")));
				driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-products/child::div/child::div[2]/child::div/descendant::button[contains(text(),'Add Product')]")).click();
				Thread.sleep(3000);
			}
		
		for(int i=1; i<4; i++)
		{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/descendant::i[1]")));	
		driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/descendant::i")).get(0).click();
	
		if(i%2==0)
		{
			Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image7.exe");
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::span[3]")));
			driver.findElement(By.xpath("//div[@role='document']/descendant::span[3]")).click();//click on Crop
			
		}
		
		Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe");
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='document']/descendant::button[contains(text(),'Save')]")));
		driver.findElement(By.xpath("//div[@role='document']/descendant::button[contains(text(),'Save')]")).click();// click on save
		
		Thread.sleep(3000);
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::div[2]/descendant::button")));
		WebElement edit_Img = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::div[2]/descendant::button"));
		ac.click(edit_Img).build().perform();
		Thread.sleep(3000);
		
		for(int i =0; i<6;i++)
		{
		
		
		driver.findElements(By.xpath("//div[@role='document']/descendant::input")).get(i).sendKeys(imageLabel);
		Thread.sleep(2000);
//		driver.findElements(By.xpath("//div[@role='document']/descendant::input")).get(i).sendKeys(altImageLabel);
		
		
			
		}
		
		//clicking on save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='document']/descendant::button[2]")));
		driver.findElement(By.xpath("//div[@role='document']/descendant::button[2]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='name']")));
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='sku']")).sendKeys("");
		Thread.sleep(3000);
		Select s= new Select(driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='sku']/ancestor::div[1]/following-sibling::div/child::select")));
		s.selectByIndex(0);
		try {
		Select s1 = new Select(driver.findElement(By.xpath("//select[@name='vendor_id']")));
		s1.selectByVisibleText(vendor);
		}catch(Exception e)
		{
			System.out.println("This is not a multivendor store");
		}
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='selling_price']")).sendKeys(selling_Price);
		driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='stock']")).sendKeys(stock);
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("A Pure gold bangle 24 kt");
		Thread.sleep(1000);
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);

		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='cat_search']")));
		 driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='cat_search']")).sendKeys(name);
		 
		  List<WebElement> catlist = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[7]/ancestor::div[3]/descendant::div"));
		  if(catlist.size()>0) {  
		   
		  
			  
			 for(int i=0; i<catlist.size(); i++)
			 {
			 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[7]/ancestor::div[3]/descendant::div")));
			 driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[7]/ancestor::div[3]/descendant::div")).get(i+1);
			 String catlistText = catlist.get(i+1).getText();
			 if(catlistText.equals(name)) {
				 driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='cat_search']/ancestor::div[4]/following-sibling::div/descendant::label")).click(); 
				 break;
			 }
			 }
			}
		  else
		{
				driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[6]/ancestor::div[2]/following-sibling::div/descendant::button")).click();
				 
				driver.findElement(By.xpath("//div[@role='document']/descendant::form/descendant::input")).sendKeys(name);
				driver.findElement(By.xpath("//div[@role='document']/descendant::form/child::div[2]/child::button[contains(text(),'Add')]")).click();
				Thread.sleep(3000);
//				driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='cat_search']")).sendKeys(name);
				List<WebElement> catlist1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[7]/ancestor::div[3]/descendant::div"));
				 for(int i=0; i<catlist1.size(); i++)
				 {
				 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[7]/ancestor::div[3]/descendant::div")));
				 driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[7]/ancestor::div[3]/descendant::div")).get(i+1);
				 String catlistText = catlist1.get(i+1).getText();
				 if(catlistText.equals(name)) {
					 driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/descendant::input[@name='cat_search']/ancestor::div[4]/following-sibling::div/descendant::label")).click(); 
					 break;
				 }
				
				 } 
		}
		 
		 Thread.sleep(3000);
		 obj.executeScript("window.scrollBy(0,1000)");
	}
	
	@Test(priority=1,groups="addproduct", enabled=false)
	public void variant() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		Actions ac= new Actions(driver);
			
		 //clicking on apply variant
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//b[normalize-space()='Apply Variants']")));
		 WebElement variant = driver.findElement(By.xpath("//b[normalize-space()='Apply Variants']"));
		 ac.click(variant).build().perform();
		 Thread.sleep(1000);
   	    
		 Select s2 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-add-product/div/form/div[3]/div[2]/div/div/div/div[1]/select")));
		 s2.selectByIndex(0);
		 Thread.sleep(1000);
		 
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"options\"]/div/div/tag-input-form/form/input")));
		 driver.findElement(By.xpath("//*[@id=\"options\"]/div/div/tag-input-form/form/input")).sendKeys("s",",","M",",");
		 Thread.sleep(1000);
		 for(int j=0; j<3;j++)
		 {
		 try {
		 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[2]")).click();
		 Thread.sleep(3000);
		 }catch(Exception e)
		 {
			 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[2]")).click(); 
			 Thread.sleep(2000);
		 }
		 
		 Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe");
		 Thread.sleep(2000);
		 
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")));
		 driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();
		 }
		 
		 driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-add-product/div/form/div[3]/div[4]/div[1]/div/div/div[2]/div[2]/div/div[2]/input")).sendKeys("10");
		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[2]")).sendKeys("0.2");
		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[3]")).sendKeys("40000");
		 
		 for(int j=0; j<3;j++)
		 {
		 try {
		 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[3]")).click();
		 Thread.sleep(3000);
		 }catch(Exception e)
		 {
			 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[3]")).click();
			 Thread.sleep(2000);
		 }
		 
		 Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image7.exe");
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();
		 }
		 
		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[4]")).sendKeys("10");
		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[5]")).sendKeys("1");
		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[6]")).sendKeys("50000"); 
		 }
	
	@Test(priority=2,groups="addproduct")
	public void advancedOptions() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		Actions ac= new Actions(driver);
		 
		 driver.findElement(By.name("brand")).sendKeys("GRT"); // Brand name
		 driver.findElement(By.xpath("//input[@placeholder='Enter options']")).sendKeys("Thick bangle", ",","two bangle",",");
		 
        
		 // click on featured product
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div[1]/label/span[1]")));
		 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div[1]/label/span[1]")).click();
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space()='Apply Discount']")));
		 driver.findElement(By.xpath("//span[normalize-space()='Apply Discount']")).click();
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='disc_percentage']")));
		 driver.findElement(By.xpath("//input[@name='disc_percentage']")).sendKeys("10");
		 Thread.sleep(3000);
		 
	}
	
	@Test(priority=3,groups="addproduct", enabled=false)
	public void productExtras() throws InterruptedException {
		 
		 // Click on Addon
		 
		 
		 driver.findElement(By.xpath("//span[normalize-space()='Apply Add-Ons']")).click();
		
		 try {
		 driver.findElement(By.name("addon_must")).click();// add on must click on
		 }catch(Exception e) {
			 driver.findElement(By.xpath("#collapseOne > div > div:nth-child(3) > div.row.ng-tns-c105-2.ng-star-inserted > div > div > div.mb-3.d-flex.justify-content-end.ng-tns-c105-2 > label > span.checkmark.ng-tns-c105-2")).click();
		 }
		 
        List<WebElement> chatbox = driver.findElements(By.xpath("//div[@class='win_close sqico-larrow']")); 
		 
		 if(chatbox.size()>0)
		 {
			 chatbox.get(0).click();
		 }
		 
			 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[3]/div[2]/div/div/div[2]/div[1]/label/span/span")).click();
			 
//		 }catch(Exception e)
//		 {
//			 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[3]/div[2]/div/div/div[1]/label/span[2]")).click();
//		 }
		 
		 Thread.sleep(3000);
		 try {
		 driver.findElement(By.cssSelector("#collapseOne > div > div:nth-child(3) > div.row.ng-tns-c105-2.ng-star-inserted > div > div > div.row.mb-2.px-2.ng-tns-c105-2 > div:nth-child(1) > label > span > span")).click();
		 Thread.sleep(3000);
		 }catch(Exception e)
		 {
			 driver.findElement(By.xpath("//span[contains(text(),'123')]")).click();
		 }
	}
	
	@Test(priority=4,groups="addproduct")
	public void sizechart() throws InterruptedException {
		 // click on size chart
		WebDriverWait wait = new WebDriverWait(driver,50);
		Actions ac= new Actions(driver);
		
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space()='Apply Size Chart']")));
		 driver.findElement(By.xpath("//span[normalize-space()='Apply Size Chart']")).click();
		 Thread.sleep(3000);
		 
		 //Clicking on apply tags
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//span[normalize-space()='Apply Tags'])[1]")));
		  driver.findElement(By.xpath("(//span[normalize-space()='Apply Tags'])[1]")).click();
		 //ac.click(tags).build().perform();
		 Thread.sleep(1000);
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[4]/descendant::div[2]/following-sibling::div/child::div/descendant::b")));
		 List<WebElement> tagsTitle = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[4]/descendant::div[2]/following-sibling::div/child::div/descendant::b"));
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[4]/descendant::div[2]/following-sibling::div/child::div/descendant::div[2]/following-sibling::div/child::div")));
		 List<WebElement> tagsOption = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[4]/descendant::div[2]/following-sibling::div/child::div/descendant::div[2]/following-sibling::div/child::div"));
        
		 for(int i=0; i<tagsTitle.size();i++) {
			 String tgt = tagsTitle.get(i).getText();
			 if(tagsTitle.equals(tagtitleName))
			 {
				 //search
				 driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[4]/descendant::div[2]/following-sibling::div/child::div/descendant::div[3]/following-sibling::div/descendant::div[2]/following-sibling::div/descendant::input")).sendKeys(tagoptionname);
			     System.out.println("size of tag options: " + tagsOption.size() ); 
			 }
//				 for(int j=0; j<tagsOption.size();j++)
//			 {
//				 String tgo = tagsTitle.get(j).getText(); 
//				if(tgt.equals(tagtitleName)) {
//					if(tgo.equals(tagoptionname))
//					{
//						tagsOption.get(j).click();
//						System.out.println("tag option" + tagsOption.get(j));
//					}
//					
//				}
//					
//			 }
		 }
	}
		 @Test(priority=5,groups="addproduct", enabled=false)
			public void footnote() throws InterruptedException {
			 WebDriverWait wait = new WebDriverWait(driver,50);
				Actions ac= new Actions(driver);
		 
		 // apply foot notes
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//span[normalize-space()='Apply Foot Note'])[1]")));
		 driver.findElement(By.xpath("(//span[normalize-space()='Apply Foot Note'])[1]")).click();
		 driver.findElement(By.xpath("//span[contains(text(),'12 inch')]")).click();
		 
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
			
		 System.out.println("frame found and switched ");
			
		 WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
			
		 ac.moveToElement(close).click().build().perform();
        
		 //Apply FAQ
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space()='Apply FAQ']")));
		 driver.findElement(By.xpath("//span[normalize-space()='Apply FAQ']")).click();
		 // apply image tag
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"collapseOne\"]/div/div[11]/div[1]/div/label")));
		 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[11]/div[1]/div/label")).click(); 
		 }
		 
		 
		 @Test(priority=6,groups="addproduct")
			public void submit() throws InterruptedException {
			 
			 WebDriverWait wait = new WebDriverWait(driver,50);
			 Actions ac= new Actions(driver);
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
				
			 System.out.println("frame found and switched ");
				
			 WebElement close = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
				
			 ac.moveToElement(close).click().build().perform();
			 System.out.println("closing the frame ");
			 driver.switchTo().defaultContent();
			 
			 JavascriptExecutor obj = (JavascriptExecutor) driver;
			 obj.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			 
			
		     driver.findElement(By.xpath("//span[@class='ladda-label']")).click();  
		 
	}
		 
		 @Test(priority=7, groups="addproduct", enabled=false)
		 public void search() throws InterruptedException
		 {
			 WebDriverWait wait = new WebDriverWait(driver, 50);
			 Actions ac = new Actions(driver);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/descendant::form/descendant::input")));
			 WebElement search = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/descendant::form/descendant::input"));
			
			 ac.click(search).sendKeys(name).sendKeys(Keys.ENTER).build().perform();
			 
				System.out.println("Search name: " + name);
				
				Thread.sleep(4000);
				
				
		    //  List<WebElement> product = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::app-products/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/descendant::p[1]"));
				String product = driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::app-products/descendant::p[1]")).getText();
				System.out.println(name + " : Total products =" + product);
				
			//	System.out.println("number of Products: " + product.size());
			//	List<WebElement> prodN = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[2]"));
		 }
		 
		 
	}
	


