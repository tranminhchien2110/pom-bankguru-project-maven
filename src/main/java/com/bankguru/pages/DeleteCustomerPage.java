package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class DeleteCustomerPage extends BasePage {

	private final String editCustomerLink = "//a[text()='Edit Customer']";
	private final String customerIdTextBox = "//input[@name='cusid']";
	private final String submitButton = "//input[@type='submit']";

	public DeleteCustomerPage(WebDriver driver) {
		super(driver);
	}

	public EditCustomerPage clickToEditCustomerLink() {
		clickToElement(editCustomerLink);
		return new EditCustomerPage(getDriver());
	}
	
	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public void clickAcceptAlert() {
		acceptAlert();
	}

	public void typeDataToCustomerIdTextBox(String data) {
		sendKeysToElement(customerIdTextBox, data);
	}
	
	public String getDeleteCustomerSuccessMessage() {
		return getTextFromAlert();
	}
}
