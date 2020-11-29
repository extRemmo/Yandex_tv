package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steps.BaseSteps;

public class MarketPage extends BasePageObject {

    private WebElement subtitle;

    @FindBy(xpath = "//span[@class='titleElemWrapper']/h3")
    public WebElement title;

    @FindBy(xpath = "//div[@role]")
    WebElement tabList;

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void ElectronicMenu(String menuItem){
        tabList.findElement(By.xpath(".//span[contains(text(), '"+menuItem+"')]")).click();
    }

    public WebElement SubMenu (String submenu){
        subtitle = BaseSteps.getDriver().findElement(By.xpath("//div[@data-tid]/div/div/div/div[@data-apiary-widget-name]/div/div/div/div/div/div/div/a[text()='"+submenu+"']"));
        return  subtitle;
    }

    public void TVMenu(String titlename, String menuItem){
        SubMenu(menuItem).findElement(By.xpath("./../following-sibling::div//*[text()='"+titlename+"']")).click();
    }
    public void AllFilters(String menuItem){
        WebElement filter = BaseSteps.getDriver().findElement(By.xpath(".//*[text()='"+menuItem+"']"));
        filter.click();
    }

}
