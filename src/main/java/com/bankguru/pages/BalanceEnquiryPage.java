package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class BalanceEnquiryPage extends BasePage {

	private final String deleteAccountLink = "//a[text()='Delete Account']";
	private final String accountNumberTextBox = "//input[@name='accountno']";
	// Value balance enquiry
	private final String accountNumberValue = "//td[text()='Account No']/following-sibling::td";
	private final String balanceEnquiryValue = "//td[text()='Balance']/following-sibling::td";
	// Message
	private final String balanaceEnquirySuccessMessage = "//p[@class='heading3']";
	private final String submitButton = "//input[@type='submit']";

	public BalanceEnquiryPage(WebDriver driver) {
		super(driver);
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public DeleteAccountPage clickToDeleteAccountLink() {
		clickToElement(deleteAccountLink);
		return new DeleteAccountPage(getDriver());
	}

	public void typeDataToAccountNumberTextBox(String data) {
		sendKeysToElement(accountNumberTextBox, data);
	}

	public boolean isBalanceEnquirySuccessMessageDisplayed() {
		return isElementDisplayed(balanaceEnquirySuccessMessage);
	}

	public String getBalanceEnquirySuccessMessage() {
		return getTextElement(balanaceEnquirySuccessMessage);
	}

	public String getAccountNumberBalanceEnquiry() {
		return getTextElement(accountNumberValue);
	}

	public String getBalanceEnquiry() {
		return getTextElement(balanceEnquiryValue);
	}

}
