package productextras;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ImageTags extends BaseClass {

	static String name = "tops";
	static String rank = "";
	static String searchName = "On Sale";
	static String editName = "tops";
    
	@Test(priority=0, description="clicking on the product", groups="ImageTags")
	public void clickPro() throws IOException, Exception {
		driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Product Extras']")).click();

		driver.findElement(By.xpath("//label[normalize-space()='Image Tags']")).click();
	}

	
	@Test(priority=1, description="Adding the image tag", groups="ImageTags")
	public void AddTags() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add Tag')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Add Tag')]")).click();

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("rank")));
		driver.findElement(By.name("rank")).sendKeys(rank);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
			System.out.println("Add button is clickable");
		} catch (Exception e) {
			System.out.println("Add button is not clickable");
		}
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModal']")));
			System.out.println("Cancel Button is Clickable");
		} catch (Exception e) {
			System.out.println("Cancel Button is not Clickable");
		}

		Thread.sleep(3000);
		try {
			WebElement error = driver.findElement(
					By.xpath("//div[@class='modal-dialog modal-dialog-scrollable']/descendant::form/descendant::p"));

			if (error.isDisplayed()) {

				System.out.println(error.getText());
				try {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Cancel')]")));
					System.out.println("Cancel button is clickable");
				} catch (TimeoutException e) {
					System.out.println("Cancel button isn't clickable");
				}
				driver.findElement(By.xpath("//button[@id='closeModal']")).click();

			}
		} catch (Exception e) {
			System.out.println("No error Found");
		}

	}

	
	@Test(priority=2, description="searching the imagetags", groups="ImageTags")
	public void search() throws InterruptedException {

		driver.findElement(By.name("search_bar")).sendKeys("tops");
		Thread.sleep(3000);

		List<WebElement> imageTags = driver.findElements(By.xpath(
				"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of Image Tags Name : " + imageTags.size());
		Thread.sleep(4000);
	}

	@Test(priority=1, description="edit the image tags", groups="ImageTags")
	public void edit() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement view = driver.findElements(By.xpath(
				"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[3]"))
				.get(0);
		view.click();

		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(editName);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("rank")));
		driver.findElement(By.name("rank")).sendKeys("");

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
			System.out.println("Update button is clickable");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModal']")));
			System.out.println("Cancel button is clickable");
		} catch (Exception e) {
			System.out.println("Update & Cancel buttons are not clickable");
		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		if (name == editName) {
			try {
				WebElement error = driver.findElement(By
						.xpath("//div[@class='modal-dialog modal-dialog-scrollable']/descendant::form/descendant::p"));

				if (error.isDisplayed()) {

					System.out.println("Test case is passed" + error.getText());
					try {
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModal']")));
						System.out.println("Cancel button is clickable");
					} catch (TimeoutException e) {
						System.out.println("Cancel button isn't clickable");
					}
					driver.findElement(By.xpath("//button[@id='closeModal']")).click();

				}
			} catch (Exception e) {
				System.out.println("Existing name = edit name No error Found : Test Case is Failed");

			}
		}
	}

	@Test(priority=3, description="comparing the image tags", groups="ImageTags")
	public void compareImageTags() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions ac = new Actions(driver);

		List<WebElement> imageTagName = driver.findElements(By.xpath(
				"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"));
		System.out.println("size of Image Tags Name : " + imageTagName.size());
		Thread.sleep(4000);

		int count = 0;

		for (int i = 0; i < imageTagName.size(); i++) {

			count++;

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]")));
			WebElement imageTagName1 = driver.findElements(By.xpath(
					"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/child::div/child::div[3]/child::div/child::div/child::div/following-sibling::div/descendant::p[1]"))
					.get(i);
			String text1 = imageTagName1.getText();
			System.out.println("Image Tag name : " + text1);

			// back

			driver.findElement(By.xpath(
					"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/descendant::span[1]"))
					.click();

			// catalog and products
			driver.findElement(By.xpath("//a[normalize-space()='Catalog & Products']")).click();

			// clicking on add product
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]")));
			WebElement addpro = driver.findElement(By.xpath(
					"/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalogs/div/div[1]/div/div[2]/button[3]"));
			ac.click(addpro).build().perform();
			Thread.sleep(5000);
			
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("window.scrollBy(0,1700)");
			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[10]/descendant::label/child::span[contains(text(),'Apply Image Tags')]")));
			driver.findElement(By.xpath(
					"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[10]/descendant::label/child::span[contains(text(),'Apply Image Tags')]"))
					.click();
			Thread.sleep(5000);
			List<WebElement> proImageTag = driver.findElements(By.xpath(
					"//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-product-sections/child::div/following-sibling::app-add-product/child::div/child::form/child::div[2]/following-sibling::div[2]/descendant::div[2]/child::div[2]/descendant::div[2]/following-sibling::div[10]/child::div[2]/descendant::label"));
			System.out.println("size of Image Tags in product page: " + proImageTag.size());
			Thread.sleep(5000);

			for (int j = 0; j < proImageTag.size(); j++) {
				String text = proImageTag.get(j).getText();
			
					if(text1.contains(text)) {
					System.out.println(text1 + " => Present");
					break;
					}
				}
			
			
			System.out.println(count);
			System.out.println("###############################################################");
			clickPro();

		}

	}
	
	@Test(priority=4, description="removing the image tags", groups="ImageTags")
	public void remove()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//clicking on remove button
		driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[2]")).get(4).click();
		
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
	
	@Test(priority=5, description="make the imagetag to enable or disable", groups="ImageTags")
	public void disableOrEnable() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//clicking on disable/enable button
		
		WebElement disOrEnable = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[1]")).get(4);
				
		String disOrEnableText = disOrEnable.getText();
		System.out.println("The button text is :" + disOrEnableText);
		Thread.sleep(3000);
		
		driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/child::app-image-tags/descendant::div[2]/following-sibling::div[2]/descendant::div[3]/following-sibling::div/child::div[2]/descendant::button[1]")).get(4).click();
		
		String disable = driver.findElement(By.xpath("//div[@role ='document']/descendant::p")).getText();
		
		System.out.println("Text in popup :" + disable);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeModal']")));
			System.out.println("Cancel button is clickable");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/child::button[2]")));
			System.out.println("Yes button is clickable");
		}catch(Exception e)
		{
			System.out.println("Cancel & Yes button is not clickable");	
		}
		
		driver.findElement(By.xpath("//div[@class='modal-footer']/child::button[2]")).click();
		

		
	}
	
}
