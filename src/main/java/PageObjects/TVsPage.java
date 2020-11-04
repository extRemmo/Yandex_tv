package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TVsPage extends BasePageObject {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/HeaderSearch']")
    WebElement searchField;

    @FindBy(xpath = "//div[text()='Найти']")
    WebElement searchBtn;

    public TVsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCountOfElement (String count){
        WebElement countOfElement = driver.findElement(By.xpath("//button[contains(@id,'dropdown-control')]"));
        Actions act= new Actions(driver);
        act.moveToElement(countOfElement).click().build().perform();
        WebElement setCount = driver.findElement(By.xpath("//button[contains(text(),'Показывать по "+count+"')]"));
        setCount.click();
    }

    public boolean isCorrectCountOfTV(int rows){
        WebElement countOfTV = driver.findElement(By.xpath("//div[@data-zone-name='snippetList']"));
        int numberOfChild = Integer.parseInt(countOfTV.getAttribute("childElementCount"));
        System.out.println(numberOfChild);
        if (rows == numberOfChild){
            return true;
        }
        return false;
    }

    public String takePositionName (int position) {
        String item = driver.findElement(By.xpath("//div[@data-zone-name='snippetList']/article["+position+"]//a[@title]")).getText();
        System.out.println(item);
        return item;
    }

    public void fillField(String fieldName, String myNewTV) {
        searchField.findElement(By.xpath(".//*[@placeholder='"+fieldName+"']")).sendKeys(myNewTV);
        //fillField(searchField, myNewTV);
       // WebElement searchBtn = driver.findElement(By.xpath("//div[text()='Найти']"));
        Actions act= new Actions(driver);
        act.moveToElement(searchBtn).click().build().perform();
    }

    /*protected void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }*/
}
