package com.bankguru.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class NewCustomerPage extends BasePage {

	private final String nameTextBox = "//input[@name='name']";
	private final String dobTextBox = "//input[@name='dob']";
	private final String addressTextArea = "//textarea[@name='addr']";
	private final String cityTextBox = "//input[@name='city']";
	private final String stateTextBox = "//input[@name='state']";
	private final String pinTextBox = "//input[@name='pinno']";
	private final String mobileTextBox = "//input[@name='telephoneno']";
	private final String emailTextBox = "//input[@name='emailid']";
	private final String passwordTextBox = "//input[@name='password']";
	// Name field
	private final String nameLabel = "//input[@name='name']/parent::td/preceding-sibling::td";
	private final String addressLabel = "//textarea[@name='addr']/parent::td/preceding-sibling::td";
	private final String cityLabel = "//input[@name='city']/parent::td/preceding-sibling::td";
	private final String stateLabel = "//input[@name='state']/parent::td/preceding-sibling::td";
	private final String pinLabel = "//input[@name='pinno']/parent::td/preceding-sibling::td";
	private final String mobileLabel = "//input[@name='telephoneno']/parent::td/preceding-sibling::td";
	private final String emailLabel = "//input[@name='emailid']/parent::td/preceding-sibling::td";
	// Error message
	private final String nameErrorMessage = "//label[@id='message']";
	private final String addressErrorMessage = "//label[@id='message3']";
	private final String cityErrorMessage = "//label[@id='message4']";
	private final String stateErrorMessage = "//label[@id='message5']";
	private final String pinErrorMessage = "//label[@id='message6']";
	private final String mobileErrorMessage = "//label[@id='message7']";
	private final String emailErrorMessage = "//label[@id='message9']";
	// Value after create success
	private final String registerSuccessMessage = "//p[@class='heading3']";
	private final String customerIDValue = "//td[text()='Customer ID']/following-sibling::td";
	private final String customerNameValue = "//td[text()='Customer Name']/following-sibling::td";
	private final String birthdateValue = "//td[text()='Birthdate']/following-sibling::td";
	private final String addressValue = "//td[text()='Address']/following-sibling::td";
	private final String cityValue = "//td[text()='City']/following-sibling::td";
	private final String stateValue = "//td[text()='State']/following-sibling::td";
	private final String pinValue = "//td[text()='Pin']/following-sibling::td";
	private final String mobileValue = "//td[text()='Mobile No.']/following-sibling::td";
	private final String emailValue = "//td[text()='Email']/following-sibling::td";
	
	private final String submitButton = "//input[@name='sub']";

	public NewCustomerPage(WebDriver driver) {
		super(driver);
	}

	public NewCustomerPage getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPage(driver);
	}

	public void pressTabToNameTextBox() {
		sendKeyboardToElement(nameTextBox, Keys.TAB);
	}

	public void pressTabToAddressTextArea() {
		sendKeyboardToElement(addressTextArea, Keys.TAB);
	}

	public void pressTabToCityTextBox() {
		sendKeyboardToElement(cityTextBox, Keys.TAB);
	}

	public void pressTabToStateTextBox() {
		sendKeyboardToElement(stateTextBox, Keys.TAB);
	}

	public void pressTabToPinTextBox() {
		sendKeyboardToElement(pinTextBox, Keys.TAB);
	}

	public void pressTabToMobileTextBox() {
		sendKeyboardToElement(mobileTextBox, Keys.TAB);
	}

	public void pressTabToEmailTextBox() {
		sendKeyboardToElement(emailTextBox, Keys.TAB);
	}

	public void typeDataToNameTextBox(String data) {
		sendKeysToElement(nameTextBox, data);
	}

	public void typeDataToDateOfBirthTextBox(String data) {
		removeAttributeByJS(dobTextBox, "type");
		sendKeysToElement(dobTextBox, data);
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

	public void typeDataToPasswordTextBox(String data) {
		sendKeysToElement(passwordTextBox, data);
	}

	public String getNameLabel() {
		return getTextElement(nameLabel);
	}

	public String getAddressLabel() {
		return getTextElement(addressLabel);
	}

	public String getCityLabel() {
		return getTextElement(cityLabel);
	}

	public String getStateLabel() {
		return getTextElement(stateLabel);
	}

	public String getPinLabel() {
		return getTextElement(pinLabel);
	}

	public String getMobileLabel() {
		return getTextElement(mobileLabel);
	}

	public String getEmailLabel() {
		return getTextElement(emailLabel);
	}

	public boolean isNameErrorMessageDisplayed() {
		return isElementDisplayed(nameErrorMessage);
	}

	public boolean isAddressErrorMessageDisplayed() {
		return isElementDisplayed(addressErrorMessage);
	}

	public boolean isCityErrorMessageDisplayed() {
		return isElementDisplayed(cityErrorMessage);
	}

	public boolean isStateErrorMessageDisplayed() {
		return isElementDisplayed(stateErrorMessage);
	}

	public boolean isPinErrorMessageDisplayed() {
		return isElementDisplayed(pinErrorMessage);
	}

	public boolean isMobileErrorMessageDisplayed() {
		return isElementDisplayed(mobileErrorMessage);
	}

	public boolean isEmailErrorMessageDisplayed() {
		return isElementDisplayed(emailErrorMessage);
	}

	public boolean isRegisteredSuccessMessageDisplayed() {
		return isElementDisplayed(registerSuccessMessage);
	}

	public String getNameErrorMessage() {
		return getTextElement(nameErrorMessage);
	}

	public String getAddressErrorMessage() {
		return getTextElement(addressErrorMessage);
	}

	public String getCityErrorMessage() {
		return getTextElement(cityErrorMessage);
	}

	public String getStateErrorMessage() {
		return getTextElement(stateErrorMessage);
	}

	public String getPinErrorMessage() {
		return getTextElement(pinErrorMessage);
	}

	public String getMobileErrorMessage() {
		return getTextElement(mobileErrorMessage);
	}

	public String getEmailErrorMessage() {
		return getTextElement(emailErrorMessage);
	}

	public String getRegisteredSuccessMessage() {
		return getTextElement(registerSuccessMessage);
	}

	public String getCustomerIDValue() {
		return getTextElement(customerIDValue);
	}

	public String getCustomerNameValueAfterCreate() {
		return getTextElement(customerNameValue);
	}

	public String getDateOfBirthValueAfterCreate() {
		return getTextElement(birthdateValue);
	}
	
	public String getAddressValueAfterCreate() {
		return getTextElement(addressValue);
	}
	
	public String getCityValueAfterCreate() {
		return getTextElement(cityValue);
	}
	
	public String getStateValueAfterCreate() {
		return getTextElement(stateValue);
	}
	
	public String getPinValueAfterCreate() {
		return getTextElement(pinValue);
	}
	
	public String getMobileValueAfterCreate() {
		return getTextElement(mobileValue);
	}

	public String getEmailValueAfterCreate() {
		return getTextElement(emailValue);
	}

	public void clickSubmitButton() {
		clickToElement(submitButton);
	}

}
