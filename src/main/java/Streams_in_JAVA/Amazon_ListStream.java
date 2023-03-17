package Streams_in_JAVA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_ListStream {

	public static void main(String[] args) {
			
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.amazon.in/");
			
			List<WebElement> links =driver.findElements(By.xpath("//a"));
			
			System.out.println(links.size());  //  --> gives total no. of links available in Amazon WebPage.
			
			
		/**
		 * Time differnce b/w Sequential and Parallel Stream.	
		 */
			
			long start_time =System.currentTimeMillis();
			
		//	links.stream().forEach(ele->System.out.println(ele.getText()));
			
		//	links.parallelStream().forEach(ele ->System.out.println(ele.getText()));
						
			long end_time =System.currentTimeMillis();
			long time_taken= end_time - start_time; 
			
			//System.out.println(time_taken); 
			//8918 ms for sequential stream.
			//7932 ms for parallel stream
		

	}

}
