package project1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zomato {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kanak Tandon\\NewEclipseWorkspace\\chromedriver_129.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.forbes.com/billionaires/");
		Thread.sleep(20000);		
		
		//scroll to richest people in world header
		scrollDownToXpath("//h2[normalize-space()='The Richest People In The World']");
		Thread.sleep(5000);
		
		
		//click on country
		driver.findElement(By.xpath("(//span[normalize-space()='country / Territory'])[1]")).click();
		//scroll to india element from dropdown
		scrollDownToXpath("//li[@value='India']");
		//click on india
		driver.findElement(By.xpath("//li[@value='India']")).click();
		Thread.sleep(10000);
		//find and store all 250 movie in list 
		List<WebElement> india_richest_people = driver.findElements(By.xpath("//div[contains (@class,'Table_personName')]"));
		
		
		System.out.println("number of india_richest_people in forbes: "+ india_richest_people.size());
		System.out.println();
		for (WebElement e: india_richest_people) {
			
			if (!e.getText().trim().equals("NAME")) {
				System.out.println(e.getText().trim());
				
			}
			
		}
		
		
		

}
	
	public static void scrollDownToXpath(String xpath) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement e = driver.findElement(By.xpath(xpath));

		int counter = 1;
		while (counter < 5) {
			// if element found , exit the loop
			if (e.isDisplayed()) {
//				System.out.println("element found");
				break;
				// if not found , continue the loop
			} else {
				System.out.println("element not found");
				js.executeScript("window.scrollBy(0,50)");
				Thread.sleep(5000);
				counter++;
			}
		}
	}
}
