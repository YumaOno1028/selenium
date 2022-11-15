package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ex3 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.e-procurement.metro.tokyo.lg.jp/index.jsp");

		WebElement elem1 = driver.findElement(By.cssSelector("body > div.noticeofurlchange > div > button"));
		elem1.click();

		WebElement elem2 = driver
				.findElement(By.cssSelector("#category_menu > ul > li.cat_menu_1 > a:nth-child(1) > img"));
		elem2.click();

		String Handle = driver.getWindowHandle();
		String newHandle = null;
		for (String id : driver.getWindowHandles()) {
			if (!id.equals(Handle)) {
				newHandle = id;
			}
		}

		driver.switchTo().window(newHandle);

		WebElement elem3 = driver.findElement(By.cssSelector("#topMenuBtn03 > a"));
		elem3.click();

		WebElement elem4 = driver
				.findElement(By.cssSelector("tbody > tr:nth-child(17) > td > input[type=text]:nth-child(2)"));
		elem4.sendKeys("4");
		WebElement elem5 = driver
				.findElement(By.cssSelector("tbody > tr:nth-child(17) > td > input[type=text]:nth-child(3)"));
		elem5.sendKeys("11");
		WebElement elem6 = driver
				.findElement(By.cssSelector("tbody > tr:nth-child(17) > td > input[type=text]:nth-child(4)"));
		elem6.sendKeys("15");
		WebElement elem7 = driver
				.findElement(By.cssSelector("tbody > tr:nth-child(17) > td > input[type=text]:nth-child(8)"));
		elem7.sendKeys("4");
		WebElement elem8 = driver
				.findElement(By.cssSelector("tbody > tr:nth-child(17) > td > input[type=text]:nth-child(9)"));
		elem8.sendKeys("12");
		WebElement elem9 = driver
				.findElement(By.cssSelector("tbody > tr:nth-child(17) > td > input[type=text]:nth-child(10)"));
		elem9.sendKeys("15");
		WebElement elem10 = driver
				.findElement(By.cssSelector("tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
		elem10.click();

		List<WebElement> divElemList = driver.findElements(By.className("list-data"));
		int count = 0;
		for (WebElement elem : divElemList) {
			if (count > 0) {
				for (int i = 2; i <= 8; i++) {
					WebElement day = elem.findElement(By.className("light-green"));
					System.out.print(day.getText() + "	");

					WebElement num = elem
							.findElement(By.xpath("/html/body/div[3]/div/form/table[5]/tbody/tr[" + i + "]/td[2]"));
					System.out.print(num.getText() + "		");

					WebElement subject = elem.findElement(
							By.cssSelector("/html/body/div[3]/div/form/table[5]/tbody/tr[" + i + "]/td[3]/a/font"));
					String url = subject
							.getAttribute("/html/body/div[3]/div/form/table[5]/tbody/tr[" + i + "]/td[3]/a/font");
					System.out.print(url + "	" + subject.getText());
				}

			}
			count++;

		}
	}

}
