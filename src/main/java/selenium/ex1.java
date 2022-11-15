package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ex1 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.cssSelector("div.a4bIc > input"));
		element.sendKeys("selenium");
		element.sendKeys(Keys.ENTER);
		WebElement element2 = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.Z26q7c.UK95Uc.jGGQ5e > div > a > h3"));
		System.out.println(element2.getText());
	}
	
}
