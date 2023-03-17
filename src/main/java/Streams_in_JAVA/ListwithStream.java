package Streams_in_JAVA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListwithStream {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/#free-trial-info-menu");
		
		
	By industry_option = By.xpath("//select[@id='Form_getForm_Country']/option");
	
	
	List<WebElement> indus_list =	driver.findElements(industry_option);
	
	long start_time =System.currentTimeMillis();
	
//	 indus_list.parallelStream().forEach(ele -> System.out.println(ele.getText()));  // --> This is parallel stream.
	 
   indus_list.stream().forEach(ele -> System.out.println(ele.getText()));  //--> This is sequential stream.
		
	
	long end_time = System.currentTimeMillis();
	
	System.out.println(end_time-start_time);
	
	
	/*Time Differnce of execution b/w Sequential and Parallel Stream.
	 * 
	 * We fetch the list in 5398 milisecond by sequential stream.
	 * 
	 * We fetch the list in 4615 milisecond by parallel stream.
	 * 
	 * Hence we can say that parallel stream are faster in compare to sequential stream.
	 * 
	 */
	   
	
	
/**
 * Note: 
 * 
 * 1)The difference between the sequential and parralel stream is that sequential stream maintains the order of the output whereas the
 * parallel stream does not maintain the order of output, it gives the random output.	
 * 
 * 2) Parallel stream are faster in compare to sequential stream.
 * 
 * 3) However the drawback with the parallel stream is that,it acquires extra memory for each parralel stream so generally we dont use this.
 * But if we do not want to maintain the output order and wants to gets execution fast we should go with parallel stream.
 * 
 * 4) Whereas the sequential stream are slower in compare to parallel but it occupies less memory in compare to parallel.Hence mostly used.
 *     
 */
	    
	}

}
