package com.Pages;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Manish.singh 
 * Description: cart page , not able to add to cart but still located element
 * @date : 16/04/2020
 */
public class CartPage {
	public CartPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed to Buy']")
	private MobileElement cartPageHeader;
	//xpath = "//android.widget.Button[@text=\"ADD TO CART\"]"
	@AndroidFindBy(className = "android.view.View[3]")
	private MobileElement productsPrice;
	
	@AndroidFindBy(className = "android.view.View[1]")
	private MobileElement ProdcutsDescription;

	/**
	 * @author Manish.singh Description: Created Getter of all the MobileElements to get
	 *         the Element using getter for dataRestriction purpose
	 * @date : 16/04/2020
	 */
	public MobileElement getCartPageHeader() {
		return cartPageHeader;
	}

	public MobileElement getProductsPrice() {
		return productsPrice;
	}

	public MobileElement getProdcutsDescription() {
		return ProdcutsDescription;
	}

	/**
	 * @author Manish.singh
	 * @description: This method is used to check whether Cart Page is displaying or not
	 * @date : 16/04/2020
	 */
	public void verifyCartPageIsDisplaying() {
		getCartPageHeader().isDisplayed();
		Reporter.log("Cart Page is Displayed");
	}

	/**
	 * @author Manish.singh
	 * @description: This method is used to verify the product detail on the Cart
	 *               Page which included TV price and description
	 * @date : 16/04/2020
	 */
	public void verifyTheproductDetail() {
		int TVPriceonOnCart = Integer.parseInt(getProductsPrice().getText());
		String tvDescOnCart = getProdcutsDescription().getText();
		Assert.assertEquals(TVPriceonOnCart, HomePage.TVprice);
		Assert.assertEquals(tvDescOnCart, HomePage.TVdescription);
		Reporter.log("TV Name, Price and desription are verified on Cart Page");
	}

}
