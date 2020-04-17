package com.Pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Manish.singh Description : HomePage Java Class to include the Page
 *         Repository and method related to HomePage
 * @date : 08/04/2019
 */
public class HomePage {

	public HomePage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android.widget.Button:id/signInSubmit")
	private MobileElement signInButton;
	
	@AndroidFindBy(xpath = "android.widget.EditText:id/in.amazon.mShop.android.shopping:id/rs_search_src_text")
	private MobileElement searchBox;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_suggestions']")
	private List<MobileElement> searchBoxResults;
	
	@AndroidFindBy(id = "//android.widget.TextView:id/in.amazon.mShop.android.shopping:id/item_title")
	private MobileElement saveSearchPopUp;
	
	@AndroidFindBy(xpath = "//android.widget.TextView:id/in.amazon.mShop.android.shopping:id/item_title")
	private List<MobileElement> tvResultsNameDescription;
	
	@AndroidFindBy(xpath = "//android.widget.TextView:id/in.amazon.mShop.android.shopping:id/item_price")
	private List<MobileElement> tvResultPrices;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"ADD TO CART\"]")
	private MobileElement addTocartBtn;

	public MobileElement getSignInButton() {
		return signInButton;
	}

	public MobileElement getSearchBox() {
		return searchBox;
	}

	public List<MobileElement> getSearchBoxResults() {
		return searchBoxResults;
	}

	public MobileElement getSaveSearchPopUp() {
		return saveSearchPopUp;
	}

	public List<MobileElement> getTvResultsNameDescription() {
		return tvResultsNameDescription;
	}

	public List<MobileElement> getTvResultPrices() {
		return tvResultPrices;
	}

	public MobileElement getAddTocartBtn() {
		return addTocartBtn;
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is used to check display of SignIn Button and then
	 *              click on SignIn Button
	 * @date : 16/04/2020
	 */
	public void clickOnSignInBtn() {
		getSignInButton().isDisplayed();
		getSignInButton().click();
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is used to verify presence of Home Page
	 * @date : 16/04/2020
	 */
	public void verifyHomeIsDisplayed() {
		getSearchBox().isDisplayed();
		Reporter.log("Home is Successfully Loaded");
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is for entering the search detail in the search
	 *              Box
	 * @date : 16/04/2020
	 */
	public void enterSearchDetail(String searchDetail) {
		getSearchBox().isDisplayed();
		getSearchBox().sendKeys(searchDetail);
		Reporter.log("Entered the Search Detail");
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is used to select the TV list details from the
	 *              suggestion displayed
	 * @date : 16/04/2020
	 */
	public void selectTVFromList() {
		searchBoxResults.get(1).isDisplayed();
		searchBoxResults.get(1).click();
		Reporter.log("Clicked on 2nd Tv results Sugession", true);
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is for verifying the pop-up presence and then
	 *              click on the same
	 * @date : 16/04/2020
	 */
	public void clickOnSaVePopUp() {
		getSaveSearchPopUp().isDisplayed();
		getSaveSearchPopUp().click();
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is for selecting the second Tv from the results
	 *              displayed click on the same
	 * @date : 16/04/2020
	 */
	public void selectSecondTvFromSearchResults() {
		getSearchBoxResults().get(1).isDisplayed();
		getSearchBoxResults().get(1).click();
	}

	public static int TVprice;
	public static String TVdescription;

	/**
	 * @author Manish.singh
	 * @Description : This method is for storing the TC price an description in
	 *              static variable so we can use these to verify it on the cart
	 *              page
	 * @date : 16/04/2020
	 */
	public void getAllTheProductDetail() {
		getTvResultPrices().get(1).isDisplayed();
		TVprice = Integer.parseInt(getTvResultPrices().get(1).getText());
		TVdescription = getTvResultsNameDescription().get(1).getText();
		Reporter.log("Successfully taken The Product detail :" + "Descript : " + TVdescription + "\n and Price is :"
				+ TVprice);
	}

	/**
	 * @author Manish.singh
	 * @Description : This method is for verifying presence of the Cart Button and
	 *              then adding the product to cart page
	 * @date : 16/04/2020
	 */
	public void clickOnAddToCardButton() {
		getAddTocartBtn().isDisplayed();
		getAddTocartBtn().click();
		Reporter.log("Product is added to the cart");
	}
}
