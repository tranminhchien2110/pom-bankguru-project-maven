package com.bankguru.customer;

import org.testng.annotations.Test;

import com.bankguru.base.BaseTest;
import com.bankguru.data.Data;
import com.bankguru.pages.NewCustomerPage;

public class NewCustomer extends BaseTest {

	private NewCustomerPage newCustomterPage;

	@Test
	public void NC01_NameCannotBeEmpty() {
		newCustomterPage = homePage.clickToNewCustomerLink();
		newCustomterPage.pressTabToNameTextBox();
		verifyTrue(newCustomterPage.isNameErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getNameErrorMessage(), Data.NameMustNotBeBlank);
	}

	@Test
	public void NC02_NameCannotBeNumberic() {
		newCustomterPage.typeDataToNameTextBox("1234");
		verifyTrue(newCustomterPage.isNameErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getNameErrorMessage(), Data.NumbersAreNotAllowed);

		newCustomterPage.typeDataToNameTextBox("name1234");
		verifyTrue(newCustomterPage.isNameErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getNameErrorMessage(), Data.NumbersAreNotAllowed);
	}

	@Test
	public void NC03_NameCannotHaveSpecialCharacters() {
		newCustomterPage.typeDataToNameTextBox("name!@#");
		verifyTrue(newCustomterPage.isNameErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getNameErrorMessage(), Data.SpecialCharsAreNotAllowed);

		newCustomterPage.typeDataToNameTextBox("!@#");
		verifyTrue(newCustomterPage.isNameErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getNameErrorMessage(), Data.SpecialCharsAreNotAllowed);
	}

	@Test
	public void NC04_NameCannotHaveFirstCharacterAsBlankSpace() {
		newCustomterPage.typeDataToNameTextBox(" ");
		verifyTrue(newCustomterPage.isNameErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getNameErrorMessage(), Data.FirstCharCanNotHaveSpace);
	}

	@Test
	public void NC05_AddressCannotBeEmpty() {
		newCustomterPage.pressTabToAddressTextArea();
		verifyTrue(newCustomterPage.isAddressErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getAddressErrorMessage(), Data.AddressFieldMustNotBeBlank);
	}

	@Test
	public void NC06_AddressCannotHaveFirstCharacterAsBlankSpace() {
		newCustomterPage.typeDataToAddressTextArea(" ");
		verifyTrue(newCustomterPage.isAddressErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getAddressErrorMessage(), Data.FirstCharCanNotHaveSpace);
	}

	@Test
	public void NC08_CityCannotBeEmpty() {
		newCustomterPage.pressTabToCityTextBox();
		verifyTrue(newCustomterPage.isCityErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getCityErrorMessage(), Data.CityFieldMustNotBeBlank);
	}

	@Test
	public void NC09_CityCannotBeNumberic() {
		newCustomterPage.typeDataToCityTextBox("1234");
		verifyTrue(newCustomterPage.isCityErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getCityErrorMessage(), Data.NumbersAreNotAllowed);

		newCustomterPage.typeDataToCityTextBox("city123");
		verifyTrue(newCustomterPage.isCityErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getCityErrorMessage(), Data.NumbersAreNotAllowed);
	}

	@Test
	public void NC10_CityCannotHaveSpecialCharacters() {
		newCustomterPage.typeDataToCityTextBox("city!@#");
		verifyTrue(newCustomterPage.isCityErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getCityErrorMessage(), Data.SpecialCharsAreNotAllowed);

		newCustomterPage.typeDataToCityTextBox("!@#");
		verifyTrue(newCustomterPage.isCityErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getCityErrorMessage(), Data.SpecialCharsAreNotAllowed);
	}

	@Test
	public void NC11_CityCannotHaveFirstCharacterAsBlankSpace() {
		newCustomterPage.typeDataToCityTextBox(" ");
		verifyTrue(newCustomterPage.isCityErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getCityErrorMessage(), Data.FirstCharCanNotHaveSpace);
	}

	@Test
	public void NC12_StateCannotBeEmpty() {
		newCustomterPage.pressTabToStateTextBox();
		verifyTrue(newCustomterPage.isStateErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getStateErrorMessage(), Data.StateMustNotBeBlank);
	}

	@Test
	public void NC13_StateCannotBeNumberic() {
		newCustomterPage.typeDataToStateTextBox("1234");
		verifyTrue(newCustomterPage.isStateErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getStateErrorMessage(), Data.NumbersAreNotAllowed);

		newCustomterPage.typeDataToStateTextBox("state123");
		verifyTrue(newCustomterPage.isStateErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getStateErrorMessage(), Data.NumbersAreNotAllowed);
	}

	@Test
	public void NC14_StateCannotHaveSpecialCharacters() {
		newCustomterPage.typeDataToStateTextBox("state!@#");
		verifyTrue(newCustomterPage.isStateErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getStateErrorMessage(), Data.SpecialCharsAreNotAllowed);

		newCustomterPage.typeDataToStateTextBox("!@#");
		verifyTrue(newCustomterPage.isStateErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getStateErrorMessage(), Data.SpecialCharsAreNotAllowed);
	}

	@Test
	public void NC15_StateCannotHaveFirstCharacterAsBlankSpace() {
		newCustomterPage.typeDataToStateTextBox(" ");
		verifyTrue(newCustomterPage.isStateErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getStateErrorMessage(), Data.FirstCharCanNotHaveSpace);
	}

	@Test
	public void NC16_PinCannotBeEmpty() {
		newCustomterPage.pressTabToPinTextBox();
		verifyTrue(newCustomterPage.isPinErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getPinErrorMessage(), Data.PinMustNotBeBlank);
	}

	@Test
	public void NC17_PinMustBeNumberic() {
		newCustomterPage.typeDataToPinTextBox("1234pin");
		verifyTrue(newCustomterPage.isPinErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getPinErrorMessage(), Data.CharsAreNotAllowed);
	}

	@Test
	public void NC18_PinMustHave6Digits() {
		newCustomterPage.typeDataToPinTextBox("1234");
		verifyTrue(newCustomterPage.isPinErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getPinErrorMessage(), Data.PinCodeMustHave6Digits);
	}

	@Test
	public void NC19_PinCannotHaveSpecialCharacters() {
		newCustomterPage.typeDataToPinTextBox("123!@#");
		verifyTrue(newCustomterPage.isPinErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getPinErrorMessage(), Data.SpecialCharsAreNotAllowed);

		newCustomterPage.typeDataToPinTextBox("!@#");
		verifyTrue(newCustomterPage.isPinErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getPinErrorMessage(), Data.SpecialCharsAreNotAllowed);
	}

	@Test
	public void NC20_PinCannotHaveFirstCharacterAsBlankSpace() {
		newCustomterPage.typeDataToPinTextBox(" 123");
		verifyTrue(newCustomterPage.isPinErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getPinErrorMessage(), Data.FirstCharCanNotHaveSpace);
	}

	@Test
	public void NC21_PinCannotHaveBlankSpace() {
		newCustomterPage.typeDataToPinTextBox("12 3");
		verifyTrue(newCustomterPage.isPinErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getPinErrorMessage(), Data.CharsAreNotAllowed);
	}

	@Test
	public void NC22_MobileCannotBeEmpty() {
		newCustomterPage.pressTabToMobileTextBox();
		verifyTrue(newCustomterPage.isMobileErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getMobileErrorMessage(), Data.MobileMustNotBeBlank);
	}

	@Test
	public void NC23_MobileCannotHaveFirstCharacterAsBlankSpace() {
		newCustomterPage.typeDataToMobileTextBox(" 123");
		verifyTrue(newCustomterPage.isMobileErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getMobileErrorMessage(), Data.FirstCharCanNotHaveSpace);
	}

	@Test
	public void NC24_MobileCannotHaveBlankSpace() {
		newCustomterPage.typeDataToMobileTextBox("12 34");
		verifyTrue(newCustomterPage.isMobileErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getMobileErrorMessage(), Data.CharsAreNotAllowed);
	}

	@Test
	public void NC25_MobileCannotHaveSpecialCharacters() {
		newCustomterPage.typeDataToMobileTextBox("123!@#45");
		verifyTrue(newCustomterPage.isMobileErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getMobileErrorMessage(), Data.SpecialCharsAreNotAllowed);

		newCustomterPage.typeDataToMobileTextBox("!@#1234");
		verifyTrue(newCustomterPage.isMobileErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getMobileErrorMessage(), Data.SpecialCharsAreNotAllowed);
	}

	@Test
	public void NC26_EmailCannotBeEmpty() {
		newCustomterPage.pressTabToEmailTextBox();
		verifyTrue(newCustomterPage.isEmailErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getEmailErrorMessage(), Data.EmailIdMustNotBeBlank);
	}

	@Test
	public void NC27_EmailMustBeInCorrectFormat() {
		newCustomterPage.typeDataToEmailTextBox("guru99@gmail");
		verifyTrue(newCustomterPage.isEmailErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getEmailErrorMessage(), Data.EmailIdIsNotValid);

		newCustomterPage.typeDataToEmailTextBox("guru99");
		verifyTrue(newCustomterPage.isEmailErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getEmailErrorMessage(), Data.EmailIdIsNotValid);

		newCustomterPage.typeDataToEmailTextBox("guru99@");
		verifyTrue(newCustomterPage.isEmailErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getEmailErrorMessage(), Data.EmailIdIsNotValid);

		newCustomterPage.typeDataToEmailTextBox("guru99@gmail.");
		verifyTrue(newCustomterPage.isEmailErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getEmailErrorMessage(), Data.EmailIdIsNotValid);

		newCustomterPage.typeDataToEmailTextBox("guru99gmail.com");
		verifyTrue(newCustomterPage.isEmailErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getEmailErrorMessage(), Data.EmailIdIsNotValid);
	}

	@Test
	public void NC29_MobileCannotHaveFirstCharacterAsBlankSpace() {
		newCustomterPage.typeDataToEmailTextBox(" ");
		verifyTrue(newCustomterPage.isEmailErrorMessageDisplayed());
		verifyEquals(newCustomterPage.getEmailErrorMessage(), Data.FirstCharCanNotHaveSpace);
	}

	@Test
	public void NC30_VerifyFieldLabels() {
		verifyEquals(newCustomterPage.getNameLabel(), Data.NameLabel);
		verifyEquals(newCustomterPage.getAddressLabel(), Data.AddressLabel);
		verifyEquals(newCustomterPage.getCityLabel(), Data.CityLabel);
		verifyEquals(newCustomterPage.getStateLabel(), Data.StateLabel);
		verifyEquals(newCustomterPage.getPinLabel(), Data.PinLabel);
		verifyEquals(newCustomterPage.getMobileLabel(), Data.MobileLabel);
		verifyEquals(newCustomterPage.getEmailLabel(), Data.EmailLabel);
	}

	@Test
	public void NC31_CreateNewCustomer() {
		newCustomterPage.typeDataToNameTextBox(Data.fullName);
		newCustomterPage.typeDataToDateOfBirthTextBox(Data.dateOfBirth);
		newCustomterPage.typeDataToAddressTextArea(Data.address);
		newCustomterPage.typeDataToCityTextBox(Data.city);
		newCustomterPage.typeDataToStateTextBox(Data.state);
		newCustomterPage.typeDataToPinTextBox(Data.pin);
		newCustomterPage.typeDataToMobileTextBox(Data.mobile);
		newCustomterPage.typeDataToEmailTextBox(Data.email);
		newCustomterPage.typeDataToPasswordTextBox(Data.PASSWORD);
		newCustomterPage.clickSubmitButton();

		verifyTrue(newCustomterPage.isRegisteredSuccessMessageDisplayed());

		verifyEquals(newCustomterPage.getRegisteredSuccessMessage(), Data.CustomerRegisteredSuccess);
		verifyEquals(newCustomterPage.getCustomerNameValueAfterCreate(), Data.fullName);
		verifyEquals(newCustomterPage.getDateOfBirthValueAfterCreate(), Data.dateOfBirth.replace("/", "-"));
		verifyEquals(newCustomterPage.getAddressValueAfterCreate(), Data.address);
		verifyEquals(newCustomterPage.getCityValueAfterCreate(), Data.city);
		verifyEquals(newCustomterPage.getStateValueAfterCreate(), Data.state);
		verifyEquals(newCustomterPage.getPinValueAfterCreate(), Data.pin);
		verifyEquals(newCustomterPage.getMobileValueAfterCreate(), Data.mobile);
		verifyEquals(newCustomterPage.getEmailValueAfterCreate(), Data.email);

		Data.CustomerIdValue = newCustomterPage.getCustomerIDValue();
	}
}
