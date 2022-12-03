package productextras;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*
 * Negative Test Cases:
 * in Add size Chart
 * 1. Making empty both name and desc and submit.
 * 2. Enter the Space in the name and desc and submit
 * 3. enter the existing name in name field and Submit.
 * 4. case sensitive letter with existing name and submit
 * 5. clicking on option and do not enter any value and submit it
 * 6. in option clicking on space button and submit it. 
 */

public class SizeChart extends BaseClass {

	static String name = "  ";
	static String unit = "cm";
	static String description= "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
	public static String[] thcols = {"S" , "M" , "L" , "XL","23" , "30" , "40", "45","25" , "32" , "41", "46","27" , "34" , "42", "47","29" , "36" , "44", "48"};
	static String[] firstTrcols = {"23" , "30" , "40", "45","25" , "32" , "41", "46","27" , "34" , "42", "47","29" , "36" , "44", "48"};

	@Test(priority=0, description="clicking on the product", groups="SizeChart")
	public void clickPro() throws IOException, Exception {
		driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Product Extras']")).click();

		driver.findElement(By.xpath("//label[normalize-space()='Size Chart']")).click();
	}

	@Test(priority=1, description="adding the size chart", groups="SizeChart")
	public void addSizeChart() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);
		try {

			WebElement add = driver.findElement(By.xpath(
					"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-size-chart/child::div/child::div[2]/descendant::div[2]/following-sibling::div/child::button[2]"));
			ac.click(add).build().perform();
		} catch (Exception e) {
			System.out.println("not accessable");
		}
       
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("unit")).sendKeys(unit);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='description']")));
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row justify-content-end m-0']/child::button")));
			System.out.println("Add column button is clickable ");
		}catch(Exception e) {
			System.out.println("Add column button is not clickable ");
			
		}
		

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-12 d-flex']/child::button")));
			System.out.println("Add row button is clickable ");
		}catch(Exception e) {
			System.out.println("Add row button is not clickable ");
			
		}
		
		
		List<String> thcollist = Arrays.asList(thcols);
		List<String> firstTrcolslist = Arrays.asList(firstTrcols);

		
		for(int i=0; i<3; i++) {
			
	    driver.findElement(By.xpath("//div[@class='row justify-content-end m-0']/child::button[contains(text(),'Add Column')]")).click();
		driver.findElement(By.xpath("//div[@class='col-md-12 d-flex']/child::button")).click();
		}
		
		for(int i=0; i<thcollist.size(); i++) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input")));
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input"));
		if(i==0| i==1 | i==2 | i==3)
		{
		table.get(i).clear();
		//table.get(i).sendKeys(thcollist.get(i));
		}else if(i>3){
		
		table.get(i).sendKeys(thcollist.get(i));
		
		}
		
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input")));
		List<WebElement> table1 = driver.findElements(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input"));
		table1.get(0).sendKeys(thcollist.get(0));
		table1.get(1).sendKeys(thcollist.get(1));
		table1.get(2).sendKeys(thcollist.get(2));
		table1.get(3).sendKeys(thcollist.get(3));
		
       
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		
		
	}
	
	@Test(priority=2, description="searching the sizechart", groups="SizeChart")
	public void search() throws InterruptedException
	{
		
	 driver.findElement(By.name("search_bar")).sendKeys(name);
	 Thread.sleep(3000);
	 
	  List<WebElement> sizeChart = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-size-chart/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
	  System.out.println("size of Size Chart Name : " + sizeChart.size());
  	  Thread.sleep(4000);
	}
	
	
	@Test(priority=3, description="Editing the sizechart", groups="SizeChart")
	 public void edit()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	    	WebElement view = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-size-chart/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[2]")).get(0);
	    	view.click();
	    	
	    	    	
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys("");
			driver.findElement(By.name("unit")).clear();
			driver.findElement(By.name("unit")).sendKeys("");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='description']")));
			
			driver.findElement(By.xpath("//textarea[@name='description']")).clear();
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("");
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row justify-content-end m-0']/child::button[2]")));
				System.out.println("Add column button is clickable ");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row justify-content-end m-0']/child::button[1]")));
				System.out.println("Remove column button is clickable ");
			}catch(Exception e) {
				System.out.println("Add column button is not clickable ");
				
			}
			

			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-12 d-flex']/child::button[1]")));
				System.out.println("Add row button is clickable ");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-12 d-flex']/child::button[2]")));
				System.out.println("Remove row button is clickable ");
				
			}catch(Exception e) {
				System.out.println("Add row  and Remove Row buttons are not clickable ");
				
			}
			
			
			List<String> thcollist = Arrays.asList(thcols);
			List<String> firstTrcolslist = Arrays.asList(firstTrcols);

			
//			for(int i=0; i<3; i++) {
//				
//		    driver.findElement(By.xpath("//div[@class='row justify-content-end m-0']/child::button[contains(text(),'Add Column')]")).click();
//			driver.findElement(By.xpath("//div[@class='col-md-12 d-flex']/child::button")).click();
//			}
			
			for(int i=0; i<thcollist.size(); i++) {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input")));
			List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input"));
			if(i==0| i==1 | i==2 | i==3)
			{
			table.get(i).clear();
			//table.get(i).sendKeys(thcollist.get(i));
			}else if(i>3){
			
				table.get(i).clear();
			table.get(i).sendKeys(thcollist.get(i));
			
			}
			
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input")));
			List<WebElement> table1 = driver.findElements(By.xpath("//table[@class='table table-bordered size-chart']/descendant::input"));
			table1.get(0).sendKeys(thcollist.get(0));
			table1.get(1).sendKeys(thcollist.get(1));
			table1.get(2).sendKeys(thcollist.get(2));
			table1.get(3).sendKeys(thcollist.get(3));
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-wide btn-primary ladda-button m-1']/child::span[contains(text(),'Update')]")));
				System.out.println("Update button is clickable");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-wide black-outline-btn']/child::span[contains(text(),'Cancel')]")));
				System.out.println("Cancel button is clickable");
			}catch(Exception e)
			{
				System.out.println("Update & Cancel buttons are not clickable");
			}
			
			driver.findElement(By.xpath("//button[@class='btn btn-wide btn-primary ladda-button m-1']/child::span[contains(text(),'Update')]")).click();
	    	
	    }
	
	
	@Test(priority=4, description="comparing the Sizechart", groups="SizeChart")
	public void compareSizeChart() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);	
		
	   	List<WebElement> sizeChartName = driver.findElements(By.xpath("//div[@class=\"main-content-wrap d-flex flex-column sidenav-open top_space\"]/child::app-size-chart/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of Size Chart Name : " + sizeChartName.size());
    	Thread.sleep(4000);
    	
    	 int count = 0;
 		
 		for(int i = 0; i<sizeChartName.size(); i++)
 		{
 			
 			count++;
 			
 			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-size-chart/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")));
			WebElement sizeChartName1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-size-chart/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")).get(i);
			String text1 = sizeChartName1.getText();
			System.out.println("size chart name : " + text1);
			
			// back
			
			driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-size-chart/descendant::span[1]")).click();
						
			// catalog and products
			driver.findElement(By.xpath("//a[normalize-space()='Catalog & Products']")).click();
			
			//clicking on add product
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]")));
			WebElement addpro = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]"));
			ac.click(addpro).build().perform();   	
			
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("window.scrollBy(0,800)");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div/child::div[4]/descendant::span[1]")));
			driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div/child::div[4]/descendant::span[1]")).click();
			
			List<WebElement> proSizeChart = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[3]//descendant::div[1]/following-sibling::div/descendant::label"));
			System.out.println("size of size chart in product page: " + proSizeChart.size());
			
			for(int j =0; j< proSizeChart.size(); j++)
			{
				String text = proSizeChart.get(j).getText();
				if(text1.contains(text))
				{
					System.out.println(text1 + " => Present");
					break;
				
				}
				
				
			}
			System.out.println(count);
			clickPro();
			
			
 		}
    	
 		    	
	}
	
	@Test(priority=5, description="removing the sizechart", groups="SizeChart")
	public void remove()
		{
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			//clicking on remove button
			driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-size-chart/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[1]")).get(4).click();
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[2]")));
				System.out.println("Remove Yes button is clickable");
			}catch(Exception e)
			{
				System.out.println("Remove Yes button is not clickable");
			}
			
		//	driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[1]")));
				System.out.println("Remove No button is clickable");
			}catch(Exception e)
			{
				System.out.println("Remove No button is not clickable");
			}
			
			//driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[1]")).click();
		}

}
