package com.framework.pageobjects;

import com.framework.utilities.LoggerUtility;
import com.framework.utilities.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private final WebDriver driver;
	private final WaitHelper waitHelper;

	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.waitHelper = new WaitHelper(driver);
		PageFactory.initElements(driver, this);
		LoggerUtility.info("LoginPage initialized.");
	}

	public void enterUsername(String username) {
		LoggerUtility.info("Action: Entering username in the field.");
		waitHelper.waitForElementToBeVisible(usernameField, 10);
		LoggerUtility.info("Username field is visible.");
		usernameField.sendKeys(username);
		LoggerUtility.info("Entered username: " + username);
	}

	public void enterPassword(String password) {
		LoggerUtility.info("Action: Entering password in the field.");
		waitHelper.waitForElementToBeVisible(passwordField, 10);
		LoggerUtility.info("Password field is visible.");
		passwordField.sendKeys(password);
		LoggerUtility.info("Entered password.");
	}

	public void clickLoginButton() {
		LoggerUtility.info("Action: Clicking the login button.");
		waitHelper.waitForElementToBeClickable(loginButton, 10);
		LoggerUtility.info("Login button is clickable.");
		loginButton.click();
		LoggerUtility.info("Clicked the login button.");
	}

	public LoginPage validateLogin(String username, String password) {
		LoggerUtility.info("Validating login with username: " + username);
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
		LoggerUtility.info("Login validation completed.");
		return this;
	}
}
