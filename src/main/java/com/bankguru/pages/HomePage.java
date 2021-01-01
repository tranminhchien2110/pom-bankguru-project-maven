package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class HomePage extends BasePage {

	private final String newCustomerLink = "//a[text()='New Customer']";
	private final String editCustomerLink = "//a[text()='Edit Customer']";
	private final String newAccountLink = "//a[text()='New Account']";
	private final String welcomeMessage = "//marquee[@class='heading3']";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public static HomePage getHomePage(WebDriver driver) {
		return new HomePage(driver);
	}

	public boolean isWelcomeMessageIsDisplayed() {
		return isElementDisplayed(welcomeMessage);
	}

	public NewCustomerPage clickToNewCustomerLink() {
		clickToElement(newCustomerLink);
		return new NewCustomerPage(getDriver());
	}

	public EditCustomerPage clickToEditCustomerLink() {
		clickToElement(editCustomerLink);
		return new EditCustomerPage(getDriver());
	}

	public NewAccountPage clickToNewAccountLink() {
		clickToElement(newAccountLink);
		return new NewAccountPage(getDriver());
	}
}
