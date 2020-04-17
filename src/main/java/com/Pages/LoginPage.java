package com.Pages;


import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	public LoginPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android.widget.EditText:id/ap_email_login")
	MobileElement usernameField;
	
	@AndroidFindBy(id = "android.widget.Button:id/continue")
    MobileElement contiueButton;

	@AndroidFindBy(id = "android.widget.EditText:id/ap_password")
	MobileElement passwordField;

	
	@AndroidFindBy(id = "android.widget.Button:id/signInSubmit")
     MobileElement loginButton;


	@AndroidFindBy(xpath = "")
	MobileElement error_Msg;

	public MobileElement getusernameField() {
		return usernameField;
	}


	public MobileElement getucontiueButton() {
		return contiueButton;
	}

	public MobileElement getpasswordField() {
		return passwordField;
	}

	public MobileElement getSubmit_btn() {
		return loginButton;
	}

	public MobileElement getError_Msg() {
		return error_Msg;
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is verifying the username text-box presence and
	 *              then entering the username
	 * @param Username which is used to enter in the UserName textBox
	 * @date : 16/04/2020
	 */
	public void enterUserName(String un) {
		getusernameField().isDisplayed();
		getusernameField().sendKeys(un);
		Reporter.log("Entered Username", true);
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is verifying the password text-box presence and
	 *              then entering the password
	 * @param password which is used to enter in the password textBox
	 * @date : 08/09/2019
	 */
	public void enterpassword(String pwd) {
		try {
			getpasswordField().isDisplayed();
			getpasswordField().sendKeys(pwd);
			Reporter.log("Entered password", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used for clicking on the signIn Button on the
	 *              SignInPage
	 * @date : 08/09/2019
	 */
	public void clickOnSignIn() {
		getSubmit_btn().click();
		Reporter.log("click on SignIn button", true);
	}

}
