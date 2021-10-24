package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowsAndColumn {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement webTable = driver.findElement(By.id("table_id"));
		List<WebElement> tableRow = webTable.findElements(By.tagName("tr"));
		System.out.println("no of rows in the table" +tableRow.size());
		
		WebElement firstRow = tableRow.get(1);
		List<WebElement> tablecolumn = firstRow.findElements(By.tagName("th"));
		System.out.println("no of column in the row" +tablecolumn);
		
		for (WebElement eachRowElement : tableRow) {
			System.out.println(eachRowElement);
			System.out.println(eachRowElement.getText());
		}
		
		for(int i=1; i<tableRow.size(); i++) {
			WebElement row = tableRow.get(i);
			List<WebElement> column = row.findElements(By.tagName("td"));
			String columnText = column.get(1).getText();
			System.out.println(columnText);
		}
		

	}

}
