package Validation;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Locators;
import Utility.Utils;

public class MakeMyTripvalidation extends Utils implements Locators  {
 
	
	public void login() throws InterruptedException, IOException {
		String ganesh = "Ganesh";
		int i = 232323;
		click(Locators.cancel);
		click(Locators.fromCity);
		sendKeys(Locators.inputfromcity,"Mum");
		Actions act = new Actions(driver);
		Thread.sleep(1000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();;
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();;
		Thread.sleep(1000);
		Thread.sleep(1000);
		sendKeys(Locators.inputTOcity,"Kol");
		List<WebElement> list = getListOfWebElements(Locators.toCitylist);
		for(WebElement ele : list) {
			String text=getTextOfWebelemt(ele);
			if(text.equals("Kona, United States")) {
				ele.click();
				Thread.sleep(5000);
				break;
			}
				
		}
		
		click(Locators.fromdate);
		clickfromdate();
		
	
		
	}
	public static By getToCityAutoSuggesiontext(String tocity) {
		String s ="//li[starts-with(@id, 'react-autowhatever-1')]/div/div/div/div/div/p[text()='?']".replace("?", tocity);
	return By.xpath(s);
	}
	public static boolean clickfromdate() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='DayPicker-Month']/div/div[text()='July 2025']")));
			driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div/div[text()='July 2025']")).click();
			return true;
			}catch(Exception e){
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
				Thread.sleep(5000);
				
			}
		return clickfromdate();
	}
}
