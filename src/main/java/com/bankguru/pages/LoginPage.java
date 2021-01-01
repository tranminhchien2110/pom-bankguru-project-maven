package com.bankguru.pages;

import org.openqa.selenium.WebDriver;

import com.bankguru.base.BasePage;

public class LoginPage extends BasePage {

	private final String userIDTextBox = "//input[@name='uid']";
	private final String passwordTextBox = "//input[@name='password']";
	private final String loginButton = "//input[@name='btnLogin']";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public static LoginPage getLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}

	public HomePage loginToHomePage(String user, String password) {
		sendKeysToElement(userIDTextBox, user);
		sendKeysToElement(passwordTextBox, password);
		clickToElement(loginButton);
		return new HomePage(getDriver());
	}

}
