package steps;

import PageObjects.FiltersPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class FiltersPageSteps {

    @Step("название страницы {0}")
    public void checkTitleFiltersPage(String expectedTitle){
        String actualTitle = new FiltersPage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
    @Step("установлен фильтр цены от {0}")
    public void priceFilter(String menuItem, String price){
        new FiltersPage().fillField(menuItem, price);
    }

    @Step("выбран производитель {0}")
    public void Manufacturer(String menuItem){
        new FiltersPage().Manufacturer(menuItem);
    }

    @Step("нажата кнопка {0}")
    public void ShowResult(String menuItem){
        new FiltersPage().ShowResult(menuItem);
    }
}
