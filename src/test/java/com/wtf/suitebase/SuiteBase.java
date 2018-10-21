package com.wtf.suitebase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteBase {

	
	private static WebDriver driver = null;
	private static Actions action = null;
	private static WebDriverWait wait = null;
	private static Select  select = null;
	private static DesiredCapabilities cap = null;
	private static FluentWait<WebDriver> fluentwait = null;
	
	private long implicitTimeout = 120;
	private long webDriverWait = 80;
	
	@BeforeSuite
	public void suiteConfiguration() throws InterruptedException, MalformedURLException{
		
		String browser = System.getProperty("browser");
		PropertyConfigurator.configure("log4j.properties");
		switch(browser){
		
		case ("firefox"):
			driver = new FirefoxDriver();
		    driver.manage().timeouts().wait(implicitTimeout);
		    driver.manage().deleteAllCookies();
		    driver.manage().window().maximize();
		    wait = new WebDriverWait(driver, webDriverWait);
		    action = new Actions(driver);
		    fluentwait = new FluentWait<WebDriver>(driver).pollingEvery(5, TimeUnit.SECONDS).
		    		ignoring(ElementNotVisibleException.class)
		    		.withTimeout(180, TimeUnit.SECONDS)
		    		.withMessage("Element is not accessible");
			break;
			
		case ("chrome"):
			driver = new ChromeDriver();
		    driver.manage().timeouts().wait(implicitTimeout);
		    driver.manage().deleteAllCookies();
		    driver.manage().window().maximize();
		    wait = new WebDriverWait(driver, webDriverWait);
		    action = new Actions(driver);
		    fluentwait = new FluentWait<WebDriver>(driver).pollingEvery(5, TimeUnit.SECONDS).
		    		ignoring(ElementNotVisibleException.class)
		    		.withTimeout(180, TimeUnit.SECONDS)
		    		.withMessage("Element is not accessible");
		  
			break;
		case ("android"):
			
			cap = new DesiredCapabilities();
	        cap.setCapability("", "");
	        cap.setBrowserName("chrome");	        
	        driver  = new RemoteWebDriver(new  URL(""), cap);
			break;
			
		default:
			System.out.println("No supported browser");
		}
	}
	
	public static WebDriver getDrive(){
		return driver;
	}
	
	public static Actions getAction(){
	 	return action;
	}
	
	public static Select getSelect(WebElement element){
		
		return select = new Select(element);
	}
	
	public static WebDriverWait getWait(){
		return wait;
	}
	
	public FluentWait<WebDriver> getFluentWait(){
		return fluentwait;
	}
	
	@AfterSuite
	public void tearDown(){
		getDrive().quit();
	}
}
