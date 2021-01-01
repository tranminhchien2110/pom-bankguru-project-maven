package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class WithdrawPage extends BasePage {

	private final String fundTransferLink = "//a[text()='Fund Transfer']";
	private final String accountNumberTextBox = "//input[@name='accountno']";
	private final String amountTextBox = "//input[@name='ammount']";
	private final String descriptionTextBox = "//input[@name='desc']";
	// Value after withdraw
	private final String currentBalanceValue = "//td[text()='Current Balance']/following-sibling::td";
	private final String descriptionValue = "//td[text()='Description']/following-sibling::td";
	// Message
	private final String withdrawSuccessMessage = "//p[@class='heading3']";
	private final String submitButton = "//input[@type='submit']";

	public WithdrawPage(WebDriver driver) {
		super(driver);
	}

	public FundTransferPage clickToFundTransferLink() {
		clickToElement(fundTransferLink);
		return new FundTransferPage(getDriver());
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public void typeDataToAccountNumberTextBox(String data) {
		sendKeysToElement(accountNumberTextBox, data);
	}

	public void typeDataToAmountTextBox(String data) {
		sendKeysToElement(amountTextBox, data);
	}

	public void typeDataToDescriptionTextBox(String data) {
		sendKeysToElement(descriptionTextBox, data);
	}

	public boolean isWithdrawSuccessMessageDisplayed() {
		return isElementDisplayed(withdrawSuccessMessage);
	}

	public String getWithdrawSuccessMessage() {
		return getTextElement(withdrawSuccessMessage);
	}

	public String getCurrentBalanceValueAfterWithdraw() {
		return getTextElement(currentBalanceValue);
	}

	public String getDescriptionValueAfterWithdraw() {
		return getTextElement(descriptionValue);
	}
}
