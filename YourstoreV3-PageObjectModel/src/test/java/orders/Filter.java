package orders;

import java.io.IOException; 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Filter extends BaseClass{
	@Test(priority=0, description="liveorders", groups="filter" )
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

    }
	
	@Test(priority=1, description="filter", groups="filter" )
	public void filter() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Actions ac = new Actions(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Filter')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
		
		List<WebElement> filterOptions = driver.findElements(By.xpath("//div[@class='radio_buttons col-12 ng-tns-c87-0']"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		
		for(int i=0; i<filterOptions.size(); i++)
		{
			try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Filter')]")));
			driver.findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		filterOptions.get(i).click();
			
		driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
		
		String allOrders = driver.findElement(By.xpath("//p[@class='ng-tns-c87-0']/child::span")).getText();
		System.out.println("All Orders Count: " + allOrders);
		
		List<WebElement> ordersCount = driver.findElements(By.xpath("//div[@class='col-md-8 col-6 first_col px-0 cursor ng-tns-c87-0'][1]"));
		List<WebElement> pageCount = driver.findElements(By.xpath("//a[@class='ng-star-inserted']"));
		System.out.println("Page Count:" + pageCount.size());
		int orderSize = ordersCount.size();
		int sum = 0;
		for(int j = 0; j<3; j++) {
		sum = sum + orderSize;
		System.out.println("Order Count:"  + sum);
		Thread.sleep(3000);
		obj.executeScript("window.scrollBy,(0,700)");
		Thread.sleep(6000);
		WebElement arrow = driver.findElement(By.xpath("//li[@class='pagination-next ng-star-inserted']/child::a"));
		ac.moveToElement(arrow).click(arrow).build().perform();
		Thread.sleep(3000);	
		}
		WebElement arrow = driver.findElement(By.xpath("//li[@class='pagination-next ng-star-inserted']/child::a"));
		ac.moveToElement(arrow).click(arrow).build().perform();
		sum = sum+orderSize;
		System.out.println("Orders Count:"  + sum);
		
		}
		
	}
}
