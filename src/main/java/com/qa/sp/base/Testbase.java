package com.qa.sp.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.sp.util.TestUtil;

public class Testbase {
	
	
	public static WebDriver driver;
	public static Properties prop;

	
	
	public Testbase()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\Vishwanath\\eclipse-workspace\\Practice\\src\\main\\java\\com\\qa\\sp\\properties\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishwanath\\eclipse-workspace\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browsername.equals("FF")) {
			
			//System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Vishwanath\\\\eclipse-workspace\\\\Chromedriver\\\\chromedriver.exe");
			//driver = new FirefoxDriver();
			
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		driver.navigate().to((prop.getProperty("url")));
		
}
	
	
	public void failed()
	{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrfile, new File(currentdir+"/screenshots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
