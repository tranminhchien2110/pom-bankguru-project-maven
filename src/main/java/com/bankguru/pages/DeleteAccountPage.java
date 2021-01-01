package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class DeleteAccountPage extends BasePage {

	private final String deleteAccountLink = "//a[text()='Delete Account']";
	private final String editAccountLink = "//a[text()='Edit Account']";
	private final String accountNumberTextBox = "//input[@name='accountno']";
	private final String submitButton = "//input[@type='submit']";

	public DeleteAccountPage(WebDriver driver) {
		super(driver);
	}

	public EditAccountPage clickToEditAccountLink() {
		clickToElement(editAccountLink);
		return new EditAccountPage(getDriver());
	}

	public void clickToDeleteAccountLink() {
		clickToElement(deleteAccountLink);
	}

	public void clickAcceptAlert() {
		acceptAlert();
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public void typeDataToAccountNumberTextBox(String data) {
		sendKeysToElement(accountNumberTextBox, data);
	}

	public String getDeleteAccountSuccessMessage() {
		return getTextFromAlert();
	}
}
