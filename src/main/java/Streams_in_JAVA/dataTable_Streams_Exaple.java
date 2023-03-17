package Streams_in_JAVA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataTable_Streams_Exaple {

	public static void main(String[] args) {
	
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://datatables.net/");
		
	List<WebElement> list =driver.findElements(By.cssSelector("td.sorting_1 "));
		
	list.stream().forEach(ele->ele.click());  //click all the elements.
	

	}

}
