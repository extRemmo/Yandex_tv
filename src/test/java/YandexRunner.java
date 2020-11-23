import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features = {"src/test/resources/features"},
        plugin = {"util.AllureReporter"})
public class YandexRunner {

}
/*
public class YandexRunner extends BaseTest {


    MainPageSteps mainPageSteps = new MainPageSteps();
    MarketPage marketPage = new MarketPage(driver);
    FiltersPage filtersPage = new FiltersPage(driver);
    TVsPage tVsPage = new TVsPage(driver);

    @Test
    @DisplayName("Поиск Телевизора с помощью фильтрации")

    public void YandexTVTest() throws InterruptedException {

        mainPageSteps.GoToMarket("Маркет");
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(8000);
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
*/
