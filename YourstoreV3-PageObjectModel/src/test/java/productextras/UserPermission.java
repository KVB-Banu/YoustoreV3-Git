package productextras;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class UserPermission extends BaseClass{
	
	public void user() throws InterruptedException
	{
		
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	 driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	 
	 driver.findElement(By.xpath("//a[normalize-space()='Users']")).click();
	 
	 try {
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 }catch(Exception e)
	 {
		 driver.findElement(By.xpath("//button[@type='button']")).click();
	 }
	 driver.findElement(By.name("name")).sendKeys("Banu");
	 
	 driver.findElement(By.name("designation")).sendKeys("Manager");
	 driver.findElement(By.name("email")).sendKeys("kvbmbanu3@gmail.com");
	 driver.findElement(By.name("password")).sendKeys("Banu@123");
	 
	
	 try {
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 String error = driver.findElement(By.xpath("<p _ngcontent-iuo-c89=\"\" class=\"text-danger ng-tns-c89-1\">Email already exists</p>")).getText();
	 if(error.contains("Email Already exists"))
		{
		    
			driver.findElement(By.xpath("//*[@id=\"closeModal\"]/span")).click();	
			System.out.println("clicked on Cancel");
		}
			}catch(Exception e)
		{
				driver.findElement(By.xpath("//*[@id=\"closeModal\"]/span")).click();
		}
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-sub-users[1]/div[1]/div[3]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/button[1]")).click();
	 
	 
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-sub-users/div/div[3]/div[1]/div/div[4]/div[2]/div/div/div/button[1]")).click();
	}

}
