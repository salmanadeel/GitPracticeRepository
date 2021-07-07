package ups.pack;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org .openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UPSTestRunner extends BrowserDrivers {
	
	WebDriver driver= null;
	UpsLoginPage upsLoginPage;
	
	
	@BeforeMethod(alwaysRun = true)
    void beforeMetod() {
   
		driver = getChromeDriver();
    upsLoginPage = new UpsLoginPage(driver);
	}


	
	@Test(priority = 3, groups = {"SanityTest"})
	void loginErrorMessageTest() {
		driver.get("http://www.ups.com/lasso/login?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		upsLoginPage.userId("testUser");
		upsLoginPage.password("mypassword");
		upsLoginPage.clickLoginButton();
		String errorMessage = upsLoginPage.upsLoginErrorMessageTest();
		if (errorMessage.contains("unsuccessful")) {
			System.out.println("PASSED!");
		} else {
				System.out.println("FAILED!");
				Assert.fail();
			}
		
				
}
	
	@Test(priority = 4, groups = {"RegressionTest"})
	public void signUpLinkTest() throws InterruptedException {
		driver.get("http://www.ups.com/lasso/login?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		upsLoginPage.clickSignUpLink();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Sign Up | UPS");
		
	}
	@Test(priority = 2, groups = {"SanityTest"})
	public void mDemoTest1() {
		System.out.println("my demo test 1 executed....!");
	}
	
@Test(priority = 1, groups = {"RegressionTest"})
	public void mDemoTest2() {
		System.out.println("my demo test 2 executed....!");
	}
	
	@AfterMethod(alwaysRun = true)
   void afterMethod() {
	   driver.close();
   }



}
