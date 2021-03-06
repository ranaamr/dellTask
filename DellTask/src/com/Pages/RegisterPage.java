package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	static WebDriver driver;
	WebDriverWait wait;

	// Locators of Elements of the login page
	//By createAcctBtn = By.xpath("//div[@class='text-light']/a");
	By rgstrBtn = By.id("Primary_Navbar-Register");
	By fnameTxt = By.id("inputFirstName"); 
	//*[@id="inputFirstName"]
	//By fnameTxt = By.xpath("//*[@id='nputFirstName']");
	By lnameTxt = By.id("inputLastName");
	By emailTxt = By.id("inputEmail");
	By countrylist = By.xpath("//div[@class='flag-container']/ul[@class='country-list']");
	By phoneNum = By.id("inputPhone");
	By companyTxt = By.id("inputCompanyName");
	By addresstxt1 = By.id("inputAddress1");
	By addresstxt2 = By.id("inputAddress2");
	By cityTxt = By.id("inputCity");
	By countryList2 = By.id("inputCountry");
	By whatsappNum = By.id("customfield2");
	By pass1Txt = By.id("inputNewPassword1");
	By pass2Txt = By.id("inputNewPassword2");
	By recaptchaCheck = By.id("recaptcha-anchor");
	By registerBtn = By.xpath("//div[@class='form-actions']/input[@value='Register']");
	By dashboardverify = By.xpath("//div[@class='container']/h1[contains(text(), 'My Dashboard')]");

	// By welcomeMenu = By.id("welcome");
	// By logoutBtn =
	// By.xpath("//div[@id='welcome-menu']/ul/li/a[text()='Logout']");

	// Constructor
	public RegisterPage(WebDriver driver) {
		RegisterPage.driver = driver;
		wait = new WebDriverWait(driver, 1000);
	}

	// click on create new account button
	public void clickCreateAccount() throws InterruptedException {
		driver.findElement(rgstrBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(rgstrBtn));
		driver.findElement(rgstrBtn).click();
	}

	// Set First name Text field
	public void setFirstnamevalue(String fname) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(fnameTxt));
		driver.findElement(fnameTxt).sendKeys(fname);
	}

	// Set Last name Text field
	public void setLastnamevalue(String lname) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lnameTxt));
		driver.findElement(lnameTxt).sendKeys(lname);
	}

	// Set Email Text field
	public void setEmailvalue(String Email) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailTxt));
		driver.findElement(emailTxt).sendKeys(Email);
	}

	// Select country drop down menu
	public void chooseCountryvalue(String newCountry) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(countrylist));
		// WebElement countryDropDown = driver.findElement(orgCountry);
		Select dropdownCountry = new Select(driver.findElement(countrylist));
		// Select drpCountry = new Select((WebElement) orgCountry);
		dropdownCountry.selectByVisibleText(newCountry);

	}
	// Set phone Text field
	public void setPhonevalue(String Company) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNum));
		driver.findElement(phoneNum).sendKeys(Company);
	}
	// Set Company Text field
	public void setCompanyvalue(String Company) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyTxt));
		driver.findElement(companyTxt).sendKeys(Company);
	}

	// Set Address1 Text field
	public void setAddress1value(String Address1) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addresstxt1));
		driver.findElement(addresstxt1).sendKeys(Address1);
	}

	// Set Address2 Text field
	public void setAddress2value(String Address2) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addresstxt2));
		driver.findElement(addresstxt2).sendKeys(Address2);
	}

	// Set City Text field
	public void setCityvalue(String city) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cityTxt));
		driver.findElement(cityTxt).sendKeys(city);
	}

	// Select country drop down menu
	public void chooseCountry2value(String newCountry2) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(countryList2));
		// WebElement countryDropDown = driver.findElement(orgCountry);
		Select dropdownCountry = new Select(driver.findElement(countryList2));
		// Select drpCountry = new Select((WebElement) orgCountry);
		dropdownCountry.selectByVisibleText(newCountry2);
		

	}

	// Set Whatsapp mobile number Text field
	public void setWhatsappMobvalue(String WhatsappMob) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(whatsappNum));
		driver.findElement(whatsappNum).sendKeys(WhatsappMob);
	}

	// Set Password1 Text field
	public void setPassowrd1value(String Password1) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(pass1Txt));
		driver.findElement(pass1Txt).sendKeys(Password1);
	}

	// Set Password2 Text field
	public void setPassowrd2value(String Password2) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(pass2Txt));
		driver.findElement(pass2Txt).sendKeys(Password2);
	}

	
	// Check on recaptchaCheck
		public void clickonrecaptchaCheck() throws InterruptedException {
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(recaptchaCheck));
			JavascriptExecutor js =(JavascriptExecutor)driver;
			WebElement ele = driver.findElement(recaptchaCheck);
			//JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",ele);
			//WebElement ele = driver.findElement(recaptchaCheck);
		
			//driver.findElement(recaptchaCheck).click();
			driver.switchTo().parentFrame();
		}
	// click on Register button
	public void clickRegister() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtn));
		driver.findElement(registerBtn).click();
	}



	// Verify User logged in
	public String verifyUserRegisterSuccessfully() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardverify));

		String actualText = driver.findElement(dashboardverify).getText();
		return actualText;

	}

//	// Verify user not logged Invalid credentials
//	public String verifyInvalidCredentailsMsg() throws InterruptedException {
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredMsg));
//
//		String actualText = driver.findElement(invalidCredMsg).getText();
//		return actualText;
//
//	}

}
