package com.bankguru.data;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Data {
	private static Locale locale = new Locale("en");
	private static Faker faker = new Faker(locale);

	public static final String USER_ID = "mngr292630";
	public static final String PASSWORD = "uhemUjE";
	public static final String BANKGURU_URL = "http://demo.guru99.com/v4";
	// Error Messages
	public static final String NameMustNotBeBlank = "Customer name must not be blank";
	public static final String NumbersAreNotAllowed = "Numbers are not allowed";
	public static final String SpecialCharsAreNotAllowed = "Special characters are not allowed";
	public static final String FirstCharCanNotHaveSpace = "First character can not have space";
	public static final String AddressFieldMustNotBeBlank = "Address Field must not be blank";
	public static final String CityFieldMustNotBeBlank = "City Field must not be blank";
	public static final String StateMustNotBeBlank = "State must not be blank";
	public static final String CharsAreNotAllowed = "Characters are not allowed";
	public static final String PinMustNotBeBlank = "PIN Code must not be blank";
	public static final String PinCodeMustHave6Digits = "PIN Code must have 6 Digits";
	public static final String MobileMustNotBeBlank = "Mobile no must not be blank";
	public static final String EmailIdMustNotBeBlank = "Email-ID must not be blank";
	public static final String EmailIdIsNotValid = "Email-ID is not valid";
	public static final String CustomerRegisteredSuccess = "Customer Registered Successfully!!!";
	public static final String CustomerIdIsRequired = "Customer ID is required";
	public static final String AccountGeneratedSuccess = "Account Generated Successfully!!!";
	public static final String AccountDetailUpdatedSuccess = "Account details updated Successfully!!!";
	public static final String AccountDeletedSuccessful = "Account Deleted Sucessfully";
	public static final String CustomerDeletedSuccessful = "Customer deleted Successfully";
	public static final String AccountDoesNotExist = "Account does not exist";
	public static final String CustomerDoesNotExist = "Customer does not exist!!";
	public static final String FundTransferDetails = "Fund Transfer Details";
	public static final String TransactionDetailsOfDepositForAccount = "Transaction details of Deposit for Account ";
	public static final String TransactionDetailsOfWithdrawalForAccount = "Transaction details of Withdrawal for Account ";
	public static final String BalanceDetailsForAccount = "Balance Details for Account ";
	public static final String CustomerDetailsUpdatedSuccess = "Customer details updated Successfully!!!";
	// Name Labels
	public static final String NameLabel = "Customer Name";
	public static final String AddressLabel = "Address";
	public static final String CityLabel = "City";
	public static final String StateLabel = "State";
	public static final String PinLabel = "PIN";
	public static final String MobileLabel = "Mobile Number";
	public static final String EmailLabel = "E-mail";
	// Data to create new customer
	public static String CustomerIdValue;
	public static String AccountIdValue_1;
	public static String AccountIdValue_2;
	public static String fullName = getFullName();
	public static String dateOfBirth = getDateOfBirth();
	public static String address = getAddress();
	public static String city = getCity();
	public static String state = getState();
	public static String pin = getPin();
	public static String mobile = getMobile();
	public static String email = getEmail();
	// Data to edit customer
	public static String addressEdit = getAddress();
	public static String cityEdit = getCity();
	public static String stateEdit = getState();
	public static String pinEdit = getPin();
	public static String mobileEdit = getMobile();
	public static String emailEdit = getEmail();

	private static String getFullName() {
		return faker.name().firstName() + " " + faker.name().lastName();
	}

	private static String getDateOfBirth() {
		int year = (int) (Math.random() * (2000 - 1975) + 1975);
		int month = (int) (Math.random() * (12 - 1) + 1);
		int day = (int) (Math.random() * (29 - 1) + 1);
		if (month < 10 && day < 10)
			return year + "/0" + month + "/0" + day;
		if (month < 10)
			return year + "/0" + month + "/" + day;
		if (day < 10)
			return year + "/" + month + "/0" + day;
		return year + "/" + month + "/" + day;
	}

	private static String getAddress() {
		return faker.address().streetAddress();
	}

	private static String getCity() {
		return faker.address().city();
	}

	private static String getState() {
		return faker.address().state();
	}

	private static String getPin() {
		return (int) (Math.random() * (999999 - 100000) + 100000) + "";
	}

	private static String getMobile() {
		return faker.phoneNumber().subscriberNumber(10) + "";
	}

	private static String getEmail() {
		return faker.name().firstName().toLowerCase() + faker.phoneNumber().subscriberNumber(4) + "@" + faker.name().firstName().toLowerCase() + ".com";
	}
}
