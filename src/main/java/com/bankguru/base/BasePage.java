package com.bankguru.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

	public BasePage(WebDriver driver) {
		super();
		if (this.driver != driver)
			this.driver = driver;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpath(locator));
	}

	protected By byXpath(String locator) {
		return By.xpath(locator);
	}

	protected void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}

	protected void sendKeysToElement(String locator, String value) {
		findElementByXpath(locator).clear();
		findElementByXpath(locator).sendKeys(value);
	}

	protected void sendKeyboardToElement(String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(findElementByXpath(locator), key).perform();
	}

	protected void removeAttributeByJS(String locator, String attribute) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "')", findElementByXpath(locator));
	}

	protected void selectValueInDropdownList(String locator, String text) {
		select = new Select(findElementByXpath(locator));
		select.selectByVisibleText(text);
	}

	protected void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	protected boolean isElementDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}

	protected String getTextElement(String locator) {
		return findElementByXpath(locator).getText().trim();
	}

	protected String getAttributeElement(String locator, String attribute) {
		return findElementByXpath(locator).getAttribute(attribute);
	}

	protected String getTextFromAlert() {
		return driver.switchTo().alert().getText().trim();
	}

	private WebDriver driver;
	private Actions action;
	private Select select;
	private JavascriptExecutor jsExecutor;

}
