package week5.day13;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseService {
	public static  ChromeDriver  driver;
	public string filename;
	
	@Parameters({"url","username","password"})
	@BeforeMethod()
	public void beforeMethod(String url,String username,String password) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//input[@id=\"filter\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id=\"user_password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id=\"sysverb_login\"]")).click();
		Thread.sleep(1000);
	
		WebElement n1page = driver.findElement(By.xpath("(//input[contains(@class,'form-control form-control-search')])[3]"));
		n1page.sendKeys("Incident");
		n1page.sendKeys(Keys.ENTER);
		
			
		
	}
	@AfterMethod()
public void afterMethod() {
		driver.close();
	}
	
	@DataProvider(name="filedata")
	public String[][] data() throws IOException{
		Object filename;
		return ReadMe.readExcel(filename);
	}

	}
	
}