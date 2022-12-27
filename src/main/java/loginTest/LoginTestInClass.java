package loginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestInClass {
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/crmInClass/driver/chromedriver");//can also give relative path 
		//can also use user dir but this is obsolete method and no longer used
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//clearing the cache
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");//finding element and sending some value to it
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();//clicking the button
		//driver.findElement(By.className("btn")).click();
		Thread.sleep(2000);
		//for closing the window
		driver.close();
		driver.quit();
		
		
		
		
}
	
}

