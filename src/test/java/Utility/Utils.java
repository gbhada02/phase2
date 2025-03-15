package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import groovyjarjarpicocli.CommandLine.Help.Ansi.Text;
//import com.aventstack.extentreports.ExtentHtmlReporter;


public class Utils {
	
	public static ExtentTest test;
	public static  Properties prop;
    public static FileInputStream file ;
	public static WebDriver driver;
	public static ExtentReports extend;
	public static ExtentHtmlReporter html ;
	
public static void initilisedriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
			
		}
		if(browser.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
	}
	
//new 
public static String propreturn(String key) throws IOException {
	FileInputStream file = new FileInputStream("Configuration\\config.properties");
	prop= new Properties();
	prop.load(file);
	return prop.getProperty(key);
}
	public static void click(By locator) throws IOException {
		
		  // Get the screenshot path
		JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].style.border='3px solid red'; arguments[0].style.backgroundColor='yellow';", getElement(locator));
		 getElement(locator).click();
	     test.addScreenCaptureFromPath( getScreenShot());
	}
	
	public static void explicitWait(By locator) {
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	
	
	}
	
	public static WebElement getElement(By locator) {
		explicitWait(locator);
		return driver.findElement(locator);
	}
	
	public static String getTextOfWebelemt(WebElement ele) {
		
		return ele.getText()  ;
		
	}
	
	public static void getExtendReport(String local) {
		 html = new ExtentHtmlReporter("C:\\Users\\divya\\eclipse-workspace\\New_phase2\\ScreenShot\\"+local.replace("-","_").replace(":", "_")+".html");
		 extend = new ExtentReports();
		extend.attachReporter(html);
		test = extend.createTest("First");
		test.pass("ededjik");
		
		
	}
	public static String getlocaldatetime() {
     LocalDateTime local = LocalDateTime.now();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		String time = local.format(format);
		return time;
	}
	
	public static String getScreenShot() throws IOException {
		
		TakesScreenshot tc  = (TakesScreenshot)driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File tr=new File("\\ScreenShot\\"+getlocaldatetime().replace("-","_").replace(":", "_")+".png");
		FileUtils.copyFile(src, tr);
		return tr.getAbsolutePath();
		
	}
	
	public static List<WebElement> getListOfWebElements(By locator){
		explicitWait(locator);
		return driver.findElements(locator);
		
	}
	
	public static void sendKeys(By locator,String value) {
		explicitWait(locator);
		getElement(locator).sendKeys(value);
	}
	
	public static void ARROW_DOWN() {
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ARROW_DOWN).perform();
	
	}
	
	public static String getText(By locator) {
		explicitWait(locator);
		return getElement(locator).getText();
	}
	
	
	public static WebElement fluentwait(By locator) {
		
		
		return null;
		
		
	}
	
	
	
	

	
		
	public static ExtentReports  extendreport() {
	    html = new ExtentHtmlReporter("C:\\Users\\divya\\eclipse-workspace\\Framework\\Reports\\report.html");
		
	    extend = new ExtentReports();
		
		extend.attachReporter(html);
		
		test=extend.createTest("Myfirsttest", "yes I did it");
		
		return extend;
		
	}
	public static void pass(String message) {
		
		extendreport();
		//test.log(Status.PASS, "soft pass");
		test.pass(message);
	}
	
public static void Fail() {
		
		extendreport();
		//test.log(Status.FAIL, "soft pass");
		test.fail("pass hard");
	}
	
	
	public void getscreenshot() throws IOException {
		
		TakesScreenshot tc = (TakesScreenshot) driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File target = new File("payh");
		
		FileUtils.copyFile(src, target);
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().frame(0);
		
		String parent = driver.getWindowHandle();
		Set<String> s =driver.getWindowHandles();
		Iterator<String> i = s.iterator();
		while(i.hasNext()){
			
			System.out.println(i.next());
		}
		for(String s1:s) {
			driver.switchTo().window(s1);
			if(s.equals(driver.getTitle())) {
				break;
			}
		}
		
		Actions act = new Actions(driver);
		
	
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		ExtentHtmlReporter html = new ExtentHtmlReporter("ejwjw");
		
		ExtentReports extent = new ExtentReports();
		
			extent.attachReporter(html);	
			ExtentTest test = extent.createTest("sdsd");
			
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String date =now.format(formater);
		
		
//		driver.findElement(By.id(""));
//		driver.findElement(By.xpath(""));
//		driver.findElement(By.tagName("a"));
//		driver.findElement(By.partialLinkText("sdsfs"));
//		//driver.findElement(By.xpath(date))take
//		
//		WebElement ele1 = driver.findElement(By.xpath(""));
//		
//		Select s4 = new Select(ele1);
		

		//suhwsjwsj
	}


}

	
