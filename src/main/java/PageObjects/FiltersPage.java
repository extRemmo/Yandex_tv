package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class FiltersPage extends BasePageObject {

    @FindBy (xpath = "//h1")
    public WebElement title;

    @FindBy(xpath = ".//div[@data-filter-id='glprice']//div[@data-prefix='от']/input")
    public WebElement fromBtn;

    @FindBy(xpath = ".//div[@data-filter-id='glprice']//div[@data-prefix='до']/input")
    public WebElement toBtn;

    public FiltersPage()  {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "от":
                fillField(fromBtn, value);
                break;
            case "до":
                fillField(toBtn, value);
                break;
        }
    }
    public void Manufacturer(String menuItem){
        WebElement manufacturer = BaseSteps.getDriver().findElement(By.xpath("//input[@value='"+menuItem+"']"));
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", manufacturer);
        try{
            manufacturer.click();
        }catch (WebDriverException e){
            ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].click();", manufacturer);
        }
    }


    public void ShowResult(String menuItem){
        WebElement showResult = BaseSteps.getDriver().findElement(By.xpath("//a[contains(text(),'"+menuItem+"')]"));
        Actions act= new Actions(BaseSteps.getDriver());
        act.moveToElement(showResult).click().build().perform();
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }

}
