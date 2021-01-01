package com.bankguru.customer;

import org.testng.annotations.Test;

import com.bankguru.base.BaseTest;
import com.bankguru.data.Data;
import com.bankguru.pages.EditCustomerPage;

public class EditCustomer extends BaseTest {

	private EditCustomerPage editCustomerPage;

	@Test
	public void EC01_CustomerIdCannotBeEmpty() {
		editCustomerPage = homePage.clickToEditCustomerLink();
		editCustomerPage.pressTabToCustomerIdTextBox();
		verifyTrue(editCustomerPage.isCustomerIdErrorMessageDisplayed());
		verifyEquals(editCustomerPage.getCustomerIdErrorMessage(), Data.CustomerIdIsRequired);
	}

	@Test
	public void EC02_CustomerIdMustBeNumberic() {
		editCustomerPage.typeDataToCustomerIdTextBox("123acc");
		verifyTrue(editCustomerPage.isCustomerIdErrorMessageDisplayed());
		verifyEquals(editCustomerPage.getCustomerIdErrorMessage(), Data.CharsAreNotAllowed);

		editCustomerPage.typeDataToCustomerIdTextBox("123acc");
		verifyTrue(editCustomerPage.isCustomerIdErrorMessageDisplayed());
		verifyEquals(editCustomerPage.getCustomerIdErrorMessage(), Data.CharsAreNotAllowed);
	}

	@Test
	public void EC03_CustomerIdCannotHaveSpecialCharacter() {
		editCustomerPage.typeDataToCustomerIdTextBox("123!@#");
		verifyTrue(editCustomerPage.isCustomerIdErrorMessageDisplayed());
		verifyEquals(editCustomerPage.getCustomerIdErrorMessage(), Data.SpecialCharsAreNotAllowed);

		editCustomerPage.typeDataToCustomerIdTextBox("!@#123");
		verifyTrue(editCustomerPage.isCustomerIdErrorMessageDisplayed());
		verifyEquals(editCustomerPage.getCustomerIdErrorMessage(), Data.SpecialCharsAreNotAllowed);
	}

	@Test
	public void EC04_CustomerIdWithValidValue() {
		editCustomerPage.typeDataToCustomerIdTextBox(Data.CustomerIdValue);
		editCustomerPage.clickSubmitButton();

		verifyTrue(editCustomerPage.isEditCustomerSuccessMessageDisplayed());

		verifyEquals(editCustomerPage.getCustomerNameValueBeforeEdit(), Data.fullName);
		verifyEquals(editCustomerPage.getDateOfBirthValueBeforeEdit(), Data.dateOfBirth.replace("/", "-"));
		verifyEquals(editCustomerPage.getAddressValueBeforeEdit(), Data.address);
		verifyEquals(editCustomerPage.getCityValueBeforeEdit(), Data.city);
		verifyEquals(editCustomerPage.getStateValueBeforeEdit(), Data.state);
		verifyEquals(editCustomerPage.getPinValueBeforeEdit(), Data.pin);
		verifyEquals(editCustomerPage.getMobileValueBeforeEdit(), Data.mobile);
		verifyEquals(editCustomerPage.getEmailValueBeforeEdit(), Data.email);
	}

	@Test
	public void EC05_EditCustomer() {
		editCustomerPage.typeDataToAddressTextArea(Data.addressEdit);
		editCustomerPage.typeDataToCityTextBox(Data.cityEdit);
		editCustomerPage.typeDataToStateTextBox(Data.stateEdit);
		editCustomerPage.typeDataToPinTextBox(Data.pinEdit);
		editCustomerPage.typeDataToMobileTextBox(Data.mobileEdit);
		editCustomerPage.typeDataToEmailTextBox(Data.emailEdit);
		editCustomerPage.clickSubmitButton();

		verifyTrue(editCustomerPage.isEditCustomerSuccessMessageDisplayed());

		verifyEquals(editCustomerPage.getEditCustomerSuccessMessage(), Data.CustomerDetailsUpdatedSuccess);
		verifyEquals(editCustomerPage.getCustomerNameValueAfterEdit(), Data.fullName);
		verifyEquals(editCustomerPage.getDateOfBirthValueAfterEdit(), Data.dateOfBirth.replace("/", "-"));
		verifyEquals(editCustomerPage.getAddressValueAfterEdit(), Data.addressEdit);
		verifyEquals(editCustomerPage.getCityValueAfterEdit(), Data.cityEdit);
		verifyEquals(editCustomerPage.getStateValueAfterEdit(), Data.stateEdit);
		verifyEquals(editCustomerPage.getPinValueAfterEdit(), Data.pinEdit);
		verifyEquals(editCustomerPage.getMobileValueAfterEdit(), Data.mobileEdit);
		verifyEquals(editCustomerPage.getEmailValueAfterEdit(), Data.emailEdit);
	}

}
