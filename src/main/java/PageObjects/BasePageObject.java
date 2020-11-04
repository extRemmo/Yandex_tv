package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.click();
        field.sendKeys(value);
    }

    public void clickAction (WebElement button){
        Actions act= new Actions(BaseSteps.getDriver());
        act.moveToElement(button).click().build().perform();
    }
}
