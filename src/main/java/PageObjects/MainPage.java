package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {
    @FindBy(xpath = "//div[@class='services-new__list']")
    WebElement servicesMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void GoToMarket(String menuItem){
        servicesMenu.findElement(By.xpath(".//div[contains(text(), '"+menuItem+"')]")).click();
    }

}
