package Utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PageActions extends Utils {

	
	
	
	


	

	public static void Login(String browser) throws IOException {
		
		initilisedriver(browser);
		driver.get(propreturn("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	}
}

