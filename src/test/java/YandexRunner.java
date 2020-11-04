import PageObjects.FiltersPage;
import PageObjects.MainPage;
import PageObjects.MarketPage;
import PageObjects.TVsPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class YandexRunner extends BaseTest {

    @Test
    public void YandexTVTest() {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        MarketPage marketPage = new MarketPage(driver);
        FiltersPage filtersPage = new FiltersPage(driver);
        TVsPage tVsPage = new TVsPage(driver);

        mainPage.GoToMarket("Маркет");
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        marketPage.ElectronicMenu("Электроника");
        marketPage.TVMenu("Телевизоры");
        marketPage.AllFilters("Все фильтры");
        filtersPage.fillField("от","20000");
        filtersPage.Manufacturer("LG");
        filtersPage.Manufacturer("Samsung");
        filtersPage.ShowResult("Показать");
        tVsPage.setCountOfElement("12");
        if (tVsPage.isCorrectCountOfTV(12))  {
            String myNewTV = tVsPage.takePositionName(1);
            tVsPage.fillField("Искать товары и магазины", myNewTV);
            tVsPage.checkPosition(myNewTV);
        } else System.out.println("получено не 12 строк");
        //System.out.println(tVsPage.isCorrectCountOfTV(48));
        //System.out.println(driver.getTitle());

    }
}