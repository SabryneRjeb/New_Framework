package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(){
      PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user")
    public WebElement usernameInputBox;
    @FindBy(id = "password")
    public WebElement passwordInputBox;
    @FindBy(id = "submit-form")
    public WebElement logInButton;
    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMessage;
}
