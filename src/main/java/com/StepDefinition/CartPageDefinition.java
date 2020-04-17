package com.StepDefinition;

import com.Pages.CartPage;
import com.generic.Base;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CartPageDefinition extends Base{

	
	CartPage cartpage=new CartPage(driver);
	
	@Then("^User verify the name, Price and description of the product$")
	public void userVerifyNamePriceAndDescriptionOfTheProduct() {
		cartpage.getCartPageHeader();
		cartpage.verifyTheproductDetail();
	}
	
	 
	 @Given("^CartPageHeader is Displayed$")
		public void CartPageHeader_is_Displayed() {
			cartpage.getCartPageHeader().isDisplayed();
			
		}
}
