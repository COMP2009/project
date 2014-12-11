package eveningClasses.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModifyTimetableTest {
	WebDriver driver;

	@BeforeClass
	public static void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		// login
		driver.get("http://localhost:8080/eveningClasses/home");
		driver.findElement(By.id("login_username")).sendKeys("Jeff");
		driver.findElement(By.id("login_password")).sendKeys("12345");
		driver.findElement(By.id("login_submit")).click();
	}

	@Test
	public void dropClass() throws InterruptedException {
		// drop a class and confirm that it's dropped
		driver.quit();
	}

	@Test
	public void addClass() throws InterruptedException {
		// add a class and confirm that it's added
		driver.quit();
	}
	
}
