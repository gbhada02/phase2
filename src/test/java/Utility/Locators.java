package Utility;

import org.openqa.selenium.By;

public interface Locators {
 
	By cancel = By.className("commonModal__close");
	By fromCity=By.xpath("//input[@id='fromCity']");
	By inputfromcity=By.xpath("//input[@placeholder='From']");
	By inputTOcity=By.xpath("//input[@placeholder='To']");
	By toCitylist= By.xpath("//li[starts-with(@id, 'react-autowhatever-1')]/div/div/div/div/div/p");
	By fromdate = By.xpath("//input[@id='departure']/ancestor::label/span");
	
	
	
	
	
}
