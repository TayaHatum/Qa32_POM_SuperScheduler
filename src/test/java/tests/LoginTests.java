package tests;


import configuration.AppiumConfiguration;
import configuration.MyDataProvider;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfiguration {

    @Test
    public void loginSuccess(){
//
//        boolean isFabButtonPresent = new SplashScreen(driver)
//                .checkVersion("0.0.3")
        boolean isFabButtonPresent =new LoginScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isFabPlusPresent();

        Assert.assertTrue(isFabButtonPresent);


        new HomeScreen(driver)
                .openMenu()
                .logout();

    }

    @Test (dataProvider = "loginData",dataProviderClass = MyDataProvider.class)
    public void loginSuccessHomeWork(Auth auth){

        logger.info("From Login Test: test start with data:   "  + auth.toString());
        new LoginScreen(driver)
                .complexLogin(auth)
                .checkFabButtonPresent()
                .openMenu()
                .logout();

    }
    @Test (dataProvider = "loginDataCSV",dataProviderClass = MyDataProvider.class)
    public void loginSuccessHomeWork2(Auth auth){
        //Auth auth = Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build();
        logger.info("From Login Test: test start with data:   "  + auth.toString());

      new LoginScreen(driver).
                complexLogin(auth)
              .checkFabButtonPresent()
              .openMenu()
              .logout();

    }

    @Test  /// wick@gmail.com Nnoa12345$  ---> wrong email or password
    public void loginCheckErrorMessage(){

        new LoginScreen(driver)
                .fillPassword("wick@gmail.com")
                .fillEmail("Nnoa12345$")
                .submitLoginNegative()
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage();

    }

    @Test
    public void loginComplexCheckErrorMessage(){
        boolean isLoginBtnPresent= new LoginScreen(driver)
                .complexLoginWithErrorExeption(Auth.builder().email("wick@gmail.com").password("Nnoa12345$").build())
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage()
                .isLoginButtonPresent();

        Assert.assertTrue(isLoginBtnPresent);
    }

    @AfterMethod (enabled = false)
    public void  postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}
