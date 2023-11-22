package stepdefs;




import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;

import org.testng.asserts.SoftAssert;

import PageClasses.GpHomePage;
import PageClasses.GpLoginPage;
import Utility.DriverManager;
import Utility.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;





public class LoginTest {
	

	GpLoginPage objLogin;
	GpHomePage objhome;
	DriverManager objDriver= new DriverManager();
	
	
	SoftAssert sa;
	PropertyFileReader Prop = new PropertyFileReader();
	//DriverManger driver;
	WebDriver driver = objDriver.getWebDriverInstance(); 
	

	
	@BeforeTest
	@Given("^Web user want to open booking system$")
	public void web_user_want_to_open_booking_system() throws Throwable {
		//WebDriverManager.chromedriver().browserVersion("119").setup();
		System.out.println("print ----->");
		
		//driver= new ChromeDriver();
		sa =new SoftAssert();
		driver.get(PropertyFileReader.readPropertyFile("URL", "./Data/Data.properties"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// to laod Eliment s on the Popoup
		objLogin = new GpLoginPage(driver);
		objLogin.clickAcceptAll();
		
			
		
}
	
	@Test(priority = 0)
	@When("^Web user want to login to booking web app as a user$")
	public void web_user_want_to_login_to_booking_web_app_as_a_user() throws Throwable {
		objLogin.loginGpSevice(PropertyFileReader.readPropertyFile("User","./Data/Data.properties"), PropertyFileReader.readPropertyFile("Password","./Data/Data.properties"));
		objLogin.clickSubmit();
		
		
	}
	@Test(priority = 1)
	@And("^Web User want to move to Home page$")	
	public void web_User_want_to_move_to_Home_page() throws Throwable {
		
		driver.getCurrentUrl().equalsIgnoreCase(PropertyFileReader.readPropertyFile("Current_URL", "./Data/Data.properties"));
		System.out.println("current url"+"----->"+driver.getCurrentUrl());
		objhome =new GpHomePage(driver);
	
		AssertJUnit.assertEquals(objhome.getIntroText(),PropertyFileReader.readPropertyFile("IntroductionText", "./Data/Data.properties"));
		objhome.ClickToSeeADoctor();
		
	}
}
