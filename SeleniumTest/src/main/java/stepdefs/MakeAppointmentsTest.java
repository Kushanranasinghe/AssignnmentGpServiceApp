package stepdefs;



import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageClasses.GpMakeAppointmentPage;
import Utility.DriverManager;
import Utility.PropertyFileReader;
import io.cucumber.java.en.And;



public class MakeAppointmentsTest {
//	LoginTest Login;
	GpMakeAppointmentPage apoints;
	WebDriver driver = DriverManager.getWebDriverInstance();
	SoftAssert sa =new SoftAssert();
	
	
	
	@Test(priority = 2)
	@And("^Web user Want to move to Appoinment page$")
	public void web_user_want_to_move_to_appoinment_page() {
		System.out.println("text----------------->");
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.getCurrentUrl().equalsIgnoreCase(PropertyFileReader.readPropertyFile("Current_URL2", "./Data/Data.properties"));
		apoints =new GpMakeAppointmentPage(driver);
		sa.assertEquals(apoints.getAppointmentPageText(), PropertyFileReader.readPropertyFile("AppoitmentTxt1", "./Data/Data.properties"));	
		System.out.println("text 2----------------->");
	}
	@Test(priority = 3)
	@And("^Web user Want to make an Appoinment$")
	public void web_user_want_to_make_an_appoinment() {
		System.out.println("text3----------------->");
	    apoints.chooseAdiferentDaybtnclick();
	    apoints.selectDateformTheList();
	    apoints.selectTimeFromTheList();
	    apoints.enterSymptom("severe headaches,chest pain,dizziness");
	    apoints.selectPharmacy("WC2N 5DU");
	    apoints.submintAppointment();
	    
	}
	
	@AfterTest
	public void TearDown() {
	sa.assertAll();
	driver.close();
	}

}
