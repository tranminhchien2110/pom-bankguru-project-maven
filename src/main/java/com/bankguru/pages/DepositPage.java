package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class DepositPage extends BasePage {

	private final String withdrawalLink = "//a[text()='Withdrawal']";
	private final String accountNumberTextBox = "//input[@name='accountno']";
	private final String amountTextBox = "//input[@name='ammount']";
	private final String descriptionTextBox = "//input[@name='desc']";
	// Value after deposit
	private final String currentBalanceValue = "//td[text()='Current Balance']/following-sibling::td";
	private final String descriptionValue = "//td[text()='Description']/following-sibling::td";
	// Message
	private final String depositSuccessMessage = "//p[@class='heading3']";
	private final String submitButton = "//input[@type='submit']";

	public DepositPage(WebDriver driver) {
		super(driver);
	}

	public WithdrawPage clickToWithdrawalLink() {
		clickToElement(withdrawalLink);
		return new WithdrawPage(getDriver());
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

	public boolean isDepositSuccessMessageDisplayed() {
		return isElementDisplayed(depositSuccessMessage);
	}

	public String getDepositSuccessMessage() {
		return getTextElement(depositSuccessMessage);
	}

	public String getCurrentBalanceValueAfterDeposit() {
		return getTextElement(currentBalanceValue);
	}

	public String getDescriptionValueAfterDeposit() {
		return getTextElement(descriptionValue);
	}
}
