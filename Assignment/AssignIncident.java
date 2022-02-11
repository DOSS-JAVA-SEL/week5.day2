package week5.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AssignIncident extends BaseService {
	@Test
	public void assignIncident() throws InterruptedException {
		//click on open
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		
		//now we need to switch to frames 
		driver.switchTo().frame("gsft_main");
		
		Thread.sleep(1000);

		//sendKeys the incident no
		WebElement sendincno = driver.findElement(By.xpath("//input[@class='form-control']"));
		sendincno.sendKeys("INC0010046");
		sendincno.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		//click on the incident no in the list
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
				
		//clik on search button of assign group
		driver.findElement(By.xpath("//button[@name='lookup.incident.assignment_group']//span[1]")).click();
		
		//new windows is opened for that 
		String oldwindows = driver.getWindowHandle();
		Set<String> aa = driver.getWindowHandles();
		List<String> bb= new ArrayList<String>(aa);
		String newwindowcc = bb.get(1);
		driver.switchTo().window(newwindowcc);
		Thread.sleep(1000);
		
		//selecting the name in the drop box
	//	WebElement namebox = driver.findElement(By.xpath("//div[@class='breadcrumb_container']"));
	//	Select soft = new Select(namebox);
	//	soft.selectByVisibleText("Name");
		
		//giving software in the textfield
		WebElement sware = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		sware.sendKeys("software");
		sware.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		//Selecting the  software
				driver.findElement(By.linkText("Software")).click();
				Thread.sleep(1000);
				
       //Return the frame to parent/old window  aswell as the frame name used
				driver.switchTo().window(oldwindows);
				driver.switchTo().frame("gsft_main");
		

			
				
		//click on the update button
		driver.findElement(By.xpath("//button[contains(@class,'form_action_button header')]")).click();
		Thread.sleep(1000);
		
		
		//now getText the group assigned is software
		WebElement ware = driver.findElement(By.xpath("(//a[@class='linked'])[2]"));
		String confirmsw = ware.getText();
		System.out.println(confirmsw);
		
		//Checking it
		if(confirmsw.equals("Software")) {
			System.out.println("The group assigned is software");
					}
		else {
			System.out.println("The group assigned is not software");
		}
		
		
		
		
		
		
	}
	

}
