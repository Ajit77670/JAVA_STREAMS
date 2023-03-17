package Streams_in_JAVA;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class List_with_Stream_Filter {

	public static void main(String[] args) {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> links =driver.findElements(By.xpath("//a"));
		
		System.out.println("Total no. of links available on Amazon WbPage " +links.size());
		
		
	// Filtering the blank links using streams.	
		
	/*
	 * List<String> collectList = links 
	 * 			.stream() 
	 * 				.filter(ele-> ! ele.getText().equals("")) 
	 * 						.map(ele->ele.getText())
	 * 								.collect(Collectors.toList());
	 */
		
		
		
// Applying more than one filter to the streams with (&&) operator , Here we are trying to get the links contains Amazon as text.
		
	/*
	 * List<String> collectList = links 
	 * 				.stream() .filter(ele->!ele.getText().equals(" ") && ele.getText().contains("Amazon"))
	 * 							.map(ele->ele.getText()) 
	 * 								.collect(Collectors.toList());
	 */

		
		
//Applying Multiple Filter 	to the stream
		
		
	List<String> collectList = links
			.stream()
				.filter(ele -> !ele.getText().isEmpty())
					.filter(ele-> !ele.getText().startsWith(" "))
						.map(ele->ele.getText().trim())
							.collect(Collectors.toList());
		
	//	collectList.stream().forEach(ele->System.out.println(ele));  //----> Sequential Stream
		
	collectList.parallelStream().forEach(ele->System.out.println(ele));	//---> Parallel Stream
		
	}

}
