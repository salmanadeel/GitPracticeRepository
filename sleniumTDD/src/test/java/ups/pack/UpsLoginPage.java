package ups.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class UpsLoginPage {
	
	WebDriver driver = null;
	
public UpsLoginPage(WebDriver driver) {
	this.driver=driver;
	
}	

public void userId(String user) {
	WebElement userID = driver.findElement(By.id("email"));
	userID.sendKeys("user");
	}
	
public void password(String pass) {
	WebElement password = driver.findElement(By.name("password"));
	password.sendKeys("pass");
}

public void clickLoginButton() {
	WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"submitBtn\"]"));
	loginButton.click();
}
	public String upsLoginErrorMessageTest() {
		WebElement errorMessages = driver.findElement(By.id("errorMessages"));
		String message = errorMessages.getText();
		return message;
		
	}

	public void clickSignUpLink() {
		WebElement signUp = driver.findElement(By.xpath("//*[@id=\"DOARegisterLink\"]"));
		signUp.click();
		}
	
	
	
	
}
