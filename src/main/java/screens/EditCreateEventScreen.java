package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Event;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EditCreateEventScreen extends BaseScreen{
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (how= How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @FindBy (how= How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @FindBy (how= How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breaksPlusBtn;
    @FindBy (how= How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @FindBy (how= How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @FindBy (how= How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @FindBy (how= How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']")
    List<MobileElement> days;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']")
    List<MobileElement> months;


    public EditCreateEventScreen actionData(){
        pause(3000);
        MobileElement elementDay = days.get(2);
        Rectangle rect = elementDay.getRect();

        logger.info("Width of last data element --->" + rect.getWidth()); //--->215
        logger.info("Height of last data element --->" + rect.getHeight());//--->218
        logger.info("The 'X' of last data element --->" + rect.getX()); //--->712
        logger.info("The 'Y' of last data element --->" + rect.getY());  //--->288

        logger.info("The width of screen --->" + driver.manage().window().getSize().getWidth()); //--->1080

        int xFrom = rect.getX()+ rect.getWidth();
        int y = rect.getY()+ rect.getHeight()/2;
        int xTo = driver.manage().window().getSize().getWidth()/2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();




        return this;
    }



    public HomeScreen createNewEvent(Event event){
        should(title,10);
        type(title, event.getTitle());
        type(type, event.getType());
        driver.hideKeyboard();

        int breaks = event.getBreaks();

        if(breaks>0 && breaks<5){
            for (int i = 0; i < breaks; i++) {
                breaksPlusBtn.click();
            }
        }

        wageEdit.click();
        type(wageInput,String.valueOf(event.getWage()));
        wageSave.click();
        confirmCreation.click();
        return new HomeScreen(driver);
    }
}
