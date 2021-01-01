package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class NewAccountPage extends BasePage {

	private final String editAccountLink = "//a[text()='Edit Account']";
	private final String newAccountLink = "//a[text()='New Account']";
	private final String customerIdTextBox = "//input[@name='cusid']";
	private final String accountTypeDropdownList = "//select[@name='selaccount']";
	private final String initialDepositTextBox = "//input[@name='inideposit']";
	// Value after create new account
	private final String accountIDValue = "//td[text()='Account ID']/following-sibling::td";
	private final String customerIDValue = "//td[text()='Customer ID']/following-sibling::td";
	private final String accountTypeValue = "//td[text()='Account Type']/following-sibling::td";
	private final String currentAmountValue = "//td[text()='Current Amount']/following-sibling::td";
	// Message
	private final String newAccountSuccessMessage = "//p[@class='heading3']";
	private final String submitButton = "//input[@type='submit']";

	public NewAccountPage(WebDriver driver) {
		super(driver);
	}

	public EditAccountPage clickToEditAccountLink() {
		clickToElement(editAccountLink);
		return new EditAccountPage(getDriver());
	}

	public void clickToNewAccountLink() {
		clickToElement(newAccountLink);
	}

	public void typeDataToCustomerIdTextBox(String data) {
		sendKeysToElement(customerIdTextBox, data);
	}

	public void selectValueInAccountTypeList(String data) {
		selectValueInDropdownList(accountTypeDropdownList, data);
	}

	public void typeDataToInitialDepositTextBox(String data) {
		sendKeysToElement(initialDepositTextBox, data);
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public boolean isNewAccountSuccessMessageDisplayed() {
		return isElementDisplayed(newAccountSuccessMessage);
	}

	public String getNewAccountSuccessMessage() {
		return getTextElement(newAccountSuccessMessage);
	}

	public String getAccountIdValueAfterCreateAccount() {
		return getTextElement(accountIDValue);
	}

	public String getCustomerIdValueAfterCreateAccount() {
		return getTextElement(customerIDValue);
	}

	public String getAccountTypeValueAfterCreateAccount() {
		return getTextElement(accountTypeValue);
	}

	public String getCurrentAmountValueAfterCreateAccount() {
		return getTextElement(currentAmountValue);
	}

}
