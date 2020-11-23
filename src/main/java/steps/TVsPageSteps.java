package steps;

import PageObjects.TVsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TVsPageSteps {

    @Step("нажата кнопка Показывать по {0}")
    public void setCountOfElement(int count){
        new TVsPage().setCountOfElement(count);
    }

    @Step("позиций на странице {0}")
    public void isCorrectCountOfTV(int count){
        new TVsPage().isCorrectCountOfTV(count);
    }
}
