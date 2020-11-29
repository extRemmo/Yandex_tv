package steps;

import PageObjects.BasePageObject;
import PageObjects.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MarketPageSteps extends BasePageObject {

    @Step("заголовок страницы {0}")
    public void checkPageTitle(String expectedTitle){
        ArrayList<String> tabs2 = new ArrayList<>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs2.get(1));
        String actualTitle = new MarketPage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выбрано меню {0}")
    public void ElectronicMenu(String menuItem){
        new MarketPage().ElectronicMenu(menuItem);
    }

    @Step("заголовок страницы {0}")
    public void checkTitleElectronicMenu(String expectedTitle){
        String actualTitle = new MarketPage().SubMenu(expectedTitle).getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выбрано подменю {0}")
    public void TVMenu(String titleName, String menuItem){
        new MarketPage().TVMenu(titleName, menuItem);
    }

    @Step("кликнуто по кнопке {0}")
    public void AllFilters(String menuItem){
        new MarketPage().AllFilters(menuItem);
    }

}
