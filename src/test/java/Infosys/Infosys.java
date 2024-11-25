package Infosys;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Infosys {


	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.infosys.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		driver.manage().window().maximize();	 

		//		 1.click on careers



		driver.findElement(By.xpath("//a[.=\"Careers\" and @title=\"Explore Careers Opportunities\"]")).click();

		//		 driver.findElement(By.xpath(""));
		//		 driver.findElement(By.cssSelector(""));

		WebElement ele=driver.findElement(By.xpath("//input[@id=\"keywordSearch\"]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'})" , ele);
		driver.findElement(By.xpath("//input[@id=\"keywordSearch\"]")).sendKeys("QA automation tester");



		driver.findElement(By.xpath("//span[.=\"Location\"]/parent::button[@type=\"button\"]")).click();

		List<WebElement>  options=  driver.findElements(By.xpath("///span[normalize-space()='Location']"));
		System.out.println("size of the countries names: " +options.size());
		
		
		for(WebElement option:options ) {
			System.out.println(option.getText());
			if (option.getText().equals("India")) {
				option.click();
			}
		}
	 System.out.println("pass");

		/*WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(20));
		mywait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//select[@id='multiselect']"))));
		driver.findElement(By.xpath("//option[@value='India' and @class='optionindia']")).click();
			//	driver.findElement(By.xpath("//select[@id='multiselect']")));
	    Actions ac= new Actions(driver);
	     ac.moveToElement(driver.findElement(By.xpath("//option[@value='India' and @class='optionindia']")));
	     ac.click().perform();*/
	     
		
		
		/*Select dropcuntry=new Select(drpcountryEle);
		dropcuntry.selectByVisibleText("India");
		driver.findElement(By.xpath("//option[@value='India' and @class='optionindia']")).click();
		
		System.out.println("size of the countries names: " +options.size());


		for(WebElement option:options ) {
			System.out.println(option.getText());
			if (option.getText().equals("India")) {
				option.click();
			}
		}
		System.out.println("pass");
         */
		


	}
}