package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class GpLoginPage {
	WebDriver driver;
	
	
By AcceptAll= By.xpath("//span[@id='cmpwelcomebtnyes']");
By UserName = By.id("email");
By Password =By.id("password");
By Submit = By.xpath("//button[@type='submit']");

public GpLoginPage(WebDriver driver){
	this.driver=driver;
	
}
public void clickAcceptAll(){
	
		driver.findElement(AcceptAll).click();
}

public void setUserName(String strUserName) {
	driver.findElement(UserName).sendKeys(strUserName);
}
public void setPassword(String strPassword) {
	driver.findElement(Password).sendKeys(strPassword);
	
}
public void clickSubmit() {
	driver.findElement(Submit).click();
	
}
	
public void loginGpSevice(String strUserName, String strPassword) {
		
		this.setPassword(strPassword);
		this.setUserName(strUserName);

}
}
