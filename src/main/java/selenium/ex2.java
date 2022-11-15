package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ex2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rakuplus.jp/");
		WebElement rogId = driver.findElement(By.cssSelector("#user_login"));
		rogId.sendKeys("yuma.ono@rakus-partners.co.jp");
		WebElement rogPass = driver.findElement(By.cssSelector("#user_pass"));
		rogPass.sendKeys("yuma.ono@rakus-partners.co.jp");
		WebElement rogin = driver.findElement(By.cssSelector("#wp-submit"));
		rogin.click();

		WebElement qaPage = driver
				.findElement(By.cssSelector("#sgb-css-id-8 > div > a:nth-child(2) > span.c_linkto_text"));
		qaPage.click();

		List<WebElement> divElemList = driver.findElements(By.cssSelector("section.entry-content > div"));
		int count = 0;
		for (WebElement elem : divElemList) {
			if (count > 0) {

				WebElement kanji = elem.findElement(By.cssSelector("span.big"));
				System.out.println(kanji.getText());

				WebElement kana = elem.findElement(By.cssSelector("p.has-text-color"));
				System.out.println(kana.getText());

				WebElement img = elem.findElement(By.cssSelector("img"));
				String url = img.getAttribute("src");
				System.out.println(url);

			}
			count++;

		}
	}
}