package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginScreen extends BaseScreen{

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;
    @FindBy (xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy (xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;


    public LoginScreen checkErrorMessage(String text){
        shouldHave(errorMessage,15,text);
        Assert.assertEquals(errorMessage.getText(),text);
        return this;
    }

    public boolean isLoginButtonPresent(){
        return loginButton.isDisplayed();
    }

    public LoginScreen confirmErrorMessage(){
        okBtn.click();
        return this;
    }
    public LoginScreen fillEmail(String  email){
       // pause(6000);
        should(emailEditText,15);
        type(emailEditText,email);

       // return new LoginScreen(driver);
        return this;
    }

    public LoginScreen fillPassword(String password){
  type(passwordEditText,password);
        return this;
    }

    public HomeScreen submitLogin(){
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }


    public HomeScreen complexLogin(Auth auth){

        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new HomeScreen(driver);
    }
    public WizardScreen complexRegistration(Auth auth){

        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new WizardScreen(driver);
    }


    public WizardScreen complex(Auth auth){

        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new WizardScreen(driver);
    }
    public LoginScreen submitLoginNegative(){
        driver.hideKeyboard();
        loginButton.click();

        return this;
    }
    public LoginScreen complexLoginWithErrorExeption(Auth auth){
        should(emailEditText,15);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return this;
    }
}
