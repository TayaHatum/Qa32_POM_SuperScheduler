package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTests extends AppiumConfiguration {

    @Test
    public void registrationSuccess() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new LoginScreen(driver).
                complexRegistration(Auth.builder().email("noa"+i+"@gmail.com").password("Nnoa12345$").build())
                .skipWizard()
                .checkFabButtonPresent()
                .openMenu()
                .logout();
    }

   @Test ///  ?????
   public void loginRegistrationSuccess(){

        new LoginScreen(driver)
                .complex(Auth.builder().email("noa05@gmail.com").password("Nnoa12345$").build())
                .skipIfWizard()
                .checkFabButtonPresent()
               .openMenu()
               .logout();
    }

}
