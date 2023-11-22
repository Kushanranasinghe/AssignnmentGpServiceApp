package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class GpMakeAppointmentPage {
	WebDriver driver;
	String AppointmentTxt;

	
	By ApText = By.xpath("//h1[@style='text-align: center;']");
	By DifDateChooseBtn = By.xpath("//button[contains(@class,'btn btn--1 btn-choose')]");
	By BtnshowOther = By.xpath("//button[contains(@class,'btn btn-show-other')]");
	By ListOfDates= By.xpath("//div/button[@class='btn btn--o_1 slot-item-btn']");
	By ListOfTime = By.xpath("//button[@class='btn slot-item-btn'][1]");
	By PatientComplint =By.xpath("//textarea[@id='presentingComplaint']");
	By PostalCode =By.name("postcode");
	By FindPharmecies =By.xpath("//button[@class='btn btn--2']");
	By SelectParmacy = By.xpath("/html/body/app-root/div/div/app-delivery/div/form/div[2]/div[2]/div[1]/app-pharmacy-picker/div[2]/div[1]/ul/li[1]");
	
	By Submit = By.xpath("//button[@class='btn btn--1 responsive-btn-third']");
	
	public GpMakeAppointmentPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
public String getAppointmentPageText() {
	AppointmentTxt= driver.findElement(ApText).getText();
	return AppointmentTxt;
	
	
}
public void chooseAdiferentDaybtnclick() {
	driver.findElement(DifDateChooseBtn).click();
}

public void selectDateformTheList() {
	List<WebElement> DatePicklist = driver.findElements(ListOfDates);
	if(DatePicklist.size()!=0)
	{
		
		System.out.println(DatePicklist.size()+"Elements found as Buttons \n");
		
		//for(WebElement ClickButton : DatePicklist)
		//{
			//System.out.println(ClickButton.findElements(ListOfDates));
			System.out.println(DatePicklist);
			driver.findElement(ListOfDates).click();
		//}
	}
	

}

public void selectTimeFromTheList() {
	driver.findElement(ListOfTime).click();
	
}

public void enterSymptom(String description) {
	driver.findElement(PatientComplint).sendKeys(description);
}

public void selectPharmacy(String postCode) {
	driver.findElement(PostalCode).sendKeys(postCode);
	driver.findElement(FindPharmecies).click();
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	//wait.until(ExpectedConditions.visibilityOfElementLocated (SelectParmacy));
	
	WebElement mySelectedElement = driver.findElement(SelectParmacy);
	mySelectedElement.click();
	//Select listofitems = new Select(mySelectedElement);
	//listofitems.selectByVisibleText("Holborn Tube ");
}

public void submintAppointment() {
	driver.findElement(Submit).click();
}

}
