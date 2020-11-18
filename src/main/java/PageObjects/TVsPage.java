package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class TVsPage extends BasePageObject {

    private final WebDriver driver;

    @FindBy(xpath = "//form/div[1]")
    WebElement searchField;

    @FindBy(xpath = "//form/div[2]//button")
    WebElement searchBtn;

    public TVsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCountOfElement (String count){
        WebElement countOfElement = driver.findElement(By.xpath("//button[contains(@id,'dropdown-control')]"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(countOfElement));
        Actions act= new Actions(driver);
        act.moveToElement(countOfElement).click().build().perform();

        /* trigger = driver.findElement(By.xpath("//button[@aria-expanded='true']"));
        String clsVal = trigger.getAttribute("aria-expanded");
        if (clsVal.equals("true")) {*/
        WebElement setCount = driver.findElement(By.xpath("//button[contains(text(),'Показывать по " + count + "')]"));
        Actions act2= new Actions(driver);
        act2.moveToElement(setCount).click().build().perform();
    }

    public boolean isCorrectCountOfTV(int rows){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@data-zone-name='snippetList']/article"),12));
        WebElement countOfTV = driver.findElement(By.xpath("//div[@data-zone-name='snippetList']"));
        int numberOfChild = Integer.parseInt(countOfTV.getAttribute("childElementCount"));
        System.out.println(numberOfChild);
        return rows == numberOfChild;
    }

    public String takePositionName (int position) {
        String item = driver.findElement(By.xpath("//div[@data-zone-name='snippetList']/article["+position+"]//a[@title]")).getText();
        System.out.println(item);
        return item;
    }

    public void fillField(String fieldName, String myNewTV) {
        searchField.findElement(By.xpath(".//input[@placeholder='"+fieldName+"']")).sendKeys(myNewTV);
        Actions act= new Actions(driver);
        act.moveToElement(searchBtn).click().build().perform();
    }

    public void checkPosition(String value) {
        assertEquals(value, driver.findElement(By.xpath("//div[@data-zone-name='SearchSerp']//div[@id='1-0']/div/div/div[1]/div/div/div/div/div[1]/a/div[2]/div[4]//span")).getText());
    }

}
