package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	/*
	 * This class is created to initialize webdriver 
	 * 
	 * */
	static WebDriver driver= null;
	static	DriverManager driverManageObj = null;
	
//	public WebDriver getDriver() {
 //       return this.driver;
 //   }

    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static DriverManager getDriver() {
        if(driverManageObj == null) {// check driver manager object exist
        	driverManageObj = new DriverManager();
        }
         return driverManageObj;
    }
	
	

	
	public static WebDriver getWebDriverInstance()
	{
		if(driver !=null) {// check whether the webdriver exist 
			return driver;
		}
		else {// if not exist initialize webdriver
				WebDriverManager.chromedriver().browserVersion("119").setup();
				driver= new ChromeDriver();
				return driver;
		}
		
	}

}
