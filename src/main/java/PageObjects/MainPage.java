package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//div[@class='services-new__list']")
    WebElement servicesMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void GoToMarket(String menuItem){
        servicesMenu.findElement(By.xpath(".//div[contains(text(), '"+menuItem+"')]")).click();
    }


}
