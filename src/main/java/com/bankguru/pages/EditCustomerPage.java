package com.bankguru.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class EditCustomerPage extends BasePage {

	private final String customerIdTextBox = "//input[@name='cusid']";
	private final String nameTextBox = "//input[@name='name']";
	private final String dobTextBox = "//input[@name='dob']";
	private final String addressTextArea = "//textarea[@name='addr']";
	private final String cityTextBox = "//input[@name='city']";
	private final String stateTextBox = "//input[@name='state']";
	private final String pinTextBox = "//input[@name='pinno']";
	private final String mobileTextBox = "//input[@name='telephoneno']";
	private final String emailTextBox = "//input[@name='emailid']";
	// Message
	private final String editCustomerSuccessMessage = "//p[@class='heading3']";
	private final String customerIdErrorMessage = "//label[@id='message14']";
	// Value after edit success
	private final String customerNameValue = "//td[text()='Customer Name']/following-sibling::td";
	private final String birthdateValue = "//td[text()='Birthdate']/following-sibling::td";
	private final String addressValue = "//td[text()='Address']/following-sibling::td";
	private final String cityValue = "//td[text()='City']/following-sibling::td";
	private final String stateValue = "//td[text()='State']/following-sibling::td";
	private final String pinValue = "//td[text()='Pin']/following-sibling::td";
	private final String mobileValue = "//td[text()='Mobile No.']/following-sibling::td";
	private final String emailValue = "//td[text()='Email']/following-sibling::td";
	private final String submitButton = "//input[@type='submit']";

	public EditCustomerPage(WebDriver driver) {
		super(driver);
	}

	public EditCustomerPage getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPage(driver);
	}

	public void pressTabToCustomerIdTextBox() {
		sendKeyboardToElement(customerIdTextBox, Keys.TAB);
	}

	public void typeDataToCustomerIdTextBox(String data) {
		sendKeysToElement(customerIdTextBox, data);
	}

	public void typeDataToAddressTextArea(String data) {
		sendKeysToElement(addressTextArea, data);
	}

	public void typeDataToCityTextBox(String data) {
		sendKeysToElement(cityTextBox, data);
	}

	public void typeDataToStateTextBox(String data) {
		sendKeysToElement(stateTextBox, data);
	}

	public void typeDataToPinTextBox(String data) {
		sendKeysToElement(pinTextBox, data);
	}

	public void typeDataToMobileTextBox(String data) {
		sendKeysToElement(mobileTextBox, data);
	}

	public void typeDataToEmailTextBox(String data) {
		sendKeysToElement(emailTextBox, data);
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

	public boolean isEditCustomerSuccessMessageDisplayed() {
		return isElementDisplayed(editCustomerSuccessMessage);
	}

	public boolean isCustomerIdErrorMessageDisplayed() {
		return isElementDisplayed(customerIdErrorMessage);
	}

	public String getCustomerIdErrorMessage() {
		return getTextElement(customerIdErrorMessage);
	}

	public String getEditCustomerSuccessMessage() {
		return getTextElement(editCustomerSuccessMessage);
	}

	public String getCustomerNameValueBeforeEdit() {
		return getAttributeElement(nameTextBox, "value");
	}

	public String getDateOfBirthValueBeforeEdit() {
		return getAttributeElement(dobTextBox, "value");
	}

	public String getAddressValueBeforeEdit() {
		return getTextElement(addressTextArea);
	}

	public String getCityValueBeforeEdit() {
		return getAttributeElement(cityTextBox, "value");
	}

	public String getStateValueBeforeEdit() {
		return getAttributeElement(stateTextBox, "value");
	}

	public String getPinValueBeforeEdit() {
		return getAttributeElement(pinTextBox, "value");
	}

	public String getMobileValueBeforeEdit() {
		return getAttributeElement(mobileTextBox, "value");
	}

	public String getEmailValueBeforeEdit() {
		return getAttributeElement(emailTextBox, "value");
	}

	public String getCustomerNameValueAfterEdit() {
		return getTextElement(customerNameValue);
	}

	public String getDateOfBirthValueAfterEdit() {
		return getTextElement(birthdateValue);
	}

	public String getAddressValueAfterEdit() {
		return getTextElement(addressValue);
	}

	public String getCityValueAfterEdit() {
		return getTextElement(cityValue);
	}

	public String getStateValueAfterEdit() {
		return getTextElement(stateValue);
	}

	public String getPinValueAfterEdit() {
		return getTextElement(pinValue);
	}

	public String getMobileValueAfterEdit() {
		return getTextElement(mobileValue);
	}

	public String getEmailValueAfterEdit() {
		return getTextElement(emailValue);
	}

	public String getCustomerNotExistMessage() {
		return getTextFromAlert();
	}
	
}
