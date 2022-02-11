package week5.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateIncident extends BaseService {
@Test
public  void createIncident() throws InterruptedException {

//clicking createnew  under incident:	
driver.findElement(By.xpath("//div[text()=\"Create New\"]")).click();



//now we need to switch to frames 1
driver.switchTo().frame("gsft_main");

//clicking on search button
String oldWindow = driver.getWindowHandle();  //first window name
driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
Set<String> windowHandles = driver.getWindowHandles();  //windowHandle a name for handle 
List<String> openWindow = new ArrayList<String>(windowHandles); 
String newwindow = openWindow.get(1);//second window name
driver.switchTo().window(newwindow);
Thread.sleep(1000);

//selecting first name Abeltutor
driver.findElement(By.xpath("//td/a[@role=\"button\"]")).click();

//now return to parent window
driver.switchTo().window(oldWindow);

//also giving moveback to frame
driver.switchTo().frame("gsft_main");
Thread.sleep(1000);

//giving description
                                                 //String oldWindow1 = driver.getWindowHandle();
driver.findElement(By.xpath("//div//input[3][@id=\"incident.short_description\"]")).sendKeys("JAVA-SELENIUM");

//getAttribute for incident id
WebElement incnumber = driver.findElement(By.id("incident.number"));
String incnumber1 = incnumber.getAttribute("value");
System.out.println(incnumber1);

//giving submit button using ruto xpath
driver.findElement(By.id("sysverb_insert_bottom")).click();
Thread.sleep(1000);


//to select number in the dropbox
WebElement number = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
Select dropdown = new Select(number);
dropdown.selectByVisibleText("Number");

//giving the incident no
WebElement find = driver.findElement(By.xpath("//input[@class='form-control']"));
find.sendKeys("INC0010046");
find.sendKeys(Keys.ENTER);
Thread.sleep(1000);

//click on the searched number
driver.findElement(By.xpath("//a[@class='linked formlink']")).click();



//getting the incident value
WebElement icnumber = driver.findElement(By.xpath("//div[text()='INC0010046']"));
String apple=icnumber.getText();
Thread.sleep(1000);

//checking or verifying
if(apple.equals("INC0010046")){
	System.out.println("The Create incident is created successfully");
}

else {
	System.out.println("The Create incident is not created successfully");
}








//driver.findElement(By.xpath("//div[@class=\"input-group ref-container\"]//input[1]")).sendKeys("Doss");
//driver.findElement(By.xpath("//input[@id=\"incident.short_description\"]")).sendKeys("Servicenow");
	}

}
