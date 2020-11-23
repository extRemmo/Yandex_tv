package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.assertEquals;


public class TVsPage extends BasePageObject {


    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/HeaderSearch']")
    WebElement searchField;

    @FindBy(xpath = "//div[text()='Найти']")
    WebElement searchBtn;

    public TVsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void setCountOfElement(int count) {
        //найти кнопку - выпадающий список для количесва товаров на странице (12 или 48)
        WebElement countOfElement = BaseSteps.getDriver().findElement(By.xpath("//button[contains(@id,'dropdown-control')]"));
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(countOfElement));
        Actions act = new Actions(BaseSteps.getDriver());
        act.moveToElement(countOfElement).click().build().perform();
        // выбрать соотв-й вариант по 12 или 48 позиций на странице
        WebElement setCount = BaseSteps.getDriver().findElement(By.xpath("//button[contains(text(),'Показывать по " + count + "')]"));
        Actions act2 = new Actions(BaseSteps.getDriver());
        act2.moveToElement(setCount).click().build().perform();
    }

    public void isCorrectCountOfTV(int rows) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@data-zone-name='snippetList']/article"), 12));
        WebElement countOfTV = BaseSteps.getDriver().findElement(By.xpath("//div[@data-zone-name='snippetList']"));
        int numberOfChild = Integer.parseInt(countOfTV.getAttribute("childElementCount"));
        assertEquals(numberOfChild, rows);
    }

    public String takePositionName(int position) {
        String item = BaseSteps.getDriver().findElement(By.xpath("//div[@data-zone-name='snippetList']/article[" + position + "]//a[@title]")).getText();
        System.out.println(item);
        return item;
    }

    public void fillField(String fieldName, String myNewTV) {
        searchField.findElement(By.xpath(".//*[@placeholder='" + fieldName + "']")).sendKeys(myNewTV);
        Actions act = new Actions(BaseSteps.getDriver());
        act.moveToElement(searchBtn).click().build().perform();
    }

    public void checkPosition(String value) {
        assertEquals(value, BaseSteps.getDriver().findElement(By.xpath("//div[@data-zone-name='snippetList']/article[1]//a[@title]")).getText());
    }

}
