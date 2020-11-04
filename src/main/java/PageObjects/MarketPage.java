package PageObjects;

import junit.runner.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPage {

    private final WebDriver driver;
    @FindBy(xpath = "//div[@role]")
    WebElement tabList;


    public MarketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ElectronicMenu(String menuItem){
        tabList.findElement(By.xpath(".//span[contains(text(), '"+menuItem+"')]")).click();
    }

    public void TVMenu(String menuItem){
        WebElement tvMenu = driver.findElement(By.xpath(".//*[text()='"+menuItem+"']"));
        tvMenu.click();
    }
    public void AllFilters(String menuItem){
        WebElement filter = driver.findElement(By.xpath(".//*[text()='"+menuItem+"']"));
        filter.click();
    }

}
