package Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Subbu");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ksubbu3321@gmail.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("9874651211");
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//input[@id='male']")).click();
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input' ]"));
		for (int i=0; i<3;i++) {
			checkbox.get(i).click();
		}
		
		WebElement drpcountryEle= driver.findElement(By.xpath("//select[@id='country']"));
		Select dropcuntry=new Select(drpcountryEle);
		dropcuntry.selectByVisibleText("India");
		driver.findElement(By.xpath("//option[@value='blue']")).click();
		/*
		//Date
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(15));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		String aMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String ayear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!aMonth.equals("November") && ayear.equals("2015")) {
			driver.findElement(By.xpath("//a[@title='Prev' and @class='ui-datepicker-prev ui-corner-all']")).click();
			aMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			ayear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			driver.findElement(By.xpath("//a[normalize-space()='25']")).click();
		}
		*/
		driver.findElement(By.xpath("(//a[.='2'])[1]")).click();
		List<WebElement> cbox=driver.findElements(By.xpath(""));
		//driver.quit();
		

	}

}
