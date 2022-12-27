package loginTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestInClass_JUnit {
	WebDriver driver;
	//runs as JUnit Test and not as Java application
	@BeforeClass
	public static void beforeClass() {// Methods with @BeforeClass and @AfterClass annotations have to be static
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass() {

		System.out.println("After Class");
	}
	@Before//runs before each @Test
	public  void init() {//initial steps for launching browser and going to url
		System.out.println("Init method-->@Before");
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/crmInClass/driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
	
	}
	@Test
	public void loginTest() throws InterruptedException{//positive test case
		System.out.println("Test method-->@Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(4000);
		

	}
	@Test
	public void negloginTest() throws InterruptedException{//negative test case
		System.out.println("NegTest method-->@Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc12323444");
		driver.findElement(By.name("login1")).click();//making the test case fail by providing the wrong element name
		Thread.sleep(4000);
		

	}
	@After//runs after each @Test
	public void tearDown() {//closing driver
		System.out.println("tearDown method-->@After");
		driver.close();
		driver.quit();
	}
	
}
