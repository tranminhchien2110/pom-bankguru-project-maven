package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class EditAccountPage extends BasePage {

	private final String depositLink = "//a[text()='Deposit']";
	private final String deleteAccountLink = "//a[text()='Delete Account']";
	private final String deleteCustomerLink = "//a[text()='Delete Customer']";
	private final String accountNumberTextBox = "//input[@name='accountno']";
	private final String accountTypeDropdownList = "//select[@name='a_type']";
	// Value after edit
	private final String accountTypeValue = "//td[text()='Account Type']/following-sibling::td";
	// Message
	private final String editAccountSuccessMessage = "//p[@class='heading3']";
	private final String submitButton = "//input[@value='Submit']";

	public EditAccountPage(WebDriver driver) {
		super(driver);
	}

	public DeleteCustomerPage clickToDeleteCustomerLink() {
		clickToElement(deleteCustomerLink);
		return new DeleteCustomerPage(getDriver());
	}

	public DepositPage clickToDepositLink() {
		clickToElement(depositLink);
		return new DepositPage(getDriver());
	}

	public DeleteAccountPage clickToDeleteAccountLink() {
		clickToElement(deleteAccountLink);
		return new DeleteAccountPage(getDriver());
	}

	public void typeDataToAccountNumberTextBox(String data) {
		sendKeysToElement(accountNumberTextBox, data);
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public void clickAcceptAlert() {
		acceptAlert();
	}

	public void selectValueInAccountTypeList(String data) {
		selectValueInDropdownList(accountTypeDropdownList, data);
	}

	public boolean isEditAccountSuccessMessageDisplayed() {
		return isElementDisplayed(editAccountSuccessMessage);
	}

	public String getEditAccountSuccessMessage() {
		return getTextElement(editAccountSuccessMessage);
	}

	public String getAccountTypeValueAfterEditAccount() {
		return getTextElement(accountTypeValue);
	}

	public String getAccountNotExistMessage() {
		return getTextFromAlert();
	}

}
