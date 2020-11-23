package steps;

import PageObjects.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps  {

    @Step("выбран раздел {0}")
    public void GoToMarket(String menuItem){
        new MainPage().GoToMarket(menuItem);
    }

}
