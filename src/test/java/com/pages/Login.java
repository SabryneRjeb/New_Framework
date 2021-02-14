package com.pages;

import com.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Driver;


public class Login {

    // This constructor is calling this Class (Login)
    public Login() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // All required elements in order to login as follows:
    @FindBy(id = "user")
    public WebElement usernameInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "submit-form")
    public WebElement logInButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMessage;

    // Master call for both correct credentials and wrong credentials. All you have to do is change the parameter
    // value the way you want it.
    public void loginFunctionality(String environment, String username, String password ) {
        Driver.getDriver().get(ConfigurationReader.getProperty(environment));
        usernameInputBox.sendKeys(ConfigurationReader.getProperty(username));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty(password));
        logInButton.click();
    }
}