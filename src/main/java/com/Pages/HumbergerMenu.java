package com.Pages;



import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.commonUtility.AppiumUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HumbergerMenu {

	public HumbergerMenu(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"in.amazon.mShop.android.shopping:id/action_bar_burger_icon\"]")
	private MobileElement humbergerMenyBtn;
	
	@AndroidFindBy(id = "android.widget.LinearLayout:id/in.amazon.mShop.android.shopping:id/anp_drawer_item")
	private MobileElement settingtab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Country']")
	private MobileElement countrySelectTag;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Australia (English)\"]")
	private MobileElement countryName;
	
	
	@AndroidFindBy(accessibility = "Navigate up")
	private MobileElement navigateBack;

	public MobileElement getHumbergerMenyBtn() {
		return humbergerMenyBtn;
	}

	public MobileElement getSettingtab() {
		return settingtab;
	}

	public MobileElement getCountrySelectTag() {
		return countrySelectTag;
	}

	public MobileElement getCountryName() {
		return countryName;
	}

	public MobileElement getNavigateBack() {
		return navigateBack;
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is for clicking on humberger menu
	 * @date : 16/04/2020
	 */
	public void clickOnhamburgerMenu() throws InterruptedException {
		Thread.sleep(10000);
		getHumbergerMenyBtn().isDisplayed();
		getHumbergerMenyBtn().click();
		Reporter.log("Clicked on Menu ICon");
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is for scrolling upto Setting submenu is in view
	 *              and then clicking on setting
	 * @date : 16/04/2020
	 */
	public void scrollUptoSettingView() {
		AppiumUtility.scrollToText("setting");
		getSettingtab().click();
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is used for clicking on setting submenu
	 * @date : 16/04/2020
	 */
	public void clickOnSettingSubMenu() {
		getSettingtab().click();
		Reporter.log("Successfully Clicked on Setting submenu icon");
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is used for verifying the country name
	 * @date : 16/04/2020
	 */
	public void verifyCountryName() {
		String defaultcountry = getCountryName().getText().toString();
		Reporter.log("default selected country is : " + defaultcountry);
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is used for clicking country selection link
	 * @date : 16/04/2020
	 */
	public void clickOnCountySelectionLink() {
		getCountrySelectTag().isDisplayed();
		getCountrySelectTag().click();
	}

	
	/**
	 * @author Manish.singh
	 * @Description : This method is used for selecting the desired country
	 * @date : 16/04/2020
	 */
	public void selectTheCountry() {
		getCountryName().isDisplayed();
		getCountryName().click();
		Reporter.log("Desired Country is selected Successfully");
	}
}
