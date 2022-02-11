package week5.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseService {
	@Test
	public void updateIncident() throws InterruptedException {
		//clicking createnew  under incident:	
		//driver.findElement(By.xpath("//div[text()=\"Create New\"]")).click();
		
		//click on open
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		
		//now we need to switch to frames 
				driver.switchTo().frame("gsft_main");
		
		//sendKeys the incident no
		WebElement sendincno = driver.findElement(By.xpath("//input[@class='form-control']"));
		sendincno.sendKeys("INC0010046");
		sendincno.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		//click on the incident no in the list
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//alter the state as progress in dropdown
		WebElement statedrop = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
		Select dropit = new Select(statedrop);
		dropit.selectByVisibleText("In Progress");
		Thread.sleep(1000);
		
		//alter the urgency as high
		WebElement urgencydrop = driver.findElement(By.xpath("(//select[@choice='3'])[3]"));
		Select high = new Select( urgencydrop);
		high.selectByVisibleText("1 - High");
		
		//giving work note priority
		//driver.findElement(By.xpath("//textarea[contains(@class,'sn-string-textarea form-control')]")).sendKeys("Due to covid");
		
		//click on the update button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		
		//click on the number
		driver.findElement(By.xpath("//td[@class='vt']//a")).click();
		
		//gettext  of state priority
		WebElement findElement = driver.findElement(By.xpath("//span[text()='In Progress']"));
		String display1= findElement.getText();
		System.out.println(display1);
		Thread.sleep(1000);
		
		//get text of urgent priority
		WebElement findElement2 = driver.findElement(By.xpath("//option[text()=\"1 - High\"]"));
		String display2= findElement2.getText();
		System.out.println(display2);
		Thread.sleep(1000);



		
	}

}
