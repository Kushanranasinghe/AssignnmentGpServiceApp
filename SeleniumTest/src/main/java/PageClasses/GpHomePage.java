package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GpHomePage {
	WebDriver driver;
	String IntroText;
	
	
	By IntrotextA = By.xpath("//div/h1[contains(text(),'Talk to one of our UK Registered Doctors online today')]");
	By AppointmentBtn = By.xpath("//a[@class='btn btn--1 see-a-doctor']");
	
	public  GpHomePage(WebDriver driver) {
		this.driver=driver;
		}
	
	public String getIntroText() {
		 IntroText=driver.findElement(IntrotextA).getText();
		 	return IntroText;
			
		}
	public void ClickToSeeADoctor() {
		driver.findElement(AppointmentBtn).click();
		
	}
		

}


