package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class FundTransferPage extends BasePage {

	private final String balanceEnquiryLink = "//a[text()='Balance Enquiry']";
	private final String payersAccountNumberTextBox = "//input[@name='payersaccount']";
	private final String payeesAccountNumberTextBox = "//input[@name='payeeaccount']";
	private final String amountTextBox = "//input[@name='ammount']";
	private final String descriptionTextBox = "//input[@name='desc']";
	// Value after withdraw
	private final String fromAccountValue = "//td[text()='From Account Number']/following-sibling::td";
	private final String toAccountValue = "//td[text()='To Account Number']/following-sibling::td";
	private final String amountValue = "//td[text()='Amount']/following-sibling::td";
	private final String descriptionValue = "//td[text()='Description']/following-sibling::td";
	// Message
	private final String withdrawSuccessMessage = "//p[@class='heading3']";
	private final String submitButton = "//input[@value='Submit']";

	public FundTransferPage(WebDriver driver) {
		super(driver);
	}

	public BalanceEnquiryPage clickToBalanceEnquiryLink() {
		clickToElement(balanceEnquiryLink);
		return new BalanceEnquiryPage(getDriver());
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public void typeDataToPayersAccountNumberTextBox(String data) {
		sendKeysToElement(payersAccountNumberTextBox, data);
	}

	public void typeDataToPayeesAccountNumberTextBox(String data) {
		sendKeysToElement(payeesAccountNumberTextBox, data);
	}

	public void typeDataToAmountTextBox(String data) {
		sendKeysToElement(amountTextBox, data);
	}

	public void typeDataToDescriptionTextBox(String data) {
		sendKeysToElement(descriptionTextBox, data);
	}

	public boolean isTrasnferSuccessMessageDisplayed() {
		return isElementDisplayed(withdrawSuccessMessage);
	}

	public String getTransferSuccessMessage() {
		return getTextElement(withdrawSuccessMessage);
	}

	public String getFromAccountAfterTransfer() {
		return getTextElement(fromAccountValue);
	}

	public String getToAccountAfterTransfer() {
		return getTextElement(toAccountValue);
	}

	public String getAmountAfterTransfer() {
		return getTextElement(amountValue);
	}

	public String getDescriptionAfterTransfer() {
		return getTextElement(descriptionValue);
	}

}
