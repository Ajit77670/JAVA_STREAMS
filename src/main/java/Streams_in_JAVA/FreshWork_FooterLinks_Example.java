package Streams_in_JAVA;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreshWork_FooterLinks_Example {

	public static void main(String[] args) {
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com/");
		
		List<WebElement> footerlinks =driver.findElements(By.cssSelector("ul.footer-nav li a"));
		
		
	List<String> footerlist =	footerlinks.stream()
		.filter(ele-> ! ele.getText().isEmpty())
		.map(ele->ele.getText().trim())
		.collect(Collectors.toList());
		
		
	footerlist.stream().forEach(ele->System.out.println(ele));

	}

}
