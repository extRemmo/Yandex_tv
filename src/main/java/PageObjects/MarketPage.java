package PageObjects;

import junit.runner.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MarketPage extends BasePageObject {

    @FindBy(xpath = "//span[@class='titleElemWrapper']/h3")
    public WebElement title;

    @FindBy (xpath = "//div[@data-tid]/div/div/div/div[@data-apiary-widget-name]/div/div/div/div/div/div[3]/div[1]/a")
    public WebElement subtitle;

    @FindBy(xpath = "//div[@role]")
    WebElement tabList;

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void ElectronicMenu(String menuItem){
        tabList.findElement(By.xpath(".//span[contains(text(), '"+menuItem+"')]")).click();
    }

    public void TVMenu(String menuItem){
        WebElement tvMenu = BaseSteps.getDriver().findElement(By.xpath(".//*[text()='"+menuItem+"']"));
        tvMenu.click();
    }
    public void AllFilters(String menuItem){
        WebElement filter = BaseSteps.getDriver().findElement(By.xpath(".//*[text()='"+menuItem+"']"));
        filter.click();
    }

}
