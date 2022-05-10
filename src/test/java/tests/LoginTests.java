package tests;


import configuration.AppiumConfiguration;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends AppiumConfiguration {

    @Test
    public void loginSuccess(){

        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin();

    }

    @Test
    public void loginSuccessHomeWork(){

    }
}
