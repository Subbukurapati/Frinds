package fitpeo;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment1 {

	public static void main(String[] args) throws Throwable {
	
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		// 1. Navigate to the FitPeo Homepage
		
		driver.get("https://www.fitpeo.com/");
		
		//2. Navigate to the Revenue Calculator Page:
	
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
		Thread.sleep(2000);
		//3. Scroll Down to the Slider section:

		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,500)");
		
		
		//4. Adjust the Slider:
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(25));
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='number' and @id=':r0:']")));
		driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).clear();
		driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).sendKeys("820");
		Thread.sleep(8000);
		//5 and 6 Update the Text Field:
		driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).clear();
		driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).sendKeys("560");
		
		
		//7. Select CPT Codes
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<3;i++) {
			checkbox.get(i).click();
			
		}
		//8 and 9 alidate Total Recurring Reimbursement:
		WebElement element1=driver.findElement(By.xpath("(//p)[1]"));
		System.out.println(element1.getText());
		WebElement element2=driver.findElement(By.xpath("(//p[last()])[4]"));
		System.out.println(element2.getText());
		driver.quit();
	}
	
	

}
