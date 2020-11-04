package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersPage {

    private final WebDriver driver;
    @FindBy(xpath = ".//div[@data-filter-id='glprice']//div[@data-prefix='от']/input")
    public WebElement fromBtn;

    @FindBy(xpath = ".//div[@data-filter-id='glprice']//div[@data-prefix='до']/input")
    public WebElement toBtn;

    public FiltersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        WebElement manufacturer = driver.findElement(By.xpath("//input[@value='"+menuItem+"']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manufacturer);
        try{
            manufacturer.click();
        }catch (WebDriverException e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", manufacturer);
        }
        /*Actions act= new Actions(driver);
        act.moveToElement(manufacturer).click().build().perform();
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(manufacturer));*/
    }


    public void ShowResult(String menuItem){
        WebElement showResult = driver.findElement(By.xpath("//a[contains(text(),'"+menuItem+"')]"));
        Actions act= new Actions(driver);
        act.moveToElement(showResult).click().build().perform();
    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }

}
